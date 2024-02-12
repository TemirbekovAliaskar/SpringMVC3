package spring.ebtity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_gen")
    @SequenceGenerator(name = "student_gen", sequenceName = "student_seq", allocationSize = 1)
    private Long id;
    private String fullName;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String image;

    public Student(String fullName, int age, Gender gender, String image) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.image = image;
    }

    //    public static void main(String[] args) {
//        Student student = Student.builder()
//                .id(1L)
//                .age(20)
//                .fullName("Aliaskar")
//                .gender(Gender.FEMALE)
//                .image(" https://ca.slack-edge.com/T023L1WBFLH-U05UL2DHP08-c4816c4c5883-512")
//                .build();
//    }


}
