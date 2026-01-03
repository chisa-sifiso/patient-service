package za.ac.tut.patient_service.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PatientRequestDTO {
    @NotBlank()
    @Size(max = 100,message = "Name canot exceed 100 charatrs")
    private String name;

    @NotBlank
    @Email(message = "Email should be vaild")
    private String email;

    @NotBlank(message = "Address is requied")
    private String adrress;

    @NotBlank(message = "Date of birth is requied")
    private String dateOfBirth;

    @NotNull(message = "Registered date is required")
    private String registedDate;


}
