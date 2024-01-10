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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Firstname;

    private String Lastname;

    private String description;

    private String country;

    private String address;

    private int age;

    private long phone;

    private String status;


    private String category;

    private long userId;
}
