package bancolombia.persistence;

import bancolombia.model.BranchByUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchByUserRepository extends JpaRepository<BranchByUser, String> {
}