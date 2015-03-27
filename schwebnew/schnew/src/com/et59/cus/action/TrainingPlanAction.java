package com.et59.cus.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.TDepartment;
import com.et59.cus.domain.entity.TDepartmentWithBLOBs;
import com.et59.cus.domain.entity.TTrainingplan;
import com.et59.cus.domain.entity.TTrainingplanExample;
import com.et59.cus.domain.entity.ex.Pager;

/**
 * 人才培养方案
 *
 */
public class TrainingPlanAction extends BaseAction {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	public String oldFileName;
	public String name;
	public File fileData;
	public String fileType;
	public String tampFileName;
	public String fileCount;

	public String defultId;

	public TTrainingplan tTrainingplan;
	public TDepartment tDepartment;

	public TDepartmentWithBLOBs tDepartmentWithBLOBs;

	public String getDefultId() {
		return defultId;
	}

	public void setDefultId(String defultId) {
		this.defultId = defultId;
	}

	public TDepartmentWithBLOBs gettDepartmentWithBLOBs() {
		return tDepartmentWithBLOBs;
	}

	public void settDepartmentWithBLOBs(
			TDepartmentWithBLOBs tDepartmentWithBLOBs) {
		this.tDepartmentWithBLOBs = tDepartmentWithBLOBs;
	}

	public TDepartment gettDepartment() {
		return tDepartment;
	}

	public void settDepartment(TDepartment tDepartment) {
		this.tDepartment = tDepartment;
	}

	public TTrainingplan gettTrainingplan() {
		return tTrainingplan;
	}

	public void settTrainingplan(TTrainingplan tTrainingplan) {
		this.tTrainingplan = tTrainingplan;
	}

	/**
	 * 首页
	 * 
	 * @return
	 */
	public String index() {
		return "index";
	}

	/**
	 * @Title: toTeacherPage
	 * @Description: 跳转到教务教学通知
	 * @return String 返回类型
	 * @throws
	 */

