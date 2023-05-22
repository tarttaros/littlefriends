package proyecto.repositorios;

import org.springframework.stereotype.Repository;
import proyecto.entidades.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductImageRepo extends JpaRepository<ProductImage,Integer> {
}
