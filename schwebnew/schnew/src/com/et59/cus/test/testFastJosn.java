package com.et59.cus.test;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.et59.cus.domain.entity.BsMenu;

public class testFastJosn {
	
	public  static void main (String[]args){
	/*	List<BsMenu>  list =  new ArrayList<BsMenu>();
		BsMenu bsMenu = new BsMenu();
		bsMenu.setId(122l);
		bsMenu.setMenuurl("Admin_init");
		list.add(bsMenu);
		String sss = JSON.toJSONString(list);*/
		String subject;
		try {
			subject = new String("中国".getBytes("ISO-8859-1"), "UTF-8");
			System.out.println(subject);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
}

