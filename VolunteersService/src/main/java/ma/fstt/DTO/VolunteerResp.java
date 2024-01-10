package ma.fstt.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fstt.Persistence.Volunteer;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerResp {
    private String name;
    private String email;

    private String skills;

    private boolean availability;

    private long userId;
}


