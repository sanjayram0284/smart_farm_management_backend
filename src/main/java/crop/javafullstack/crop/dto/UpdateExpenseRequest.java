package crop.javafullstack.crop.dto;

import lombok.Data;

@Data
public class UpdateExpenseRequest {

    private String cropName;
    private double amount;
}
