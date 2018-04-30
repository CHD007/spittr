package spitter.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Spitter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @NotNull
    @Size(min = 5, max = 16, message = "{userName.size}")
    @Column
    private String userName;

    @NonNull
    @NotNull
    @Size(min = 5, max = 25, message = "{password.size}")
    @Column
    private String password;

    @NonNull
    @NotNull
    @Size(min =2, max = 30, message = "{firstName.size}")
    @Column
    private String firstName;

    @NonNull
    @NotNull
    @Size(min = 2, max = 30, message = "{lastName.size}")
    @Column
    private String lastName;
}
