package tokuronI.group1.denpyoukun.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tokuronI.group1.denpyoukun.entity.Request;

@Repository

public interface RequestRepository extends CrudRepository<Request, Long> {

}
