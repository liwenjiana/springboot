package cn.tedu.springboot.service.ex;

import java.io.Serializable;

public class NotFindException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 3929687917028233778L;

    public NotFindException() {
    }

    public NotFindException(String message) {
        super(message);
    }
}
