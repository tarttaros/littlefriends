package proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.entidades.TypeMedicalConsultation;
@Repository
public interface TypeMedicalConsultationRepo extends JpaRepository<TypeMedicalConsultation,Integer> {
}
