package proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.entidades.Examination;

@Repository
public interface ExaminationRepo  extends JpaRepository<Examination,Integer> {
}
