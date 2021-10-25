package pydra.integration.Employee;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQ_YDR_GENERAL")
    @SequenceGenerator(sequenceName = "SEQ_YDR_GENERAL", allocationSize = 1, name = "SEQ_YDR_GENERAL")
    @Column(name = "id")
    private Long id;

    @JsonProperty("name") // οταν θελω να αλλάξω ονομα στο πεδιο στο json
    @NotBlank(message="Sould not be blank")
    @Column(name="name")
    private String name;

//    @JsonIgnore  // γινεται invisible στο json
    @Column(name="age")
    private Long age = 0L;  //default value

    @Column(name="location")
    private String location;

    @Email(message="Enter valid email address")
    @Column(name="email")
    private String email;

    @Column(name="department")
    private String department;

    @CreationTimestamp
    @Column(name="createdat", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name="updatedat")
    private Date updatedAt;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
