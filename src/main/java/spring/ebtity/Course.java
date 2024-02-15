package spring.ebtity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(generator ="company_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "company_gen",sequenceName = "company_seq",allocationSize = 1)
    private Long id;
    private String courseName;
    @Column(length = 1000)
    private String description;
    @Column(length = 1000,name = "imageLink")
    private String imageLink;
    private int price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Company company;
}
