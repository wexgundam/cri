/**
 * Copyright 2017 弘远技术研发中心. All rights reserved
 * Project Name:cdpf_v1
 * Module Name:web
 */
package com.critc.cri.controller;

import com.critc.core.pub.PubConfig;
import com.critc.cri.model.ExistingProject;
import com.critc.cri.service.ExistingProjectService;
import com.critc.cri.vo.ExistingProjectSearchVO;

import com.critc.sys.service.SysResourceService;

import com.critc.util.code.GlobalCode;
import com.critc.util.page.PageNavigate;
import com.critc.util.session.SessionUtil;
import com.critc.util.string.BackUrlUtil;
import com.critc.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/cri/existingproject")
@Controller
public class ExistingProjectController{
    @Autowired
    private ExistingProjectService existingProjectService;
    /**
     * 全局参数配置
     */
    @Autowired
    private PubConfig pubConfig;

    /**
     * 资源Service
     */
    @Autowired
    private SysResourceService sysResourceService;
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
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response, ExistingProjectSearchVO existingProjectSearchVO) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/cri/existingproject/index");
        // 获取查询总数
        int recordCount = existingProjectService.count(existingProjectSearchVO);
        String url = createUrl(existingProjectSearchVO);
        // 定义分页对象
        PageNavigate pageNavigate = new PageNavigate(url, existingProjectSearchVO.getPageIndex(), recordCount);
        List<ExistingProject> list = existingProjectService.list(existingProjectSearchVO);
        // 设置分页的变量
        mv.addObject("pageNavigate", pageNavigate);
        mv.addObject("list", list);
        // 设置返回url
        BackUrlUtil.createBackUrl(mv, request, url);
        return mv;
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
     *
     * what: 新增角色
     *
     * @param request request
     * @param
     * @return 到新增界面
     * @author 卢薪竹
     */
    @RequestMapping("/toAdd")
        public ModelAndView toAdd(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/cri/existingproject/add");
        // 设置返回的url
        BackUrlUtil.setBackUrl(mv, request);
        return mv;
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
        mv.addObject("existingProject", existingProject);
        mv.setViewName("/cri/existingproject/update");
        // 设置返回的url
        BackUrlUtil.setBackUrl(mv, request);
        return mv;
    }
    /**
     *
     * what: 新增角色
     *
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
        existingProject.setCreatorId(SessionUtil.getUserId(request));
        existingProject.setCreatorRealName(SessionUtil.getUserRealName(request));
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
     *
     * what: 修改角色
     *
     * @param request request
     * @param response response
     * @param
     * @return 到操作提示页面
     *
     * @author 孔垂云 created on 2017年11月6日
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
     * what: 删除角色
     * @param id 角色id
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