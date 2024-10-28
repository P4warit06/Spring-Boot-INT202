package sit.practies.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data // Setter Getter EqualandHashcode
public class Profile {
    private String username;
    private String email;
}
