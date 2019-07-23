/**
 * Copyright 2017 弘远技术研发中心. All rights reserved
 * Project Name:cdpf_v1
 * Module Name:web
 */
package com.critc.cri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * what:    信息化项目controller
 *
 * @author 杨超凡 created on 2017年10月23日
 */
@RequestMapping("/cri/project")
@Controller
public class CriProjectController {
	/**
	 * 
	 * what:    自动补全主页
	 * when:    请求访问自动补全主页时
	 * 
	 * @return index
	 *
	 * @author 杨超凡 created on 2017年11月2日
	 */
	@RequestMapping("/index")
	private String index() {
		return "cri/project/index";
	}
}
