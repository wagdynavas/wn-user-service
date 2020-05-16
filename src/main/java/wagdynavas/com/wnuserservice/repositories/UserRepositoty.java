package wagdynavas.com.wnuserservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wagdynavas.com.wnuserservice.entities.User;

import java.util.Optional;

@Repository
public interface UserRepositoty extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
