package tokuronI.group1.denpyoukun.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tokuronI.group1.denpyoukun.entity.resident;

@Repository

public interface residentRepository extends CrudRepository<resident, Long> {
    // public List<resident> findByNameLike(String word);
}
