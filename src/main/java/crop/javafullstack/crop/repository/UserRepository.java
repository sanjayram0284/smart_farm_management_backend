package crop.javafullstack.crop.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import crop.javafullstack.crop.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
