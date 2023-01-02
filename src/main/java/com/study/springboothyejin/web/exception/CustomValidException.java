package com.study.springboothyejin.web.exception;

import lombok.Getter;

import java.util.Map;

public class CustomValidException extends RuntimeException {
    @Getter
    private Map<String, String> errorMap;

    // message 를 받을 수 있는 생성자 생성
    public CustomValidException(Map<String, String> errorMap) {
        super("Failed Validation");
        this.errorMap = errorMap;
    }
}
