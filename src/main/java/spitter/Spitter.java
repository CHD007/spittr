package spitter;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Spitter {
    private Long id;

    @NonNull
    @NotNull
    @Size(min = 5, max = 16, message = "{userName.size}")
    private String userName;

    @NonNull
    @NotNull
    @Size(min = 5, max = 25, message = "{password.size}")
    private String password;

    @NonNull
    @NotNull
    @Size(min =2, max = 30, message = "{firstName.size}")
    private String firstName;

    @NonNull
    @NotNull
    @Size(min = 2, max = 30, message = "{lastName.size}")
    private String lastName;
}
