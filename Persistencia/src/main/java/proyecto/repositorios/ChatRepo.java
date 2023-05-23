package proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.entidades.Chat;

@Repository
public interface ChatRepo extends JpaRepository<Chat,Integer> {
}
