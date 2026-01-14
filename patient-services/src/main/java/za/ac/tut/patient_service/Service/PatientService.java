package za.ac.tut.patient_service.Service;

import org.springframework.stereotype.Service;
import za.ac.tut.patient_service.Dto.PatientRequestDTO;
import za.ac.tut.patient_service.Dto.PatientsResponseDTO;
import za.ac.tut.patient_service.Entity.Patient;
import za.ac.tut.patient_service.Repository.PatientRepsitory;
import za.ac.tut.patient_service.exception.EmailAlreadyExistException;
import za.ac.tut.patient_service.exception.PatientNotFoundException;
import za.ac.tut.patient_service.grpc.BillingServiceGrpcClient;
import za.ac.tut.patient_service.mapper.PatientMapper;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {
    private PatientRepsitory patientRepsitory;
    private  BillingServiceGrpcClient billingServiceGrpcClient;

    public PatientService (PatientRepsitory patientRepsitory,BillingServiceGrpcClient billingServiceGrpcClient){
        this.patientRepsitory=patientRepsitory;
        this.billingServiceGrpcClient=billingServiceGrpcClient;

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
        billingServiceGrpcClient.createBillingAccount(newPatient.getId().toString() ,
                newPatient.getName() , newPatient.getEmail());
        return PatientMapper.toPatientResponseDTO(newPatient);


    }
    public PatientsResponseDTO updatePatient(Long id,PatientRequestDTO patientRequestDTO){
        Patient patient = patientRepsitory.findById(id).orElseThrow(() ->new PatientNotFoundException("Cant find patient" +id ));
        if(patientRepsitory.existsByEmailAndIdNot(patientRequestDTO.getEmail(),id)){
            throw new EmailAlreadyExistException("A patient of this email exits already "+patientRequestDTO.getEmail());
        }

        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setEmail(patientRequestDTO.getEmail());

        Patient updatedPatient =patientRepsitory.save(patient);
        return PatientMapper.toPatientResponseDTO(updatedPatient);


    }
    public void deletePatient(Long id){
        Patient patient = patientRepsitory.findById(id).orElseThrow(() ->new PatientNotFoundException("Cant find patient" +id ));
        patientRepsitory.deleteById(patient.getId());

    }

}
