package proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.entidades.TypePet1;

public interface TypePetRepo extends JpaRepository<TypePet1,Integer> {
}