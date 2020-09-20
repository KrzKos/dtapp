package pl.coderslab.dtapp.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter @ToString
@Entity
@Table(name = "cases")
public class Case extends BaseEntity {

    @Column(name = "patient_name")
    private String patientName;
    @Column(name = "order_time")
    private LocalDateTime orderTime;
    private LocalDateTime deadline;
    @Column(name = "finish_time")
    private LocalDateTime finishTime;
    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private User principal;
    @ManyToOne
    @JoinColumn(name = "technician_id")
    private User creator;
}
