package atos.upgrade.storecustomer.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tbl_customers")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Number ID must not be empty")
    @Size(min = 8, max = 8, message = "Number ID must be 8 digits")
    @Column(name = "number_id", nullable = false, unique = true, length = 8)
    private String numberID;

    @NotEmpty(message = "First name must not be empty")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @NotEmpty(message = "Last name must not be empty")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @NotEmpty(message = "Email must not be empty")
    @Size(min = 5, max = 50, message = "Email must be between 5 and 50 characters")
    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "photo_url")
    private String photoURL;

    @NotNull(message = "Region must not be empty")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Region region;

    private String state;
}
