package com.critc.cri.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Null;

import com.critc.core.pub.PubConfig;
import com.critc.cri.model.ExistingProject;
import com.critc.cri.model.RailwayInformationSystem;

import com.critc.cri.model.Riopi;
import com.critc.cri.service.ExistingProjectService;
import com.critc.cri.service.RiopiService;
import com.critc.cri.service.RailwayInformationSystemService;
import com.critc.cri.vo.ExistingProjectSearchVO;

import com.critc.sys.service.SysDepartmentService;
import com.critc.sys.service.SysDicService;

import com.critc.sys.vo.SysReleaseSearchVO;
import com.critc.util.code.GlobalCode;
import com.critc.util.json.JsonUtil;
import com.critc.util.page.PageNavigate;
import com.critc.util.session.SessionUtil;
import com.critc.util.string.BackUrlUtil;
import com.critc.util.string.StringUtil;
import com.critc.util.web.WebUtil;
import com.sun.tools.internal.xjc.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.security.x509.AttributeNameEnumeration;


import java.net.URL;
import java.util.List;
import java.util.Map;

@RequestMapping("/cri/existingproject")
@Controller
public class ExistingProjectController{
    @Autowired
    private ExistingProjectService existingProjectService;
    /**
     * 全局参数配置
     */
    @Autowired
    private  RiopiService riopiService;

