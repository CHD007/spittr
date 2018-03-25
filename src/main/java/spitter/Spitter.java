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
    @Size(min = 5, max = 16)
    private String userName;

    @NonNull
    @NotNull
    @Size(min = 5, max = 25)
    private String password;

    @NonNull
    @NotNull
    @Size(min =2, max = 30)
    private String firstName;

    @NonNull
    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;
}
