package com.servlet;

import com.bean.TeamBean;
import com.bean.RequestBean;
import com.bean.ResponseBean;
import com.dao.GetTeamDao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

@WebServlet(name = "GetTeam﻿")
public class GetTeam extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        BufferedReader in = request.getReader();
        String content = in.readLine();


        Gson gson = new Gson();
        Type requestType = new TypeToken<RequestBean>(){}.getType();
        RequestBean requestBean = gson.fromJson(content,requestType);
        GetTeamDao dao = new GetTeamDao();
        ResponseBean<List<TeamBean>> responseBean = new ResponseBean<>();
        responseBean.setReqId(requestBean.getReqId());
        responseBean.setResData(dao.returnTeamList());
        Type responseType = new TypeToken<ResponseBean<List<TeamBean>>>(){}.getType();
        String resp = gson.toJson(responseBean,responseType);
        try{
            out.print(resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
