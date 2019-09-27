package com.critc.cri.controller;

/**
 * Created by LXY777 on 2019-08-22.
 */

import com.critc.core.pub.PubConfig;
import com.critc.cri.dao.RiopiDao;
import  com.critc.cri.service.RiopiService;
import  com.critc.cri.model.Riopi;
import  com.critc.cri.vo.RiopiSearchVO;
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



@RequestMapping("/cri/Riopi")
@Controller
public class RiopiController {

    /**
     * 资源Service
     */
    @Autowired
    private RiopiService riopiService;

    /**
     * 全局参数配置
     */
    @Autowired
    private PubConfig pubConfig;
    /**
     *
     *
     *
     * what: 进入角色维护界面
     *
     * @param
     * @param
     * @param
     * @return 到角色首页
     *
     * @author
     */
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response, RiopiSearchVO  riopiSearchVO) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/cri/Riopi/index");
        String url = pubConfig.getDynamicServer() + "/cri/Riopi/index.htm?";
        // 获取查询总数
        int recordCount = riopiService.count(riopiSearchVO);
        List<Riopi> list = riopiService.list(riopiSearchVO);
        // 定义分页对象
        PageNavigate pageNavigate = new PageNavigate(url, riopiSearchVO.getPageIndex(), recordCount);
        // 设置分页的变量
        mv.addObject("pageNavigate", pageNavigate);
        mv.addObject("list", list);
        mv.addObject("backUrl", StringUtil.encodeUrl(url));
        return mv;
    }
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        // 部门列表
        mv.setViewName("/cri/Riopi/add");
        // 设置返回的url
        Riopi riopi = new Riopi();
        mv.addObject("riopi", riopi);
        BackUrlUtil.setBackUrl(mv, request);
        return mv;
    }

    /**
     *
     * what: 到修改部门页面
     *
     * @param request request
     * @param response response
     * @param id 部门id
     * @return 到修改部门页面
     *
     * @author
     */
    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(HttpServletRequest request, HttpServletResponse response, int id) {
        ModelAndView mv = new ModelAndView();
        Riopi riopi = riopiService.get(id);
        mv.addObject("riopi", riopi);
        mv.setViewName("/cri/Riopi/update");
        // 设置返回的url
        BackUrlUtil.setBackUrl(mv, request);
        return mv;
    }

    /**
     *
     * what: 新增部门
     *
     * @param request request
     * @param response response
     * @param
     * @return 到操作提示页面
     *
     * @author 李红 created on 2017年10月30日
     */
    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response, @Valid Riopi riopi) {

        int flag = riopiService.add(riopi);
        if (flag == 0) {
            // msg=" + StringUtil.encodeUrl("部门新增失败");
            return "forward:/error.htm?resultCode=" + GlobalCode.OPERA_FAILURE;
        }
        else if (flag == 2) {
            // msg=" + StringUtil.encodeUrl("部门名称已存在！");
            return "forward:/error.htm?resultCode=20003";
        }
        else {
            // msg=" + StringUtil.encodeUrl("部门新增成功");
            return "forward:/success.htm?resultCode=" + GlobalCode.SAVE_SUCCESS;
        }
    }

    /**
     *
     * what: 修改部门
     *
     * @param request request
     * @param response response
     * @param
     * @return 到操作提示页面
     *
     * @author 李红 created on 2017年10月30日
     */
    @RequestMapping("/update")
    public String update(HttpServletRequest request, HttpServletResponse response, @Valid Riopi riopi) {

            int flag = riopiService.update(riopi);
           if (flag == 0) {
               // 部门修改失败
               return "forward:/error.htm?resultCode=" + GlobalCode.OPERA_FAILURE;
            }
            else if (flag == 2) {
                // 存在相同的部门名称，不能修改
                return "forward:/error.htm?resultCode=20003";
            }
            else {
                // 部门修改成功
                return "forward:/success.htm?resultCode=" + GlobalCode.SAVE_SUCCESS;
            }
    }

    /**
     *
     * what: 删除部门
     *
     * @param request request
     * @param response response
     * @param id 部门id
     * @return 到操作提示页面
     *
     * @author 李红 created on 2017年10月30日
     */
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, HttpServletResponse response, int id) {
        int flag = riopiService.delete(id);
        if (flag == 0) {
            // 删除失败
            return "forward:/error.htm?resultCode=" + GlobalCode.OPERA_FAILURE;
        }
        else if (flag == 2) {
            // 还有下级部门，不能删除
            return "forward:/error.htm?resultCode=20107";
        }
        else {
            // 删除成功
            return "forward:/success.htm?resultCode=" + GlobalCode.DELETE_SUCCESS;
        }
    }

}
