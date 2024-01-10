package ma.fstt.Repository;

import ma.fstt.Persistence.Needing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeedingRepo extends JpaRepository<Needing, Long> {

}
