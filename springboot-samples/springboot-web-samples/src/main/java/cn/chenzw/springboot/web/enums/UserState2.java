package cn.chenzw.springboot.web.enums;

public enum UserState2 {

    NORMAL(0),
    DELETED(-1);

    private Integer code;

    UserState2(Integer code) {
        this.code = code;
    }
}
