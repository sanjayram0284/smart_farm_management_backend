package crop.javafullstack.crop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignupDto {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String profileImage;
}
