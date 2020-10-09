package pl.coderslab.dtapp.domain.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "confirmation_token")
public class ConfirmationToken extends BaseEntity {

    @Column(name = "confirmation_token")
    private String confirmationToken;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
