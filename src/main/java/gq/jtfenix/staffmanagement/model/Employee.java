package gq.jtfenix.staffmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String role;

    private String profileImgUrl;

    private String team;

    private boolean active;

    private String branch;

    @Column(nullable = false, updatable = false)
    private String batchCode;
}