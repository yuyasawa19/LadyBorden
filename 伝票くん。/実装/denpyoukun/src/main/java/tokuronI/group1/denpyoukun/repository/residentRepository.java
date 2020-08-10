package tokuronI.group1.denpyoukun.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tokuronI.group1.denpyoukun.entity.Resident;

@Repository

public interface residentRepository extends CrudRepository<Resident, Long> {
    // public List<resident> findByNameLike(String word);
}
