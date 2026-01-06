package crop.javafullstack.crop.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import crop.javafullstack.crop.dto.CropDto;
import crop.javafullstack.crop.dto.SoilDto;
import crop.javafullstack.crop.service.SoilService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/soil")
@CrossOrigin
@RequiredArgsConstructor
public class SoilController {

    private final SoilService soilService;

    // 🌱 1️⃣ Get soil cards for logged-in user (JWT based)
    @GetMapping
    public List<SoilDto> getSoilsByUser() {

        String userEmail = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return soilService.getAllSoilsByUser(userEmail);
    }

    // 🌾 2️⃣ Get crops by soil + logged-in user (JWT based)
    @GetMapping("/{soilType}")
    public List<CropDto> getCropsBySoilAndUser(
            @PathVariable String soilType
    ) {
        String userEmail = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return soilService.getCropsBySoilAndUser(soilType, userEmail);
    }
}
