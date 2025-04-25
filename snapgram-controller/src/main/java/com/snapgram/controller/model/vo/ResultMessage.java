package com.snapgram.controller.model.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class ResultMessage<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean success;
    private String message;
    private Integer code;
    private long timestamp = System.currentTimeMillis();
    private T result;
}
