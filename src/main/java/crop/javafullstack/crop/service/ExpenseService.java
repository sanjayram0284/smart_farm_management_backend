package crop.javafullstack.crop.service;

import java.util.List;
import crop.javafullstack.crop.dto.ExpenseHistoryDto;

public interface ExpenseService {

    void updateExpense(String cropName, double newAmount, String userEmail);

    List<ExpenseHistoryDto> getExpenseHistory(
        String cropName,
        String userEmail
    );
}
