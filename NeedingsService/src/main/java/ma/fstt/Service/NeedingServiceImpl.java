package ma.fstt.Service;

import lombok.RequiredArgsConstructor;
import ma.fstt.Exception.NeedingException;
import ma.fstt.Persistence.Needing;
import ma.fstt.Repository.NeedingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class NeedingServiceImpl implements NeedingService {

    private final NeedingRepo needingRepo;

    @Override
    public Needing getOne(Long id) {
        log.info("NeedingServiceImpl | getNeedingById is called");
        log.info("NeedingServiceImpl | getNeedingById | Get the need for id: {}", id);

        return needingRepo.findById(id)
                .orElseThrow(() -> new NeedingException("Needing with given ID not found", "NEEDING_NOT_FOUND"));
    }

    @Override
    public List<Needing> getAll() {
        log.info("NeedingServiceImpl | getAllNeedings is called");
        return needingRepo.findAll();
    }



    @Override
    public Needing save(Needing needing) {
        log.info("NeedingServiceImpl | createNeeding is called");

        Needing createdNeeding = needingRepo.save(needing);

        log.info("NeedingServiceImpl | createNeeding | Needing Created");
        log.info("NeedingServiceImpl | createNeeding | Needing Id : " + createdNeeding.getId());
        return createdNeeding;
    }

    @Override
    public void update(Long id, Needing needing)  {
        log.info("NeedingServiceImpl | updateNeeding is called");
        log.info("NeedingServiceImpl | updateNeeding | Update the need for id: {}", id);

        if (!needingRepo.existsById(id)) {
            throw new NeedingException("Needing with given ID not found", "NEEDING_NOT_FOUND");
        }

        needing.setId(id);
        needingRepo.save(needing);

        log.info("NeedingServiceImpl | updateNeeding | Needing Updated");
    }

    @Override
    public void delete(Long id) {

        log.info("NeedingServiceImpl | deleteNeeding is called");
        log.info("NeedingServiceImpl | deleteNeeding | Deleting the need for id: {}", id);

        if (!needingRepo.existsById(id)) {
            throw new NeedingException("Needing with given ID not found", "NEEDING_NOT_FOUND");
        }

        needingRepo.delete(this.getOne(id));

        log.info("NeedingServiceImpl | deleteNeeding | Needing Deleted");
    }
}
