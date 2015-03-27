package com.et59.cus.test;


public class TestReplace {
	public static void main(String[] args){
       String sss = "sssss${url}ssss${url}sss";
       String aaa =sss.replace("${url}", "aaa");
       System.out.println(aaa);
       String splitstr ="jxausea@163.com|4028b5ea450192a501450192a56c0000";
       String[] array = splitstr.split("\\|");
       System.out.println(array[0]+"\n"+array[1]);
	 
	}
}
