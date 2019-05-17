package com.servlet;

import com.bean.ComScoreBean;
import com.bean.PersonScoreBean;
import com.bean.RequestBean;
import com.bean.ResponseBean;
import com.dao.RefereeDao;
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

@WebServlet(name = "GetScores2")
public class GetScores2 extends HttpServlet {
    //todo:测试
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
        Type requestType = new TypeToken<RequestBean<ComScoreBean>>(){}.getType();
        RequestBean<ComScoreBean> requestBean = gson.fromJson(content,requestType);
        RefereeDao dao = new RefereeDao(requestBean);
        ResponseBean<List<PersonScoreBean>> responseBean = new ResponseBean<>();
        responseBean.setReqId(requestBean.getReqId());
        responseBean.setResData(dao.getScoreLists("总裁判",requestBean.getReqParam().getCom_id()));
        Type responseType = new TypeToken<ResponseBean<List<PersonScoreBean>>>(){}.getType();
        String resp = gson.toJson(responseBean,responseType);
        try{
            out.print(resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
