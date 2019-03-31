package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.bean.CheckResultBean;
import com.bean.RequestBean;
import com.bean.ResponseBean;
import com.bean.ResultBean;
import com.dao.CheckResultDao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
@WebServlet(name = "GetResultByAthlete")
public class GetResultByAthlete extends HttpServlet {
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
        ResponseBean<List<ResultBean>> resBean = new ResponseBean<>();
        try {
            CheckResultDao dao = new CheckResultDao(reqBean.getReqParam(),reqBean.getReqPageInfo());
            List<ResultBean> list = dao.GetResultByAthlete();
            resBean.setResData(list);
            resBean.setReqId(reqBean.getReqId());
            resBean.setSuccess(true);
            Type resType = new TypeToken<ResponseBean<List<ResultBean>>>(){}.getType();
            out.print(gson.toJson(resBean,resType));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
