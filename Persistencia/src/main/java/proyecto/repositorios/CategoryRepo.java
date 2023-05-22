package proyecto.repositorios;

import org.springframework.stereotype.Repository;
import proyecto.entidades.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {

    @Query("select c from Category c where c.description=:name")
    Category findByName(String name);

}