	public String toPlanPage() {
		// super.commonQueryForTeacher("");
		TDepartment tDepartment = new TDepartment();
		try {
			Pager pager = localServiceEXProxy.queryTDepartmentBypage(
					tDepartment, 9, 1);
			tdepartmentList = (List<TDepartmentWithBLOBs>) pager.getRows();
			if (tdepartmentList != null && tdepartmentList.size() > 0) {
				defultId = String.valueOf(tdepartmentList.get(0)
						.getDepartmentid());
			} else {
				defultId = "0";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "to_plan_index";
	}

	/**
	 * 分页查询专业信息
	 */
	public void query() {
		// String teachernamequery = request.getParameter("teachernamequery");
		// String departmentquery = request.getParameter("departmentquery");
		String page = request.getParameter("page"); // 当前页数
		String rows = request.getParameter("rows"); // 每页显示行数
		try {
			TDepartment tDepartment = new TDepartment();
			Pager pager = localServiceEXProxy.queryTDepartmentBypage(
					tDepartment, Integer.valueOf(rows), Integer.valueOf(page));
			super.reponseWriter(JSON.toJSONString(pager));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 保存专业
	 */
	public void save() {
		boolean flag = false;
		TDepartmentWithBLOBs tDepartment = getTDepartment();
		try {
			localServiceEXProxy.saveTDepartmentWithBLOBs(tDepartment);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 编辑专业-人才培养方案
	 */
	public void update() {
		boolean flag = false;
		String id = request.getParameter("id");
		TDepartmentWithBLOBs tDepartment = getTDepartment();
		tDepartment.setDepartmentid(Long.valueOf(id));
		try {
			localServiceEXProxy.updateTDepartmentWithBLOBs(tDepartment);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除专业-人才培养方案
	 */
	public void deleteTDepartment() {
		boolean flag = false;
		String id = request.getParameter("id");
		try {
			TTrainingplanExample example = new TTrainingplanExample();
			example.createCriteria().andTrainingplandepidEqualTo(
					Long.valueOf(id));
			// 删除专业对应的方案表数据
			localServiceEXProxy.deleteTTrainingplan(example);
			// 删除专业表
			localServiceEXProxy.deleteTDepartment(Long.valueOf(id));
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 公共方法
	 * 
	 * @return
	 */
	public TDepartmentWithBLOBs getTDepartment() {
		String departmentname = request.getParameter("departmentname");
		String departmenttype = request.getParameter("departmenttype");
		String departmentContent = request.getParameter("departmentContent");
		String directionContent = request.getParameter("directionContent");

		TDepartmentWithBLOBs tDepartment = new TDepartmentWithBLOBs();
		tDepartment.setDepartmentname(departmentname);
		tDepartment.setDepartmenttype(departmenttype);
		tDepartment.setDepartmentintroduction(departmentContent);
		tDepartment.setDepartmentdirection(directionContent);

		return tDepartment;
	}

	/**
	 * 编辑培养方案
	 */
	public void updatePlan() {
		boolean flag = false;
		String id = request.getParameter("id");
		String planType = request.getParameter("planType");
		try {
			TTrainingplan tTrainingplan = getTTrainingplan();
			TTrainingplanExample example = new TTrainingplanExample();
			example.createCriteria()
					.andTrainingplandepidEqualTo(Long.valueOf(id))
					.andTrainingplantypeEqualTo(planType);

			localServiceEXProxy.deleteTTrainingplan(example);

			tTrainingplan.setTrainingplandepid(Long.valueOf(id));
			tTrainingplan.setTrainingplantype(planType);
			localServiceEXProxy.saveTTrainingplan(tTrainingplan);
			flag = true;
			super.reponseWriter(JSON.toJSONString(flag));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 公共方法
	 * 
	 * @return
	 */
	public TTrainingplan getTTrainingplan() {
		String trplansubidsforoneId = request
				.getParameter("trplansubidsforoneId");
		String trplansubidsfortwoId = request
				.getParameter("trplansubidsfortwoId");
		String trplansubidsforthreeId = request
				.getParameter("trplansubidsforthreeId");
		String trplansubidsforfourId = request
				.getParameter("trplansubidsforfourId");
		String trplansubidsforfiveId = request
				.getParameter("trplansubidsforfiveId");
		String trplansubidsforsixId = request
				.getParameter("trplansubidsforsixId");
		String trplansubidsforsevenId = request
				.getParameter("trplansubidsforsevenId");
		String trplansubidsforeightId = request
				.getParameter("trplansubidsforeightId");

		TTrainingplan tTrainingplan = new TTrainingplan();
		tTrainingplan.setTrplansubidsforone(trplansubidsforoneId);
		tTrainingplan.setTrplansubidsfortwo(trplansubidsfortwoId);
		tTrainingplan.setTrplansubidsforthree(trplansubidsforthreeId);
		tTrainingplan.setTrplansubidsforfour(trplansubidsforfourId);
		tTrainingplan.setTrplansubidsforfive(trplansubidsforfiveId);
		tTrainingplan.setTrplansubidsfosix(trplansubidsforsixId);
		tTrainingplan.setTrplansubidsforseven(trplansubidsforsevenId);
		tTrainingplan.setTrplansubidsforeight(trplansubidsforeightId);

		return tTrainingplan;
	}

	/**
	 * 
	 */
	public void queryTrainingPlanByDepId() {
		String departmentid = request.getParameter("departmentid");
		String planType = request.getParameter("planType");

		try {
			TTrainingplanExample example = new TTrainingplanExample();
			example.createCriteria()
					.andTrainingplandepidEqualTo(Long.valueOf(departmentid))
					.andTrainingplantypeEqualTo(planType);

			List<TTrainingplan> list = localServiceEXProxy
					.queryTTrainingplan(example);
			String json = "";
			Map map = new HashMap();
			if (null != list && list.size() > 0) {
				TTrainingplan row = list.get(0);
				map.put("trplansubidsforone", row.getTrplansubidsforone());
				map.put("trplansubidsfortwo", row.getTrplansubidsfortwo());
				map.put("trplansubidsforthree", row.getTrplansubidsforthree());
				map.put("trplansubidsforfour", row.getTrplansubidsforfour());
				map.put("trplansubidsforfive", row.getTrplansubidsforfive());
				map.put("trplansubidsfosix", row.getTrplansubidsfosix());
				map.put("trplansubidsforseven", row.getTrplansubidsforseven());
				map.put("trplansubidsforeight", row.getTrplansubidsforeight());
			}
			super.reponseWriter(JSON.toJSONString(map));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Title: trainingPlanDetail
	 * @Description: 跳转到详细页面
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String showDepDetail() {
		// super.commonquery();
		String id = request.getParameter("id");
		try {
			tDepartmentWithBLOBs = localServiceEXProxy.queryTDepartment(Long
					.valueOf(id));

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "plan_result";
	}

	/**
	 * @Title: trainingPlanDetail
	 * @Description: 跳转到详细页面
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String trainingPlanDetail() {
		// super.commonquery();
		String id = request.getParameter("id");
		try {
			tDepartmentWithBLOBs = localServiceEXProxy.queryTDepartment(Long
					.valueOf(id));

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "plan_detail";
	}

}
