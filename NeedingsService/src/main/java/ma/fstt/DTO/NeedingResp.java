package ma.fstt.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fstt.Persistence.Needing;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NeedingResp {
    private String Firstname;

    private String Lastname;

    private String country;

    private String address;

    private int age;

    private long phone;

    private String location;

    private String status;

    private String category;

    private long userId;
}


