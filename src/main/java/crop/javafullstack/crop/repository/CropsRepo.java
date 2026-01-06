package crop.javafullstack.crop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import crop.javafullstack.crop.Entity.Crop;
import crop.javafullstack.crop.Entity.User;

public interface CropsRepo extends JpaRepository<Crop, Long> {

    Optional<Crop> findByName(String name);

    List<Crop> findByUserEmail(String email);
    

    List<Crop> findBySoilTypeAndSuitableSeasonAndUserEmail(
            String soilType,
            String suitableSeason,
            String email
    );
    @Query("SELECT DISTINCT c.soilType FROM Crop c WHERE c.user.email = :email")
    List<String> findDistinctSoilTypeByUserEmail(String email);
    List<Crop> findBySoilTypeAndUserEmail(String soilType, String email);

   Optional<Crop> findByNameAndUser_Email(String name, String email);
	

}
