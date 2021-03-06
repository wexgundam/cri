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
import com.critc.cri.model.RailwayInformationSystem;
import com.critc.cri.service.RiopiService;
import com.critc.sys.service.SysDicService;
import com.critc.util.code.GlobalCode;
import com.critc.util.page.PageNavigate;
import com.critc.util.string.BackUrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.critc.cri.vo.RailwayInformationSystemSearchVO;
import com.critc.cri.service.RailwayInformationSystemService;
import com.critc.util.string.StringUtil;

/**
 * 
 * what:    信息化项目controller
 *
 * @author rs created on 2019年08月28日
 */
@RequestMapping("/cri/railwayinformationsystem")
@Controller
public class RailwayInformationSystemController {
	/**
	 * 信息系统Service
	 */
	@Autowired
	private RailwayInformationSystemService railwayInformationSystemService;
	/**
	 * 信息系统Service
	 */
	@Autowired
	private RiopiService riopiService;
	/**
	 * 全局参数配置
	 */
	@Autowired
	private PubConfig pubConfig;
	@Autowired
	private SysDicService sysDicService;
	/**
	 * 
	 * what:    自动补全主页
	 * when:    请求访问自动补全主页时
	 * 
	 * @return index
	 *
	 * @author rs created on 2019年08月28日
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,RailwayInformationSystemSearchVO railwayInformationSystemSearchVO) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/cri/railwayinformationsystem/index");
		// 获取查询总数
		int recordCount = railwayInformationSystemService.count(railwayInformationSystemSearchVO);
		List<RailwayInformationSystem> list = railwayInformationSystemService.list(railwayInformationSystemSearchVO);
	//	List<RailwayInformationSystemSearchVO> listCombo = systemInfoService.listCombo();
		// 把获取的记录放到mv里面
		String url = pubConfig.getDynamicServer() + "/cri/railwayinformationsystem/index.htm?";
		// 定义分页对象
		PageNavigate pageNavigate = new PageNavigate(url, railwayInformationSystemSearchVO.getPageIndex(), recordCount);
		String ztree = riopiService.createZtreeByModule();// 信息系统列表
		// 设置分页的变量
		mv.addObject("pageNavigate", pageNavigate);
		mv.addObject("backUrl", StringUtil.encodeUrl(url));
	//	mv.addObject("listContent", riopiService.listCombo());// 信息系统列表
		mv.addObject("list", list);
		mv.addObject("zTree", ztree);
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
	 * @author rs created on 2019年08月28日
	 */
	@RequestMapping("/toUpdate")
	public ModelAndView toUpdate(HttpServletRequest request, HttpServletResponse response, int id) {
		ModelAndView mv = new ModelAndView();
		RailwayInformationSystem railwayInformationSystem = railwayInformationSystemService.get(id);
		mv.addObject("systeminfo", railwayInformationSystem);
		String ztree = riopiService.createZtreeByModule();// 信息系统列表
		// 添加字典 项目类型 / 进度编码 / 网络安全等级
		mv.addObject("listProjectType", sysDicService.getByCategory("PROJECT_TYPE"));
		mv.addObject("listProjectProgress", sysDicService.getByCategory("PROJECT_PROGRESS"));
		mv.addObject("listNetworkSecurity", sysDicService.getByCategory("NETWORK_SECURITY"));
		mv.addObject("zTree", ztree);
		mv.setViewName("/cri/railwayinformationsystem/update");
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
	 * @param railwayInformationSystem railwayInformationSystem
	 * @return 到操作提示页面
	 *
	 * @author rs created on 2019年08月28日
	 */
	@RequestMapping("/update")
	public String update(HttpServletRequest request, HttpServletResponse response, @Valid RailwayInformationSystem railwayInformationSystem) {

		int flag = railwayInformationSystemService.update(railwayInformationSystem);
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
	 * @author rs created on 2019年08月28日
	 */
	@RequestMapping("/toAdd")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		// 部门列表
		// 添加字典 项目类型 / 进度编码 / 网络安全等级
		mv.addObject("listProjectType", sysDicService.getByCategory("PROJECT_TYPE"));
		mv.addObject("listProjectProgress", sysDicService.getByCategory("PROJECT_PROGRESS"));
		mv.addObject("listNetworkSecurity", sysDicService.getByCategory("NETWORK_SECURITY"));
		//	mv.addObject("listType", sysDicService.getByCategory("DEPARTMENT_TYPE"));
		mv.setViewName("/cri/railwayinformationsystem/add");
		// 设置返回的url
		String ztree = riopiService.createZtreeByModule();// 信息系统列表
		mv.addObject("zTree", ztree);
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
	 * @author rs created on 2019年08月28日
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response, @Valid RailwayInformationSystem railwayInformationSystem) {

	//	List<RailwayInformationSystem>  riopilist = railwayInformationSystemService.getIdByriopiname(String.valueOf(railwayInformationSystem.getRIOPI_NAME()));// 信息系统列表
      //  int riopiid = riopilist.get(0).getId();
		int flag = railwayInformationSystemService.add(railwayInformationSystem);
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
		 * @author rs created on 2019年08月28日
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, int id) {
		int flag = railwayInformationSystemService.delete(id);
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

	@RequestMapping("/datalist")
	public ModelAndView getdatalist(HttpServletRequest request, HttpServletResponse response, int id) {
		ModelAndView mv = new ModelAndView();
		RailwayInformationSystem railwayInformationSystem = railwayInformationSystemService.get(id);
		mv.addObject("systeminfo", railwayInformationSystem);
		return mv;
	}
	
}
