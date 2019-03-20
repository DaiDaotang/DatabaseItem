package com.bean;

public class ResponseBean<T> {
    private String reqId = null;
    private T resData = null;
    private boolean isSuccess;

    public void setReqId(String id){
        reqId = id;
    }

    public String getReqId(){
        return reqId;
    }

    public void setResData(T resData){
        this.resData = resData;
    }

    public T getResData(){
        return resData;
    }

    public void setSuccess(boolean isSuccess){
        this.isSuccess = isSuccess;
    }

    public boolean getSuccess(){
        return isSuccess;
    }

}
