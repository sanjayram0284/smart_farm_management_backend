package crop.javafullstack.crop.Entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "crops")
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String suitableSeason;
    private double minMoisture;
    private double maxMoisture;
    private double minTemperature;
    private double maxTemperature;
    private double estimatedCost;
    private LocalDate plantedDate;
    private String soilType;
    private double moisture;

    // 🔗 USER MAPPING
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
