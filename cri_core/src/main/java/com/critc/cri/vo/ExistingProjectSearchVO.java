package com.critc.cri.vo;

import com.critc.util.page.PageSearchVO;

public class ExistingProjectSearchVO extends PageSearchVO {
	/**
	 * 是否内置角色，默认为0
	 */
    private Integer isBuildin = 0;
    private String name;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Integer getIsBuildin() {
        return isBuildin;
    }

    public void setIsBuildin(Integer isBuildin) {
        this.isBuildin = isBuildin;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//角色名称模糊查询
    public String getNameStr() {
        return "%" + name + "%";
    }
	@Override
    public String toString() {
        return "ExistingProjectSearchVO{"
        		+ "isBuildin=" + isBuildin
        		+ "name='" + name + '\''
                + '}';
    }
}
