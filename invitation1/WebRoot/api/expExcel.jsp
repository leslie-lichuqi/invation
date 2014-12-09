<%@page import="Util.ExcelHelper"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java"
	pageEncoding="UTF-8"%>
<%
	String fname = "报名名单导出"+new SimpleDateFormat("yyyyMMdd").format(new Date())+String.valueOf((int)Math.floor(Math.random()*1000));
    //下面是对中文文件名的处理
    OutputStream os = response.getOutputStream();//取得输出流
    response.reset();//清空输出流
    response.setCharacterEncoding("UTF-8");//设置相应内容的编码格式
    fname = java.net.URLEncoder.encode(fname,"UTF-8");
    response.setHeader("Content-Disposition","attachment;filename="+new String(fname.getBytes("UTF-8"),"GBK")+".xls");
    response.setContentType("application/msexcel");//定义输出类型
	ExcelHelper.writeExcel(os);
    out.clear();  
	out = pageContext.pushBody();
%>