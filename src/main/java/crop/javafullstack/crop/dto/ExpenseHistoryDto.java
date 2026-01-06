package crop.javafullstack.crop.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class ExpenseHistoryDto {

    private String cropName;
    private double amount;
    private LocalDate updatedDate;
    private String userEmail;
}