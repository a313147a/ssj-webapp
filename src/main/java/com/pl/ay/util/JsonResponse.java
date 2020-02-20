package com.pl.ay.util;

import lombok.Data;

import java.util.HashMap;

/**
 * Created by pl on 2018-3-27.
 * 返回给前端正确或错误信息
 */
@Data
public class JsonResponse extends HashMap<String,Object>{

    private static final String STATUS_KEY = "status";
    private static final String CODE_KEY = "code";
    private static final String MSG_KEY = "message";
    private static final String INFO_KEY = "info";

    public JsonResponse(String status, int code, String msg){
        put(STATUS_KEY,status);
        put(CODE_KEY,code);
        put(MSG_KEY,msg);
    }

    //成功信息
    public static JsonResponse success(String msg){
        return new JsonResponse("success",200,msg);
    }

    //失败信息
    public static JsonResponse failure(String msg){
        return new JsonResponse("error",0,msg);
    }

    //提示信息并附带json内容
    public JsonResponse addInfo(Object object){
        put(INFO_KEY,object);
        return this;
    }
}
