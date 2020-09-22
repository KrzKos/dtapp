package pl.coderslab.dtapp.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter @Setter
@Entity
public class Comment extends BaseEntity{

    private String text;
}
