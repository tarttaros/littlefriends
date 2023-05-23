package proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.entidades.Message;


@Repository
public interface MessageRepo extends JpaRepository<Message,Integer> {
}
