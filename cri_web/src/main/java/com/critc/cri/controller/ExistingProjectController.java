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
import com.critc.sys.model.SysRole;

import com.critc.sys.vo.SysRoleSearchVO;
import com.critc.util.page.PageNavigate;
import com.critc.util.string.BackUrlUtil;
import com.critc.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/cri/existingProject")
@Controller
public class ExistingProjectController {
    @Autowired
    private ExistingProjectService existingProjectService;
    /**
     * 全局参数配置
     */
    @Autowired
    private PubConfig pubConfig;

    /**
     * what:    自动补全主页
     * when:    请求访问自动补全主页时
     *
     * @return index
     *
     * @author 杨超凡 created on 2017年11月2日
     */
//    @RequestMapping("/index")
//    private String index() {
//        return "cri/existingProject/index";
//    }

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response, ExistingProjectSearchVO existingProjectSearchVO) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/cri/existingProject/index");
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
     *
     * what: 设置分页url，一般有查询条件的才会用到
     *
     * @param existingProjectSearchVO 查询条件
     * @return url
     *
     * @author 李红 created on 2017年11月6日
     */
    private String createUrl(ExistingProjectSearchVO existingProjectSearchVO) {
        //String url = pubConfig.getDynamicServer() + "/sys/role/index.htm?";
        String url = pubConfig.getDynamicServer() + "/cri/existingProject/index.htm?";

        // 如果为模糊查询，要把该字段encode
        if (StringUtil.isNotNullOrEmpty(existingProjectSearchVO.getName())) {
            url += "&name=" + existingProjectSearchVO.getName();
        }
        return url;
    }
}
