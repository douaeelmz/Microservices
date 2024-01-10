package ma.fstt.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import ma.fstt.Persistence.Volunteer;
import ma.fstt.Service.VolunteerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/volunteers")
@RequiredArgsConstructor
@Log4j2
public class VolunteerController {

    private final VolunteerService volunteerService;

    @PostMapping
    public ResponseEntity<Long> createVolunteer(@RequestBody Volunteer volunteer) {
        log.info("VolunteerController | createVolunteer is called");
        log.info("VolunteerController | createVolunteer | Volunteer Request: " + volunteer.toString());

        Long volunteerId = volunteerService.save(volunteer).getId();
        return new ResponseEntity<>(volunteerId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Volunteer> getVolunteerById(@PathVariable("id") Long id) {
        log.info("VolunteerController | getVolunteerById is called");
        log.info("VolunteerController | getVolunteerById | Volunteer ID: " + id);

        Volunteer volunteer = volunteerService.getOne(id);
        return new ResponseEntity<>(volunteer, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Volunteer>> getAllVolunteers() {
        log.info("VolunteerController | getAllVolunteers is called");

        List<Volunteer> volunteers = volunteerService.getAll();
        return new ResponseEntity<>(volunteers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVolunteer(@PathVariable("id") Long id, @RequestBody Volunteer volunteer) {
        log.info("VolunteerController | updateVolunteer is called");
        log.info("VolunteerController | updateVolunteer | Volunteer ID: " + id);
        log.info("VolunteerController | updateVolunteer | Updated Volunteer: " + volunteer.toString());

        volunteerService.update(id, volunteer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVolunteerById(@PathVariable("id") Long id) {
        log.info("VolunteerController | deleteVolunteerById is called");
        log.info("VolunteerController | deleteVolunteerById | Volunteer ID: " + id);

        volunteerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}/availability")
    public ResponseEntity<Volunteer> updateAvailability(@PathVariable Long id, @RequestBody boolean availability) {
        Volunteer updatedVolunteer = volunteerService.updateAvailability(id, availability);
        return ResponseEntity.ok(updatedVolunteer);
    }
}
