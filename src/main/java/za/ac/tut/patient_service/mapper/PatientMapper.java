package za.ac.tut.patient_service.mapper;

import za.ac.tut.patient_service.Dto.PatientRequestDTO;
import za.ac.tut.patient_service.Dto.PatientsResponseDTO;
import za.ac.tut.patient_service.Entity.Patient;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientsResponseDTO toPatientResponseDTO(Patient patient){
        PatientsResponseDTO patientsResponseDTO = new PatientsResponseDTO();
        patientsResponseDTO.setId(patient.getId().toString());
        patientsResponseDTO.setName(patient.getName());
        patientsResponseDTO.setEmail(patient.getEmail());
        patientsResponseDTO.setAddress(patient.getAddress());
        patientsResponseDTO.setDateOFBirth(patient.getDateOfBirth().toString());

        return patientsResponseDTO;


    }
    public  static Patient toModel(PatientRequestDTO patientRequestDTO){
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAdrress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegisterDate(LocalDate.parse(patientRequestDTO.getRegistedDate()));
        return patient;

    }
}
