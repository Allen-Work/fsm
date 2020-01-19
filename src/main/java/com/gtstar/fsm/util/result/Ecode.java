package com.gtstar.fsm.util.result;

public enum Ecode {
    /**
     * 公共错误码
     **/
    FAIL(-1, "失败！"),
    SUCCESS(0, "成功!"),
    PARAM(1, "参数不能为空"),
    INTER(2, "服务器正忙，请稍后再试！"),
    TIMEOUT(3, "调用外部接口超时"),
    EXTERNAL(4, "外部接口错误"),
    RESRC(5, "接口不存在"),
    AUTH(6, "授权失败"),
    PARAMNUMBER(7, "参数个数不对"),
    PARAMNAMEERROR(8, "参数名错误"),
    DATE_NOT_EXIST(9, "数据不存在！"),
    UPLOAD_FAIL(10, "文件上传失败"),
    NO_Data_BY_PARAM(11,"该参数查询不到任何信息"),
    CHECK_SUCCESS(12,"操作成功,审核通过!"),
    CHECK_ERROR(13,"操作成功,审核不通过!"),
    RECEIVE_ORDER(14,"接单成功!"),
    REFUSE_ORDER(15,"拒单成功!"),
    DELETE_FAIL_CONFIGURE(16,"该号码组已被号码组间配置,禁止删除!"),
    PARAM_FORMAT_ERROR(17,"参数格式不正确!"),
    IMPORT_FAIL_WITHOUT_DATA(18,"导出失败,该条件查询不到数据!"),
    ADD_SUCCESS(19,"添加成功!"),
    MODIFY_SUCCESS(20,"修改成功!"),
    DELETE_SUCCESS(21,"删除成功!"),
    MODIFY_FAIL(22, "修改失败！名称被占用"),
    REPEAT_FORBIDDEN(23,"合同号不能重复"),
    AD_ADMIN_PASSWD_ERR(100, "密码有误"),

    USR_NOT_EXISTS(1050, "用户不存在"),
    USR_DISABLED(1051, "用户已禁用"),
    ;


    private Integer code;
    private String msg;

    Ecode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
