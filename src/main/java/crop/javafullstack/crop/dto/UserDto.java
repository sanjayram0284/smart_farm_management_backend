package crop.javafullstack.crop.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String profileImage;
    private String token;
}
