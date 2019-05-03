package com.servlet;

import com.bean.CheckResultBean;
import com.bean.RequestBean;
import com.bean.ResponseBean;
import com.dao.CheckResultDao;
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

@WebServlet(name = "GetResultByItem")
public class GetResultByItem extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        BufferedReader reader = request.getReader();
        String content = reader.readLine();
        Gson gson = new Gson();
        Type requestType = new TypeToken<RequestBean<CheckResultBean>>(){}.getType();
        RequestBean<CheckResultBean> reqBean = gson.fromJson(content,requestType);
        ResponseBean<CheckResultBean> resBean = new ResponseBean<>();
        try {
            CheckResultDao dao = new CheckResultDao(reqBean.getReqParam(),reqBean.getReqPageInfo());
            CheckResultBean listBean = reqBean.getReqParam();
            listBean.setList(dao.GetResultByItem());
            resBean.setResData(listBean);
            resBean.setReqId(reqBean.getReqId());
            listBean.setTeam_rank(dao.GetTeamRank());
            resBean.setSuccess(true);
            Type resType = new TypeToken<ResponseBean<CheckResultBean>>(){}.getType();
            out.print(gson.toJson(resBean,resType));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
