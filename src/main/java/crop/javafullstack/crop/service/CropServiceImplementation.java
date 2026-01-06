package crop.javafullstack.crop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import crop.javafullstack.crop.Entity.Crop;
import crop.javafullstack.crop.Entity.User;
import crop.javafullstack.crop.dto.CropDto;
import crop.javafullstack.crop.mapper.CropMapper;
import crop.javafullstack.crop.repository.CropsRepo;
import crop.javafullstack.crop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CropServiceImplementation implements CropService {

    private final CropsRepo cropsRepo;
    private final UserRepository userRepository;

    @Override
    public CropDto createCrop(CropDto cropDto, String userEmail) {

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Crop crop = CropMapper.mapToCrop(cropDto, user);
        return CropMapper.mapToCropDto(cropsRepo.save(crop));
    }

    @Override
    public List<CropDto> getAllCropsByUser(String userEmail) {
        return cropsRepo.findByUserEmail(userEmail)
                .stream()
                .map(CropMapper::mapToCropDto)
                .toList();
    }

    @Override
    public List<CropDto> getRecommendedCrops(String soil, String season, String userEmail) {
        return cropsRepo
                .findBySoilTypeAndSuitableSeasonAndUserEmail(soil, season, userEmail)
                .stream()
                .map(CropMapper::mapToCropDto)
                .toList();
    }
}
