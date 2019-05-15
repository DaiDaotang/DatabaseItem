package com.servlet;

import com.bean.*;
import com.dao.ArrangeScheduleDao;
import com.dao.GetAthleteDao;
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

@WebServlet(name = "GetAthleteList")
public class GetAthleteList extends HttpServlet {
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
        RequestBean<GetAthleteList> reqBean = gson.fromJson(content,requestType);
        ResponseBean resBean = new ResponseBean<>();
        try {
            GetAthleteListBean bean = new GetAthleteListBean();
            GetAthleteDao dao = new GetAthleteDao(bean);
            dao.returnAthleteList();

            resBean.setReqId(reqBean.getReqId());
            resBean.setSuccess(true);
            Type resType = new TypeToken<ResponseBean>(){}.getType();
            out.print(gson.toJson(resBean,resType));
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
