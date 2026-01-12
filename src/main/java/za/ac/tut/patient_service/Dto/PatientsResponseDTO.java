package za.ac.tut.patient_service.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientsResponseDTO {
  private String id;
  private String name;
  private String email;
  private String address;
  private String dateOFBirth;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDateOFBirth() {
    return dateOFBirth;
  }

  public void setDateOFBirth(String dateOFBirth) {
    this.dateOFBirth = dateOFBirth;
  }
}
