package ma.fstt.Service;

import lombok.RequiredArgsConstructor;
import ma.fstt.Exception.VolunteerException;
import ma.fstt.Persistence.Volunteer;
import ma.fstt.Repository.VolunteerRepo;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class VolunteerServiceImpl implements VolunteerService {

    private final VolunteerRepo volunteerRepo;

    @Override
    public Volunteer getOne(Long id) {
        log.info("VolunteerServiceImpl | getVolunteerById is called");
        log.info("VolunteerServiceImpl | getVolunteerById | Get the need for id: {}", id);

        return volunteerRepo.findById(id)
                .orElseThrow(() -> new VolunteerException("Volunteer with given ID not found", "Volunteer_NOT_FOUND"));
    }

    @Override
    public List<Volunteer> getAll() {
        log.info("VolunteerServiceImpl | getAllVolunteers is called");
        return volunteerRepo.findAll();
    }



    @Override
    public Volunteer save(Volunteer volunteer) {
        log.info("VolunteerServiceImpl | createVolunteer is called");

        Volunteer createdVolunteer = volunteerRepo.save(volunteer);

        log.info("VolunteerServiceImpl | createVolunteer | Volunteer Created");
        log.info("VolunteerServiceImpl | createVolunteer | Volunteer Id : " + createdVolunteer.getId());
        return createdVolunteer;
    }

    @Override
    public void update(Long id, Volunteer volunteer)  {
        log.info("VolunteerServiceImpl | updateVolunteer is called");
        log.info("VolunteerServiceImpl | updateVolunteer | Update the need for id: {}", id);

        if (!volunteerRepo.existsById(id)) {
            throw new VolunteerException("Volunteer with given ID not found", "Volunteer_NOT_FOUND");
        }

        volunteer.setId(id);
        volunteerRepo.save(volunteer);

        log.info("VolunteerServiceImpl | updateVolunteer | Volunteer Updated");
    }

    @Override
    public void delete(Long id) {

        log.info("VolunteerServiceImpl | deleteVolunteer is called");
        log.info("VolunteerServiceImpl | deleteVolunteer | Deleting the need for id: {}", id);

        if (!volunteerRepo.existsById(id)) {
            throw new VolunteerException("Volunteer with given ID not found", "Volunteer_NOT_FOUND");
        }

        volunteerRepo.delete(this.getOne(id));

        log.info("VolunteerServiceImpl | deleteVolunteer | Volunteer Deleted");
    }

    public Volunteer updateAvailability(Long id, boolean availability) {
        Volunteer volunteer = volunteerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Volontaire non trouvé"));
        volunteer.setAvailability(availability);
        return volunteerRepo.save(volunteer);
    }
}
