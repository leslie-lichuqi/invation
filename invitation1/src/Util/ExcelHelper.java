package Util;

import java.io.*;
import java.io.File;

import jxl.*;
import jxl.write.*;
import jxl.write.Boolean;
import jxl.write.Number;
import jxl.write.biff.*;
import jxl.format.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.Color;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Invation;
import Dao.InvationDAO;


public class ExcelHelper {

	/**
	 * ���Excel
	 * 
	 * @param os
	 */
	public static void writeExcel(OutputStream os) {
			try {
				//����������
		        WritableWorkbook workbook = Workbook.createWorkbook(os);
		        //�����µ�һҳ
		        WritableSheet sheet = workbook.createSheet("Sheet1",0);
		        //����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����
		        Label label = null;
		        String [] title={"���","����","΢��","�绰","����","����ʱ��"};
		        for(int i=0;i<title.length;i++){
		        	label=new Label(i, 0, title[i]);
			        sheet.addCell(label);
		        }
		        
		        Invation bean = null;
		        InvationDAO Dao = new InvationDAO();
		        List list = Dao.findAll();
		        
		        int c=1;
		        
		        for(int i=0;i<list.size();i++){
		        	bean = (Invation)list.get(i);
	        		label=new Label(0, c,String.valueOf(bean.getId()));
		        	sheet.addCell(label);
	        		label=new Label(1, c,bean.getName());
		        	sheet.addCell(label);
	        		label=new Label(2, c,bean.getWeixin());
		        	sheet.addCell(label);
	        		label=new Label(3, c,bean.getTel());
		        	sheet.addCell(label);
	        		label=new Label(4, c,bean.getArea());
		        	sheet.addCell(label);
	        		label=new Label(5, c,bean.getCreatedate());
		        	sheet.addCell(label);
		        	c++;
		        }
		        //�Ѵ���������д�뵽������У����ر������
		        workbook.write();
		        workbook.close();
		        os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	

	

	// ����
	public static void main(String[] args) {
		try {
			// ��Excel
			//System.out.println(ExcelHelper.readExcel("D:/staffimport.xls").toString());
			
			// ���Excel
			ExcelHelper excelTest = new ExcelHelper();
			 File fileWrite = new File("D:/testWrite.xls");
			 fileWrite.createNewFile();
			 OutputStream os = new FileOutputStream(fileWrite);
			 Integer[] cIndex = null;
			 excelTest.writeExcel(os);
			// �޸�Excel
			// excelTest.modifyExcel(new File(""),new File(""));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
