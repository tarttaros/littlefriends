package proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.entidades.PurchaseDetail;

@Repository
public interface PurchaseDetailRepo extends JpaRepository<PurchaseDetail,Integer> {
}
