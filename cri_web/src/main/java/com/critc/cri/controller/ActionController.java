/**
 * Copyright 2019 信息公司. All rights reserved
 * Project Name:cri
 * Module Name:web
 */
package com.critc.cri.controller;

import com.critc.core.pub.PubConfig;
import com.critc.cri.model.Action;
import com.critc.cri.service.ActionService;
import com.critc.cri.vo.ActionSearchVO;
import com.critc.util.page.PageNavigate;
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

/**
 * 
 * what:    信息化项目controller
 *
 * @author rs created on 2019年08月28日
 */
@RequestMapping("/cri/action")
@Controller
public class ActionController {
	/**
	 * 信息系统Service
	 */
	@Autowired
	private ActionService actionService;


	@Autowired
	private PubConfig pubConfig;

	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,ActionSearchVO actionSearchVO) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/cri/action/index");
		// 获取查询总数
		int recordCount = actionService.count(actionSearchVO);
		List<Action> list = actionService.list(actionSearchVO);
		//	List<RailwayInformationSystemSearchVO> listCombo = systemInfoService.listCombo();
		// 把获取的记录放到mv里面
		String url = pubConfig.getDynamicServer() + "/cri/action/index.htm?";
		// 定义分页对象
		PageNavigate pageNavigate = new PageNavigate(url, actionSearchVO.getPageIndex(), recordCount);
		// 设置分页的变量
		mv.addObject("pageNavigate", pageNavigate);
		mv.addObject("backUrl", StringUtil.encodeUrl(url));
		//	mv.addObject("listContent", riopiService.listCombo());// 信息系统列表
		mv.addObject("list", list);
		return mv;
	}

}
