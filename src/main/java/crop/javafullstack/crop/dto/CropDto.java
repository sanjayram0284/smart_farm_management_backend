package crop.javafullstack.crop.dto;

import java.time.LocalDate;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CropDto {

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

    // 🔑 USED TO MAP USER
    private String userEmail;
}
