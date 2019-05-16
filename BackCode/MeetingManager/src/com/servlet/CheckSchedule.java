package com.servlet;

import com.bean.*;
import com.bean.CheckScheduleBean;
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
import java.util.List;

@WebServlet(name = "CheckSchedule")
public class CheckSchedule extends HttpServlet {
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
        Type requestType = new TypeToken<RequestBean<CheckScheduleBean>>(){}.getType();
        RequestBean<CheckScheduleBean> reqBean = gson.fromJson(content,requestType);
        ResponseBean<List<ScheduleBean>> resBean = new ResponseBean<>();
        try {
            CheckScheduleDao dao = new CheckScheduleDao(reqBean.getReqParam(),reqBean.getReqPageInfo());
            CheckScheduleBean listBean = reqBean.getReqParam();
            List<ScheduleBean> list;
            if(listBean.getItemName()==null)
            {
                list = dao.returnSchedule();
            }
            else
            {
                list = dao.returnScheduleByitemName();
            }

            resBean.setResData(list);
            resBean.setReqId(reqBean.getReqId());
            resBean.setSuccess(true);
            Type resType = new TypeToken<ResponseBean<List<ScheduleBean>>>(){}.getType();
            out.print(gson.toJson(resBean,resType));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
