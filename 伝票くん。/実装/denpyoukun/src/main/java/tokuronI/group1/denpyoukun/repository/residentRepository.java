package tokuronI.group1.denpyoukun.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tokuronI.group1.denpyoukun.entity.Resident;

@Repository

public interface residentRepository extends CrudRepository<Resident, Long> {

    Optional<Resident> findByName(String name);
    // public List<resident> findByNameLike(String word);
}
