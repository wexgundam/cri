/**2017年10月19日
 * 
 */
package com.critc.cri.vo;

import com.critc.util.page.PageSearchVO;

/**
 *  字典信息查询条件
 * 
 * @author: rs
 * @date: 2019年9月30日
 */
public class MilestonesSearchVO extends PageSearchVO {
	private String name;              //系统名称

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}




	//模糊查询
	public String getNameStr() {
		return "%" + name + "%";
	}


	@Override
	public String toString() {
		return "RailwayInformationSystemSearchVO{" +
				"name='" + name + '\'' +
				'}';
	}
}
