package com.et59.cus.action;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsResource;
import com.et59.cus.domain.entity.ex.Pager;

/**
 * 
 * <p>
 * Title: BsResourceAction.java
 * </p>
 * <p>
 * Description: 资源管理
 * </p>
 * 
 * @date 2014-4-23 下午05:43:18
 * @version 2.0
 *
 */
public class ResourceAction extends BaseAction {

	/**
	 * 资源管理
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主页
	 * 
	 * @return
	 */
	public String index() {
		return "index";
	}

	/**
	 * 查询主页
	 */
	public void query() {
		String resourceurlquery = request.getParameter("resourceurlquery");
		String page = request.getParameter("page"); // 当前页数
		String rows = request.getParameter("rows"); // 每页显示行数
		try {
			BsResource bsBsResource = new BsResource();
			bsBsResource.setResourceUrl(resourceurlquery);
			Pager pager = localServiceProxy.queryBsResourceByPage(bsBsResource,
					Integer.valueOf(rows), Integer.valueOf(page));
			super.reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新资源
	 */
	public void update() {
		boolean flag = false;
		String id = request.getParameter("id");
		BsResource resource = getBsResource();
		try {
			resource.setId(Integer.valueOf(id));
			localServiceProxy.updateBsResource(resource);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 新增资源
	 */
	public void save() {
		boolean flag = false;
		BsResource resource = getBsResource();
		try {
			localServiceProxy.saveBsResource(resource);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除资源
	 */
	public void delete() {
		boolean flag = false;
		String id = request.getParameter("id");
		try {
			localServiceProxy.deleteBsResource(Integer.valueOf(id));
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 得到资源
	 * 
	 * @return
	 */
	public BsResource getBsResource() {
		String resourceUrl = request.getParameter("resourceUrl");
		String resouceName = request.getParameter("resouceName");
		String resourceType = request.getParameter("resourceType");
		String menuid = request.getParameter("menuid");
		BsResource resource = new BsResource();
		resource.setMenuid(Long.valueOf(menuid));
		resource.setResouceName(resouceName);
		resource.setResourceType(resourceType);
		resource.setResourceUrl(resourceUrl);
		return resource;
	}
}
