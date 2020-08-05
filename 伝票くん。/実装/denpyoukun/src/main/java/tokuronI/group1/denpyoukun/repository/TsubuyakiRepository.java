package tokuronI.group1.denpyoukun.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tokuronI.group1.denpyoukun.entity.Tsubuyaki;

@Repository

public interface TsubuyakiRepository extends CrudRepository<Tsubuyaki, Long> {
    public List<Tsubuyaki> findByCommentLike(String word);
}
