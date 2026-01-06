package crop.javafullstack.crop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import crop.javafullstack.crop.dto.CropDto;
import crop.javafullstack.crop.dto.SoilDto;
import crop.javafullstack.crop.mapper.CropMapper;
import crop.javafullstack.crop.repository.CropsRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SoilServiceImpl implements SoilService {

    private final CropsRepo cropsRepo;

    // ✅ GET DISTINCT SOILS FOR LOGGED-IN USER
    @Override
    public List<SoilDto> getAllSoilsByUser(String userEmail) {

        return cropsRepo.findDistinctSoilTypeByUserEmail(userEmail)
                .stream()
                .map(SoilDto::new)
                .collect(Collectors.toList());
    }

    // ✅ GET CROPS BY SOIL + USER
    @Override
    public List<CropDto> getCropsBySoilAndUser(String soilType, String userEmail) {

        return cropsRepo.findBySoilTypeAndUserEmail(soilType, userEmail)
                .stream()
                .map(CropMapper::mapToCropDto)
                .collect(Collectors.toList());
    }
}
