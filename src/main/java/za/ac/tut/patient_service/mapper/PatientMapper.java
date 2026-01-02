package za.ac.tut.patient_service.mapper;

import za.ac.tut.patient_service.Dto.PatientsResponseDTO;
import za.ac.tut.patient_service.Entity.Patient;

public class PatientMapper {
    public static PatientsResponseDTO toPatientResponseDTO(Patient patient){
        PatientsResponseDTO patientsResponseDTO = new PatientsResponseDTO();
        patientsResponseDTO.setName(patient.getName());
        patientsResponseDTO.setEmail(patient.getEmail());
        patientsResponseDTO.setAddress(patient.getAddress());
        patientsResponseDTO.setDateOFBirth(patient.getDateOfBirth().toString());

        return patientsResponseDTO;


    }
}
