package cn.tedu.springboot.service.ex;

public class PasswordNotMatchException extends RuntimeException{
    private static final long serialVersionUID = -7274311257946136925L;

    public PasswordNotMatchException() {
    }

    public PasswordNotMatchException(String message) {
        super(message);
    }
}
