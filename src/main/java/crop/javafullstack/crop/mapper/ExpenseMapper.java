package crop.javafullstack.crop.mapper;

import crop.javafullstack.crop.Entity.ExpenseHistory;
import crop.javafullstack.crop.dto.ExpenseHistoryDto;

public class ExpenseMapper {

    public static ExpenseHistoryDto toDto(ExpenseHistory entity) {
        ExpenseHistoryDto dto = new ExpenseHistoryDto();
        dto.setCropName(entity.getCropName());
        dto.setAmount(entity.getAmount());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setUserEmail(entity.getUser().getEmail());
        return dto;
    }
}
