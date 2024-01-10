package ma.fstt.Service;

import ma.fstt.Persistence.Volunteer;

import java.util.List;

public interface VolunteerService {

    Volunteer getOne(Long id);

    List<Volunteer> getAll();


    Volunteer save(Volunteer volunteer);

    void update(Long id, Volunteer volunteer);

    void delete(Long id);

    Volunteer updateAvailability(Long id, boolean availability);
}
