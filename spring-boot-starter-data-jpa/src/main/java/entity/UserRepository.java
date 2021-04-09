package entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@ComponentScan
@Component
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    List<User> findUserByName();
}
