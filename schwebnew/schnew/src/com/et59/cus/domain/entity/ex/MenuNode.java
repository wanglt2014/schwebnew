package com.et59.cus.domain.entity.ex;

import java.util.ArrayList;
import java.util.List;

import com.et59.cus.domain.entity.BsMenu;

/**
 * 菜单节点
 *
 */
public class MenuNode extends BsMenu {
	private List<BsMenu> children = new ArrayList<BsMenu>();

	public List<BsMenu> getChildren() {
		return children;
	}

	public void setChildren(List<BsMenu> children) {
		this.children = children;
	}

}
