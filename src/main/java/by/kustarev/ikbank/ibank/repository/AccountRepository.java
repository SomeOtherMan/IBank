package by.kustarev.ikbank.ibank.repository;

import by.kustarev.ikbank.ibank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
