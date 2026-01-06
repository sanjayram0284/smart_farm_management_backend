package crop.javafullstack.crop.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "expense_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cropName;
    private double amount;
    private LocalDate updatedDate;

    // 🔗 USER MAPPING
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
