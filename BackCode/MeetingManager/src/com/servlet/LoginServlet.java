package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.lang.reflect.Type;
import com.bean.LoginBean;
import com.bean.ResponseBean;
import com.dao.LoginDao;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.bean.RequestBean;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("start");
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();

        BufferedReader reader = request.getReader();
        String content = reader.readLine();
        System.out.println(content);
        Gson gson = new Gson();
        System.out.println("gson");
        Type requestType = new TypeToken<RequestBean<LoginBean>>(){}.getType();
        System.out.println("type");
        RequestBean<LoginBean> loginRequest = gson.fromJson(content,requestType);
        try{
            LoginDao loginDao = new LoginDao();
            LoginBean loginBean = loginRequest.getReqParam();
            String id = loginDao.loginCheck(loginBean);
            ResponseBean<LoginBean> loginResp = new ResponseBean<LoginBean>();
            loginResp.setResData(loginBean);
            Type respType = new TypeToken<ResponseBean<LoginBean>>(){}.getType();
            if(id!=null){
                loginResp.setSuccess(true);
                System.out.println(loginResp.isSuccess());
                loginDao.getName(loginResp);
                loginResp.setReqId(id);
            }else{
                loginResp.setSuccess(false);
            }
            out.print(gson.toJson(loginResp,respType));
        }catch (Exception e){
            out.print(e.toString());
        }
        out.flush();
        out.close();
    }
}
