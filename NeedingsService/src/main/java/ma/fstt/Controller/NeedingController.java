package ma.fstt.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import ma.fstt.Persistence.Needing;
import ma.fstt.Service.NeedingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/needing")
@RequiredArgsConstructor
@Log4j2
public class NeedingController {

    private final NeedingService needingService;

    @PostMapping
    public ResponseEntity<Long> createNeeding(@RequestBody Needing needing) {
        log.info("NeedingController | createNeeding is called");
        log.info("NeedingController | createNeeding | Needing Request: " + needing.toString());

        Long needingId = needingService.save(needing).getId();
        return new ResponseEntity<>(needingId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Needing> getNeedingById(@PathVariable("id") Long id) {
        log.info("NeedingController | getNeedingById is called");
        log.info("NeedingController | getNeedingById | Needing ID: " + id);

        Needing needing = needingService.getOne(id);
        return new ResponseEntity<>(needing, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Needing>> getAllNeedings() {
        log.info("NeedingController | getAllNeedings is called");

        List<Needing> needings = needingService.getAll();
        return new ResponseEntity<>(needings, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateNeeding(@PathVariable("id") Long id, @RequestBody Needing needing) {
        log.info("NeedingController | updateNeeding is called");
        log.info("NeedingController | updateNeeding | Needing ID: " + id);
        log.info("NeedingController | updateNeeding | Updated Needing: " + needing.toString());

        needingService.update(id, needing);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNeedingById(@PathVariable("id") Long id) {
        log.info("NeedingController | deleteNeedingById is called");
        log.info("NeedingController | deleteNeedingById | Needing ID: " + id);

        needingService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
