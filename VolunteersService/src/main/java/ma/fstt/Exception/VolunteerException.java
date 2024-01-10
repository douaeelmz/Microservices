package ma.fstt.Exception;

import lombok.Data;

@Data
public class VolunteerException extends RuntimeException{
    private String errorCode;
    public VolunteerException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
