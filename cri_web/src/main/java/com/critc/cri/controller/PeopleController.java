/**
 * Copyright 2017 弘远技术研发中心. All rights reserved
 * Project Name:cdpf_v1
 * Module Name:web
 */
package com.critc.cri.controller;

import com.critc.cri.model.People;
import com.critc.cri.service.PeopleService;
import com.critc.sys.model.SysUser;
import com.critc.util.string.BackUrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * what:    信息化项目controller
 *
 * @author 杨超凡 created on 2017年10月23日
 */
@RequestMapping("/cri/people")
@Controller
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    /**
     * what:    自动补全主页
     * when:    请求访问自动补全主页时
     *
     * @return index
     *
     * @author 杨超凡 created on 2017年11月2日
     */
    @RequestMapping("/index")
    private String index() {
        return "cri/people/index";
    }

    @RequestMapping("/detail")
    private ModelAndView detail(int id) {
        People people = peopleService.get(id);

        ModelAndView mv = new ModelAndView();
        mv.addObject("people", people);
        mv.setViewName("/cri/people/detail");
        return mv;
    }
}
