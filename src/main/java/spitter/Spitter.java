package spitter;

import lombok.*;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Spitter {
    private Long id;

    @NonNull
    @Size(min = 5, max = 16)
    private String userName;

    @NonNull
    @Size(min = 5, max = 25)
    private String password;

    @NonNull
    @Size(min =2, max = 30)
    private String firstName;

    @NonNull
    @Size(min = 2, max = 30)
    private String lastName;
}
