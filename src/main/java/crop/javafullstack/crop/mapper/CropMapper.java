package crop.javafullstack.crop.mapper;

import crop.javafullstack.crop.Entity.Crop;
import crop.javafullstack.crop.Entity.User;
import crop.javafullstack.crop.dto.CropDto;

public class CropMapper {

    // ENTITY → DTO
    public static CropDto mapToCropDto(Crop crop) {
        return new CropDto(
                crop.getId(),
                crop.getName(),
                crop.getSuitableSeason(),
                crop.getMinMoisture(),
                crop.getMaxMoisture(),
                crop.getMinTemperature(),
                crop.getMaxTemperature(),
                crop.getEstimatedCost(),
                crop.getPlantedDate(),
                crop.getSoilType(),
                crop.getMoisture(),
                crop.getUser().getEmail()
        );
    }

    // DTO → ENTITY
    public static Crop mapToCrop(CropDto dto, User user) {
        Crop crop = new Crop();
        crop.setName(dto.getName());
        crop.setSuitableSeason(dto.getSuitableSeason());
        crop.setMinMoisture(dto.getMinMoisture());
        crop.setMaxMoisture(dto.getMaxMoisture());
        crop.setMinTemperature(dto.getMinTemperature());
        crop.setMaxTemperature(dto.getMaxTemperature());
        crop.setEstimatedCost(dto.getEstimatedCost());
        crop.setPlantedDate(dto.getPlantedDate());
        crop.setSoilType(dto.getSoilType());
        crop.setMoisture(dto.getMoisture());
        crop.setUser(user); // 🔥 IMPORTANT
        return crop;
    }
}
