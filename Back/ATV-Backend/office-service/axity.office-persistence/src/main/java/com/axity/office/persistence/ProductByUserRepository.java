package bancolombia.persistence;

import bancolombia.model.ProductByUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductByUserRepository extends JpaRepository<ProductByUser, String> {
}