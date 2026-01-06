package crop.javafullstack.crop.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import crop.javafullstack.crop.dto.ExpenseHistoryDto;
import crop.javafullstack.crop.dto.UpdateExpenseRequest;
import crop.javafullstack.crop.service.ExpenseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PutMapping("/update")
    public void updateExpense(
            @RequestBody UpdateExpenseRequest request
    ) {
        String userEmail = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        expenseService.updateExpense(
                request.getCropName(),
                request.getAmount(),
                userEmail
        );
    }

    @GetMapping("/history/{cropName}")
    public List<ExpenseHistoryDto> getExpenseHistory(
            @PathVariable String cropName
    ) {
        String userEmail = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return expenseService.getExpenseHistory(cropName, userEmail);
    }
}
