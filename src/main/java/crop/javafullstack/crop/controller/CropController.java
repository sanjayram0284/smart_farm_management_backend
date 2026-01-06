package crop.javafullstack.crop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import crop.javafullstack.crop.dto.CropDto;
import crop.javafullstack.crop.service.CropService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/crops")
@CrossOrigin
@RequiredArgsConstructor
public class CropController {

    private final CropService cropService;

    // ✅ CREATE crop (USER AWARE via JWT)
    @PostMapping
    public ResponseEntity<CropDto> createCrop(
            @RequestBody CropDto cropDto
    ) {
        String userEmail = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        CropDto savedCrop = cropService.createCrop(cropDto, userEmail);
        return new ResponseEntity<>(savedCrop, HttpStatus.CREATED);
    }

    // ✅ GET crops by logged-in user
    @GetMapping
    public List<CropDto> getCropsByUser() {

        String userEmail = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return cropService.getAllCropsByUser(userEmail);
    }

    // ✅ RECOMMENDATION (USER AWARE via JWT)
    @GetMapping("/recommend")
    public List<CropDto> recommendCrops(
            @RequestParam String soil,
            @RequestParam String season
    ) {
        String userEmail = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return cropService.getRecommendedCrops(soil, season, userEmail);
    }
}
