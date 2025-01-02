package bancolombia.persistence;

import bancolombia.model.AccessByUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessByUserRepository extends JpaRepository<AccessByUser, Integer> {
}