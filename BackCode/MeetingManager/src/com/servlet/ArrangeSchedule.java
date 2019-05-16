package com.servlet;

import com.bean.ArrangeScheduleBean;
import com.bean.CheckResultBean;
import com.bean.RequestBean;
import com.bean.ResponseBean;
import com.dao.*;
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

@WebServlet(name = "ArrangeSchedule")
public class ArrangeSchedule extends HttpServlet {
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
        Type requestType = new TypeToken<RequestBean<ArrangeScheduleBean>>(){}.getType();
        RequestBean<ArrangeScheduleBean> reqBean = gson.fromJson(content,requestType);
        ResponseBean resBean = new ResponseBean<>();
        try {
            ArrangeScheduleBean listBean = reqBean.getReqParam();
            ArrangeScheduleDao dao = new ArrangeScheduleDao(listBean);
            dao.arrangeschedule();
            resBean.setReqId(reqBean.getReqId());
            resBean.setSuccess(true);
            Type resType = new TypeToken<ResponseBean>(){}.getType();
            out.print(gson.toJson(resBean,resType));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
