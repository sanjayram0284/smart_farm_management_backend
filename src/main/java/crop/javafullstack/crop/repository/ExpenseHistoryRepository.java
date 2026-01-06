package crop.javafullstack.crop.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import crop.javafullstack.crop.Entity.ExpenseHistory;

public interface ExpenseHistoryRepository
        extends JpaRepository<ExpenseHistory, Long> {

	List<ExpenseHistory> findByCropNameAndUser_Email(
		    String cropName,
		    String email
		);
}
