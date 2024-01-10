package ma.fstt.Persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Needing {

    public enum Category {
        Financial,
        Food,
        Clothes,
        Medical,
        Psychological,
        Other
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String Firstname;

    @Column( nullable = false)
    private String Lastname;

    @Column(nullable = false)
    private String description;

    @Column( nullable = false)
    private String country;

    @Column( nullable = false)
    private String address;

    @Column( nullable = false)
    private int age;

    @Column( nullable = false)
    private long phone;

    @Column(nullable = false)
    private String status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private long userId;
}
