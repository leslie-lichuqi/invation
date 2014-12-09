<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Dao.InvationDAO"%>
<%@page import="Dao.Invation"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String action = request.getParameter("action");
	String msg = "1:操作成功!";
	if("ADD".equals(action)){
		String name = request.getParameter("vNAME")==null?"":request.getParameter("vNAME");
		String weixin = request.getParameter("vWEIXIN")==null?"":request.getParameter("vWEIXIN");
		String phone = request.getParameter("vPHONE")==null?"":request.getParameter("vPHONE");
		String area = request.getParameter("vAREA")==null?"":request.getParameter("vAREA");
		
		if(!"".equals(name)&&!"".equals(weixin)&&!"".equals(phone)&&!"".equals(area)){
			Invation bean = new Invation();
			InvationDAO dao = new InvationDAO();
			List list =  dao.findByTel(phone);
			if(list.size()==0){
				bean.setName(name);
				bean.setWeixin(weixin);
				bean.setTel(phone);
				bean.setArea(area);
				bean.setCreatedate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
				try{
					dao.save(bean);
				}catch(Exception e){
					msg= "-1:数据库异常";
				}
			}else{
				msg = "-1:该号码已报名";
			}
		}else{
			msg= "-1:格式不正确";
		}
	}
%>
<%=msg%>