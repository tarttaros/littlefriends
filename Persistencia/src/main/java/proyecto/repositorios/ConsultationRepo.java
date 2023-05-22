package proyecto.repositorios;

import org.springframework.stereotype.Repository;
import proyecto.entidades.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ConsultationRepo extends JpaRepository<Consultation,Integer> {
}
