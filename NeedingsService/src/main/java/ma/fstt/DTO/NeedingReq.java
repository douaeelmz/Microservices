package ma.fstt.DTO;

import lombok.Builder;
import lombok.Data;
import ma.fstt.Persistence.Needing;

@Data
@Builder
public class NeedingReq {
    private String Firstname;

    private String Lastname;

    private String country;

    private String address;

    private int age;

    private long phone;

    private String location;

    private String status;

    private Needing.Category category;

    private long userId;
}
