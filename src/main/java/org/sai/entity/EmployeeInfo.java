package org.sai.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Data
@Entity // Mandatory
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employeeData") // Optional
public class EmployeeInfo extends Base implements Serializable {
    @Id
    //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeGenerator")
    @SequenceGenerator(name = "employeeGenerator", sequenceName = "employeeGen", initialValue = 1000, allocationSize = 100)
    private Long empId;
    @NotNull(message = "First name cannot be null")
    @NotEmpty(message = "First name cannot be empty")
    private String firstName;
    private String lastName;
    // @Length(min = 15 , max = 70, message = "Age cannot be less than 15 and more than 70")
    private int age;
    @Column(name = "sex")
    private String sex;
    @NotNull(message = "Subject cannot be null")
    @NotEmpty(message = "Subject cannot be empty")
    private String subject;
    private boolean isEmployeeAbove18;
    private String comments;

}
