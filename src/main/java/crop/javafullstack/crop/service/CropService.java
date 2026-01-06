package crop.javafullstack.crop.service;

import java.util.List;
import crop.javafullstack.crop.dto.CropDto;

public interface CropService {

    CropDto createCrop(CropDto cropDto, String userEmail);

    List<CropDto> getAllCropsByUser(String userEmail);

    List<CropDto> getRecommendedCrops(
        String soil,
        String season,
        String userEmail
    );
}
