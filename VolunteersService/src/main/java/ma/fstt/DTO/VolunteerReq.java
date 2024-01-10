package ma.fstt.DTO;

import lombok.Builder;
import lombok.Data;
import ma.fstt.Persistence.Volunteer;

@Data
@Builder
public class VolunteerReq {
    private String name;
    private String skills;

    private String email;

    private boolean availability;



    private long userId;
}
