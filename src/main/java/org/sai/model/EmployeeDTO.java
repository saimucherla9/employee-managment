package org.sai.model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.sai.entity.Base;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO extends Base {

    private Long empId;
    @NotNull(message = "First name cannot be null")
    @NotEmpty(message = "First name cannot be empty")
    private String firstName;
    private String lastName;
    @Length(min = 15 , max = 70, message = "Age cannot be less than 15 and more than 70")
    private int age;
    private String sex;
    @NotNull(message = "Subject cannot be null")
    @NotEmpty(message = "Subject cannot be empty")
    private String subject;
    private boolean isEmployeeAbove18;
    private String comments;
}
