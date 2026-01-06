package crop.javafullstack.crop.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import crop.javafullstack.crop.Entity.Crop;
import crop.javafullstack.crop.Entity.ExpenseHistory;
import crop.javafullstack.crop.Entity.User;
import crop.javafullstack.crop.dto.ExpenseHistoryDto;
import crop.javafullstack.crop.mapper.ExpenseMapper;
import crop.javafullstack.crop.repository.CropsRepo;
import crop.javafullstack.crop.repository.ExpenseHistoryRepository;
import crop.javafullstack.crop.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final CropsRepo cropsRepo;
    private final ExpenseHistoryRepository historyRepository;
    private final UserRepository userRepository;

    @Override
    public void updateExpense(String cropName, double newAmount, String userEmail) {

        User user = userRepository.findByEmail(userEmail)
            .orElseThrow(() -> new RuntimeException("User not found"));

        Crop crop = cropsRepo
            .findByNameAndUser_Email(cropName, userEmail)
            .orElseThrow(() -> new RuntimeException("Crop not found"));

        crop.setEstimatedCost(crop.getEstimatedCost() + newAmount);
        cropsRepo.save(crop);

        ExpenseHistory history = new ExpenseHistory(
            null,
            cropName,
            newAmount,
            LocalDate.now(),
            user
        );

        historyRepository.save(history);
    }


    @Override
    public List<ExpenseHistoryDto> getExpenseHistory(
            String cropName,
            String userEmail
    ) {
        return historyRepository
                .findByCropNameAndUser_Email(cropName, userEmail)
                .stream()
                .map(ExpenseMapper::toDto)
                .collect(Collectors.toList());
    }
}

