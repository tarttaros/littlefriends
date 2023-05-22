package proyecto.repositorios;


import org.springframework.stereotype.Repository;
import proyecto.entidades.Veterinary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Repository
public interface VeterinaryRepo extends JpaRepository<Veterinary,Integer> {

    @Query("select v from Veterinary v where v.email = ?1")
    Optional<Veterinary> findByEmail(String email);

    @Query("select v from Veterinary v where v.email = ?1 and v.password = ?2")
    Optional<Veterinary> findByEmailAndPassword(String email, String password);
}
