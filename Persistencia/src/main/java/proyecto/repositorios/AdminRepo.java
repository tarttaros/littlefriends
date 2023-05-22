package proyecto.repositorios;

import org.springframework.stereotype.Repository;
import proyecto.entidades.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {

    @Query("select a from Admin a where a.email = ?1 and a.password = ?2")
    Optional<Admin> findByEmailAndPassword(String email, String password);
}
