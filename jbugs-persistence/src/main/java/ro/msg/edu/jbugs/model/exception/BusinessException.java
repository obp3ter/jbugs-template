package ro.msg.edu.jbugs.model.exception;

public class BusinessException extends Exception {
    private String errorCode;
    private String message;

    public BusinessException(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
