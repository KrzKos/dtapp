package pl.coderslab.dtapp.domain.entities;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "cases")
public class Cases extends BaseEntity {

    @Column(name = "patient_name")
    private String patientName;
    @Column(name = "order_time")
    private LocalDateTime orderTime;
    private LocalDate deadline;
    @Column(name = "finish_time")
    private LocalDateTime finishTime;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Tooth> teeth;
    @Lob
    @Column(length = 600)
    private String note;
    @OneToMany( mappedBy = "cases", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private User dentist;
    @ManyToOne
    @JoinColumn(name = "technician_id")
    private User technician;
    @ManyToOne
    private Laboratory laboratory;
}
