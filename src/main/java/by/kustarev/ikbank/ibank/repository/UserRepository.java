package by.kustarev.ikbank.ibank.repository;

import by.kustarev.ikbank.ibank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
