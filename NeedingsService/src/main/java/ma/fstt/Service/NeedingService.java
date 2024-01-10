package ma.fstt.Service;

import ma.fstt.Persistence.Needing;

import java.util.List;

public interface NeedingService {

    Needing getOne(Long id);

    List<Needing> getAll();


    Needing save(Needing needing);

    void update(Long id, Needing needing);

    void delete(Long id);
}