    @Autowired
    private PubConfig pubConfig;
    /**
     * 部门下拉菜单
     */
    @Autowired
    private SysDepartmentService sysDepartmentService;
    /**
     * 信息系统Service
     */
    @Autowired
    private RailwayInformationSystemService railwayInformationSystemService;
    /**
     * 字典Sevice
     */
    @Autowired
    private SysDicService sysDicService;
    /**
     * what: 自动补全主页
     * when: 请求访问自动补全主页时
     *
     * @param : * @param null
     * @return: index
     * @Description :
     * @author 卢薪竹 created by 8:57 2019/8/28
     */
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response, ExistingProjectSearchVO existingProjectSearchVO,@Valid RailwayInformationSystem railwayInformationSystem,ExistingProject existingProject) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/cri/existingproject/index");
        // 获取查询总数
        int recordCount = existingProjectService.count(existingProjectSearchVO);
        String url = createUrl(existingProjectSearchVO);
        // 定义分页对象
        PageNavigate pageNavigate = new PageNavigate(url, existingProjectSearchVO.getPageIndex(), recordCount);
        List<ExistingProject> list = existingProjectService.list(existingProjectSearchVO);
        // 信息化目录和信息系统总表ztree
        String ztree = existingProjectService.createZtreeByModule();// 信息系统列表
        // 设置分页的变量
        mv.addObject("pageNavigate", pageNavigate);
        mv.addObject("list", list);
        mv.addObject("listProjectType", sysDicService.getByCategory("PROJECT_TYPE"));
        mv.addObject("listProjectProgress", sysDicService.getByCategory("PROJECT_PROGRESS"));
        mv.addObject("listNetworkSecurity", sysDicService.getByCategory("NETWORK_SECURITY"));
        mv.addObject("ztree",ztree);
        // 设置返回url
        BackUrlUtil.createBackUrl(mv, request, url);
        return mv;
    }
    @RequestMapping("/importData")
    public void exportList(HttpServletRequest request, HttpServletResponse response,
                           int no, int riopiId, String riopiName) {
          Map<String, String> map  = existingProjectService.importData(no,riopiId,riopiName);
          WebUtil.out(response, JsonUtil.toStr(map));
    }

    @RequestMapping("/updateData")
    public void updateList(HttpServletRequest request, HttpServletResponse response,
                           int no, int riopiId, String riopiName) {

          existingProjectService.updateData(no,riopiId,riopiName);

    }

    /**
     * what: 设置分页url，一般有查询条件的才会用到
     * @param : existingProjectSearchVO 查询条件
     * @return: url
     * @Description :
     * @author 卢薪竹 created by 8:58 2019/8/28
     */
    private String createUrl(ExistingProjectSearchVO existingProjectSearchVO) {
        String url = pubConfig.getDynamicServer() + "/cri/existingproject/index.htm?";
        // 如果为模糊查询，要把该字段encode
        if (StringUtil.isNotNullOrEmpty(existingProjectSearchVO.getName())) {
            url += "&name=" + existingProjectSearchVO.getName();
        }
        return url;
    }
   /**
     * what: 新增
     * @param request request
     * @return 到新增界面
     * @author 卢薪竹
     */
    @RequestMapping("/toAdd")
        public ModelAndView toAdd(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        ExistingProject existingProject = new ExistingProject();
        // 添加字典 项目类型 / 进度编码 / 网络安全等级
        mv.addObject("listProjectType", sysDicService.getByCategory("PROJECT_TYPE"));
        mv.addObject("listProjectProgress", sysDicService.getByCategory("PROJECT_PROGRESS"));
        mv.addObject("listNetworkSecurity", sysDicService.getByCategory("NETWORK_SECURITY"));
        mv.setViewName("/cri/existingproject/add");
        //获取总列表
        String ztreeRis = existingProjectService.createZtreeByModule();
        mv.addObject("ztreeRis", ztreeRis);
        //获取建设单位zTree
        String ztreeConstructionDepartment = sysDepartmentService.createZtreeByModule();
        mv.addObject("ztreeConstructionDepartment", ztreeConstructionDepartment);
        // 设置返回的url：方法1
        //  BackUrlUtil.setBackUrl(mv, request);
        //  return mv;
        // 设置返回的url：方法2
        mv.addObject("existingProject",existingProject);
        BackUrlUtil.setBackUrl(mv, request);
        return mv;
    }
    /**
     *
     * what: 新增
     * @param request request
     * @param response response
     * @param
     * @return 到操作提示页面
     *
     * @author
     */
    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response, @Valid ExistingProject existingProject) {
        // 创建人
        //existingProject.setCreatorId(SessionUtil.getUserId(request));
        //existingProject.setCreatorRealName(SessionUtil.getUserRealName(request));
        // 修改人
        existingProject.setLastEditorId(SessionUtil.getUserId(request));
        existingProject.setLastEditorRealName(SessionUtil.getUserRealName(request));
        // 是否可删除
        existingProject.setDeletable(1);
        int flag = existingProjectService.add(existingProject);
        if (flag == 0) {
            // 角色新增失败
            return "forward:/error.htm?resultCode=" + GlobalCode.OPERA_FAILURE;
        } else if (flag == 2) {
            // msg=" + StringUtil.encodeUrl("角色名称已存在！");
            return "forward:/error.htm?resultCode=20004";
        } else {
            // 角色新增成功
            return "forward:/success.htm?resultCode=" + GlobalCode.SAVE_SUCCESS;
        }
    }
    /**
     * what: 修改既有信息系统
     * @param request request
     * @param response response
     * @param id
     * @return 到修改页面
     * @author
     */
    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(HttpServletRequest request, HttpServletResponse response, int id) {
        ModelAndView mv = new ModelAndView();
        ExistingProject existingProject = existingProjectService.get(id);
        // 添加字典 项目类型 / 进度编码 / 网络安全等级
        mv.addObject("listProjectType", sysDicService.getByCategory("PROJECT_TYPE"));
        mv.addObject("listProjectProgress", sysDicService.getByCategory("PROJECT_PROGRESS"));
        mv.addObject("listNetworkSecurity", sysDicService.getByCategory("NETWORK_SECURITY"));
        //获取总列表
        String ztreeRis = existingProjectService.createZtreeByModule();
        mv.addObject("ztreeRis", ztreeRis);
        //获取建设单位zTree
        String ztreeConstructionDepartment = sysDepartmentService.createZtreeByModule();
        mv.addObject("ztreeConstructionDepartment", ztreeConstructionDepartment);
        mv.addObject("existingProject", existingProject);
        mv.setViewName("/cri/existingproject/update");
        // 设置返回的url
        BackUrlUtil.setBackUrl(mv, request);
        return mv;
    }

    /**
     *
     * what: 修改
     *
     * @param request request
     * @param response response
     * @param
     * @return 到操作提示页面
     *
     * @author
     */
    @RequestMapping("/update")
    public String update(HttpServletRequest request, HttpServletResponse response, @Valid ExistingProject existingProject) {
        // 修改人
        existingProject.setLastEditorId(SessionUtil.getUserId(request));
        existingProject.setLastEditorRealName(SessionUtil.getUserRealName(request));
        int flag = existingProjectService.update(existingProject);
        if (flag == 0) {
            // 角色修改失败
            return "forward:/error.htm?resultCode=" + GlobalCode.OPERA_FAILURE;
        } else if (flag == 2) {
            // 存在相同的角色名称，不能修改
            return "forward:/error.htm?resultCode=20004";
        } else {
            // 角色修改成功
            return "forward:/success.htm?resultCode=" + GlobalCode.SAVE_SUCCESS;
        }
    }
    /**
     *
     * what: 删除
     * @param
     * @return 到操作提示页面
     *
     * @author
     */
    @RequestMapping("/delete")
    public String delete(int id) {
        int flag = existingProjectService.delete(id);
        if (flag == 0) {
            // 删除失败
            return "forward:/error.htm?resultCode=" + GlobalCode.OPERA_FAILURE;
        } else {
            // 删除成功
            return "forward:/success.htm?resultCode=" + GlobalCode.DELETE_SUCCESS;
        }
    }

}