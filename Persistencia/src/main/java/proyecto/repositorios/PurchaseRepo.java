package proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.entidades.Purchase;
@Repository
public interface PurchaseRepo extends JpaRepository<Purchase,Integer> {
}
