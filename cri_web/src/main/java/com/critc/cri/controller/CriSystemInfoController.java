/**
 * Copyright 2019 信息公司. All rights reserved
 * Project Name:cri
 * Module Name:web
 */
package com.critc.cri.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.critc.core.pub.PubConfig;
import com.critc.util.code.GlobalCode;
import com.critc.util.session.SessionUtil;
import com.critc.util.string.BackUrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.critc.cri.model.SystemInfo;
import com.critc.cri.service.SystemInfoService;
import com.critc.util.string.StringUtil;

/**
 * 
 * what:    信息化项目controller
 *
 * @author 戎珊 created on 2019年08月28日
 */
@RequestMapping("/cri/railwaysysteminfo")
@Controller
public class CriSystemInfoController {
	/**
	 * 信息系统Service
	 */
	@Autowired
	private SystemInfoService systemInfoService;
	/**
	 * 全局参数配置
	 */
	@Autowired
	private PubConfig pubConfig;
	/**
	 * 
	 * what:    自动补全主页
	 * when:    请求访问自动补全主页时
	 * 
	 * @return index
	 *
	 * @author 戎珊 created on 2019年08月28日
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/cri/railwaysysteminfo/index");
		List<SystemInfo> list = systemInfoService.list();
		// 把获取的记录放到mv里面
		String url = pubConfig.getDynamicServer() + "/cri/railwaysysteminfo/index.htm?";
		mv.addObject("backUrl", StringUtil.encodeUrl(url));
		mv.addObject("list", list);
		return mv;
	}

	/**
	 *
	 * what: 到修改页面
	 *
	 * @param request request
	 * @param response response
	 * @param id id
	 * @return 到修改页面
	 *
	 * @author 戎珊 created on 2019年08月28日
	 */
	@RequestMapping("/toUpdate")
	public ModelAndView toUpdate(HttpServletRequest request, HttpServletResponse response, int id) {
		ModelAndView mv = new ModelAndView();
		SystemInfo systemInfo = systemInfoService.get(id);
		mv.addObject("systeminfo", systemInfo);
		mv.setViewName("/cri/railwaysysteminfo/update");
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
	 * @param systemInfo systemInfo
	 * @return 到操作提示页面
	 *
	 * @author 戎珊 created on 2019年08月28日
	 */
	@RequestMapping("/update")
	public String update(HttpServletRequest request, HttpServletResponse response, @Valid SystemInfo systemInfo) {

		int flag = systemInfoService.update(systemInfo);
		if (flag == 0) {
			// 修改失败
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
	 * what: 到新增页面
	 *
	 * @param request request
	 * @param response response
	 * @return 到新增页面
	 *
	 * @author 戎珊 created on 2019年08月28日
	 */
	@RequestMapping("/toAdd")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		// 部门列表
	//	mv.addObject("listType", sysDicService.getByCategory("DEPARTMENT_TYPE"));
		mv.setViewName("/cri/railwaysysteminfo/add");
		// 设置返回的url
		SystemInfo systemInfo = new SystemInfo();
		mv.addObject("sysDepartment", systemInfo);
		BackUrlUtil.setBackUrl(mv, request);
		return mv;
	}
	/**
	 *
	 * what: 新增系统
	 *
	 * @param request request
	 * @param response response
	 * @param
	 * @return 到操作提示页面
	 *
	 * @author 戎珊 created on 2019年08月28日
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response, @Valid SystemInfo systemInfo) {

		int flag = systemInfoService.add(systemInfo);
		if (flag == 0) {
			// msg=" + StringUtil.encodeUrl("系统新增失败");
			return "forward:/error.htm?resultCode=" + GlobalCode.OPERA_FAILURE;
		}
		else if (flag == 2) {
			// msg=" + StringUtil.encodeUrl("系统名称已存在！");
			return "forward:/error.htm?resultCode=20003";
		}
		else {
			// msg=" + StringUtil.encodeUrl("系统新增成功");
			return "forward:/success.htm?resultCode=" + GlobalCode.SAVE_SUCCESS;
		}
	}
	/**
	 *
	 * what: 删除
	 *
	 * @param request request
	 * @param response response
	 * @param id 系统id
	 * @return 到操作提示页面
	 *
	 * @author 戎珊 created on 2019年08月28日
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, int id) {
		int flag = systemInfoService.delete(id);
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
