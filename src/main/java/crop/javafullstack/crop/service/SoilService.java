package crop.javafullstack.crop.service;

import java.util.List;
import crop.javafullstack.crop.dto.CropDto;
import crop.javafullstack.crop.dto.SoilDto;

public interface SoilService {

    // 🔹 Soil cards for a specific user
    List<SoilDto> getAllSoilsByUser(String userEmail);

    // 🔹 Crops for a soil + user
    List<CropDto> getCropsBySoilAndUser(String soilType, String userEmail);
}
