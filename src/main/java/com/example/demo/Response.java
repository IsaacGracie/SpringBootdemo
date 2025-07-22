package com.example.demo;

// 响应封装类（Response）

public class Response <T>{ // 泛型类

    private T data;
    private boolean success;
    private String errorMSg;

    // 快速创建“成功响应”对象
    public static <K> Response<K> newSuccess(K data){
        Response<K> response = new Response<>();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }

    // 快速创建“失败响应”对象
    public static Response<Void> newFail(String errorMSg){
        Response<Void> response = new Response<>();
        response.setErrorMsg(errorMSg);
        response.setSuccess(false);
        return response;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMSg;
    }

    public void setErrorMsg(String errorMSg) {
        this.errorMSg = errorMSg;
    }

}
