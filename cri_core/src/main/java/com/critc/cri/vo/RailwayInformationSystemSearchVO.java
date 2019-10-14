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
public class RailwayInformationSystemSearchVO extends PageSearchVO {

	private String name;              //系统名称
	private String riopiName;       //归属信息化目录名称
	private Integer riopiId;  //归属信息化目录主键
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getriopiName() {
		return riopiName;
	}
	public void setriopiName(String riopiName) {
		this.riopiName = riopiName;
	}
	public Integer getriopiId() {
		return riopiId;
	}
	public void setriopiId(Integer riopiId) {
		this.riopiId = riopiId;
	}


	
	
	//模糊查询
    public String getNameStr() {
        return "%" + name + "%";
    }
    
    public String getriopiNameStr() {
        return "%" + riopiName + "%";
    }

	@Override
	public String toString() {
		return "RailwayInformationSystemSearchVO{" +
				"name='" + name + '\'' +
				", riopiName='" + riopiName + '\'' +
				'}';
	}
}
