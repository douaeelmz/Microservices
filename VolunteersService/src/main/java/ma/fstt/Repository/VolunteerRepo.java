package ma.fstt.Repository;

import ma.fstt.Persistence.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerRepo extends JpaRepository<Volunteer, Long> {

}
