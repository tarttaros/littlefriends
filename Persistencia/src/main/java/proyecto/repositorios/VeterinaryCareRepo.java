package proyecto.repositorios;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.entidades.VeterinaryCare;

@Repository
public interface VeterinaryCareRepo extends JpaRepository<VeterinaryCare,Integer> {
}
