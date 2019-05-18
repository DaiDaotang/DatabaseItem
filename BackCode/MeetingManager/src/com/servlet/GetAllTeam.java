package com.servlet;

import com.bean.*;
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
import java.util.List;

@WebServlet(name = "GetAllTeam")
public class GetAllTeam extends HttpServlet {
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
        Type requestType = new TypeToken<RequestBean>(){}.getType();
        RequestBean reqBean = gson.fromJson(content,requestType);
        ResponseBean<List<TeamBean>> resBean = new ResponseBean<>();
        try {

            GetTeamDao dao = new GetTeamDao();
            List<TeamBean> list = dao.returnTeamList();



            resBean.setReqId(reqBean.getReqId());
            resBean.setResData(list);
            resBean.setSuccess(true);
            Type resType = new TypeToken<ResponseBean<List<TeamBean>>>(){}.getType();
            out.print(gson.toJson(resBean,resType));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
