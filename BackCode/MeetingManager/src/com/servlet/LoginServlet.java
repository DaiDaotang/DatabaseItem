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
        //对返回消息进行设置
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setCharacterEncoding("utf-8");

        //获取writer
        PrintWriter out = response.getWriter();

        //读取请求内容
        BufferedReader reader = request.getReader();
        String content = reader.readLine();

        Gson gson = new Gson();
        //识别RequestBean<LoginBean>类的结构
        Type requestType = new TypeToken<RequestBean<LoginBean>>(){}.getType();
        //利用识别得到的结构将请求内容转化成对象
        RequestBean<LoginBean> loginRequest = gson.fromJson(content,requestType);
        try{
            LoginDao loginDao = new LoginDao();
            LoginBean loginBean = loginRequest.getReqParam();
            String id = loginDao.loginCheck(loginBean);
            ResponseBean<LoginBean> loginResp = new ResponseBean<>();
            loginResp.setResData(loginBean);
            if(id!=null){
                loginResp.setSuccess(true);
                System.out.println(loginResp.isSuccess());
                loginDao.getName(loginResp);
                loginResp.setReqId(id);
            }else{
                loginResp.setSuccess(false);
            }
            //识别ResponseBean<LoginBean>类的结构
            Type respType = new TypeToken<ResponseBean<LoginBean>>(){}.getType();
            //通过toJson方法将对象转化为json格式的字符串
            out.print(gson.toJson(loginResp,respType));
        }catch (Exception e){
            out.print(e.toString());
        }
        out.flush();
        out.close();
    }
}
