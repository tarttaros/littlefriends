package proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import proyecto.entidades.Pet;
import proyecto.entidades.User;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>
{
    @Query("select p from Pet p where p.user.id=:id")
    Optional<Pet> getPetByIDUser(int id);

    @Query("select u from User u where u.email=:email")
    Optional<User> findByEmail(String email);

    @Query("select u from User u where u.email = ?1 and u.password = ?2")
    User getByEmailAndPassword(String email, String password);

    @Query("select u from User u where u.identification = ?1")
    User getByIdentification(String identification);

}
