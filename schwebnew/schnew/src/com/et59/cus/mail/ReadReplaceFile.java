package com.et59.cus.mail;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 读取模板和替换模板内容
 * @author liuhaihua
 *
 */
public class ReadReplaceFile {
    public static BufferedReader bufread;
    //指定文件路径和名称
    public static String path ;
    private static String readStr ="";
   /**
    * 读取文件
    * @return
    */
    public static String getTemplate(){
        String read;
        try {
        	FileInputStream fis = new FileInputStream(new File(path));
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            bufread = new BufferedReader(isr);
            readStr ="";
            try {
                while ((read = bufread.readLine()) != null) {
                    readStr = readStr + read+ "\r\n";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readStr;
    }
    /**
     * 替换文件
     * @param oldStr
     * @param replaceStr
     */
    public static String replaceTemplateByStr(TemplateVO  templateVO) {
    	String temp =ReadReplaceFile.getTemplate();
    	String aaa = temp.replace(templateVO.getOld_username(), templateVO.getUsername()).replace(templateVO.getOld_email(),templateVO.getEmail()).replace(templateVO.getOld_url(), templateVO.getUrl());
    	return aaa;
    }
   
    public static void main(String[] s) throws IOException {
    	TemplateVO  templateVO =new TemplateVO();
    	templateVO.setOld_username("${username}");
    	templateVO.setUsername("liuhaihua");
    	templateVO.setOld_email("${email}");
    	templateVO.setEmail("liuhaihua@59et.com");
        ReadReplaceFile.replaceTemplateByStr(templateVO);
    }
}