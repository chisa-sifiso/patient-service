package za.ac.tut.patient_service.Service;

import org.springframework.stereotype.Service;
import za.ac.tut.patient_service.Dto.PatientRequestDTO;
import za.ac.tut.patient_service.Dto.PatientsResponseDTO;
import za.ac.tut.patient_service.Entity.Patient;
import za.ac.tut.patient_service.Repository.PatientRepsitory;
import za.ac.tut.patient_service.exception.EmailAlreadyExistException;
import za.ac.tut.patient_service.mapper.PatientMapper;

import java.util.List;

@Service
public class PatientService {
    private PatientRepsitory patientRepsitory;

    public PatientService (PatientRepsitory patientRepsitory){
        this.patientRepsitory=patientRepsitory;

    }

    public List<PatientsResponseDTO> getPatients(){

        List<Patient> patients = patientRepsitory.findAll();

        return patients.stream().map(PatientMapper::toPatientResponseDTO).toList();
    }


    public PatientsResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        if(patientRepsitory.existsPatientByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistException("A patient of this email exits already "+patientRequestDTO.getEmail());
        }
        Patient patient= PatientMapper.toModel(patientRequestDTO);


        Patient newPatient = patientRepsitory.save(patient);
        return PatientMapper.toPatientResponseDTO(newPatient);

    }

}
