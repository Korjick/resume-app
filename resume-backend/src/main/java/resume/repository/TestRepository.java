package resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import resume.domain.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
}
