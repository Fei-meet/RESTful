package com.example.restfuldemo;



import lombok.Getter;
import lombok.Setter;

//统一的接口响应对象
@Setter
@Getter
public class JsonResult {
    private int code;           //请求操作完之后返回状态码： 操作成功200， 操作失败：500，没有登录403
    private String msg;         //请求操作之后返回信息
    private Object data;        //请求响应数据

    public JsonResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static JsonResult error(String msg){
        return new JsonResult(500, msg, null);
    }
    public static JsonResult error(String msg, Object data){
        return new JsonResult(500, msg, data);
    }
    public static JsonResult success(){
        return new JsonResult(200, "操作成功", null);
    }
    public static JsonResult success(Object data){
        return new JsonResult(200, "操作成功", data);
    }

}
