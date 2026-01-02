package za.ac.tut.patient_service.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientsResponseDTO {

  private String name;
  private String email;
  private String address;
  private String dateOFBirth;



}
