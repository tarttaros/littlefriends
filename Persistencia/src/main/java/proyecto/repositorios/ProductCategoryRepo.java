package proyecto.repositorios;

import org.springframework.stereotype.Repository;
import proyecto.entidades.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategory,Integer> {
}
