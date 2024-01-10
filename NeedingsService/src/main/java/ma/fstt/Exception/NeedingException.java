package ma.fstt.Exception;

import lombok.Data;

@Data
public class NeedingException extends RuntimeException{
    private String errorCode;
    public NeedingException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
