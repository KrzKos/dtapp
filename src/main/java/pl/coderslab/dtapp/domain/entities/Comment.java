package pl.coderslab.dtapp.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Getter @Setter
@Entity
public class Comment extends BaseEntity{

    private String text;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
