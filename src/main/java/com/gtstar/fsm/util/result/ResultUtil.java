package com.gtstar.fsm.util.result;

/**
 * @ClassName ResultUtil
 * @Description TODO
 * @Author yuxiang
 * @Date 2018/9/19 9:22
 **/
public class ResultUtil {
    public static Result success(Object obj){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("请求数据成功");
        result.setData(obj);
        return result;
    }

    public static Result success(String msg) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static Result success(Ecode code) {
        Result result = new Result();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        return result;
    }

    public static Result success(Ecode code,Object obj) {
        Result result = new Result();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        result.setData(obj);
        return result;
    }

    public static Result success(Integer code, String msg,Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result error(Integer code, String msg,Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result error(Ecode code) {
        Result result = new Result();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        return result;
    }

}
