package com.servlet;

import com.bean.LoginBean;
import com.bean.RequestBean;
import com.bean.ResponseBean;
import com.bean.SignUpBean;
import com.dao.SignUpDao;
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

@WebServlet(name = "SignUpServlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setCharacterEncoding("utf-8");

        //获取writer
        PrintWriter out = response.getWriter();

        //读取请求内容
        BufferedReader reader = request.getReader();
        String content = reader.readLine();

        Gson gson = new Gson();
        //识别RequestBean<SignUpBean>类的结构
        Type requestType = new TypeToken<RequestBean<SignUpBean>>(){}.getType();
        //利用识别得到的结构将请求内容转化成对象
        RequestBean<SignUpBean> signRequest = gson.fromJson(content,requestType);
        try{
            SignUpDao signupDao = new SignUpDao();
            SignUpBean signupBean = signRequest.getReqParam();
            signupDao.signup(signRequest);
            ResponseBean signupResp = new ResponseBean<>();
            signupResp.setSuccess(true);
            //识别ResponseBean<LoginBean>类的结构
            Type respType = new TypeToken<ResponseBean>(){}.getType();
            //通过toJson方法将对象转化为json格式的字符串
            out.print(gson.toJson(signupResp,respType));
        }catch (Exception e){
            out.print(e.toString());
        }
        out.flush();
        out.close();
    }
}
