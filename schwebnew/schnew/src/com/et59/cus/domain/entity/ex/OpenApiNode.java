package com.et59.cus.domain.entity.ex;

import java.util.ArrayList;
import java.util.List;

import com.et59.cus.domain.entity.OpenApi;

public class OpenApiNode extends OpenApi {
	private  List<OpenApi> children = new ArrayList<OpenApi>();

	public List<OpenApi> getChildren() {
		return children;
	}

	public void setChildren(List<OpenApi> children) {
		this.children = children;
	}
}
