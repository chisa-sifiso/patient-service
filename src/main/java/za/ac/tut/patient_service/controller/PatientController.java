package za.ac.tut.patient_service.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.tut.patient_service.Dto.PatientRequestDTO;
import za.ac.tut.patient_service.Dto.PatientsResponseDTO;
import za.ac.tut.patient_service.Service.PatientService;

import java.util.List;


@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientsResponseDTO>> getPatients(){
        List<PatientsResponseDTO> patients= patientService.getPatients();

        return ResponseEntity.ok().body(patients);
    }
    @PostMapping
    public ResponseEntity<PatientsResponseDTO> creatPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO){
        PatientsResponseDTO patientsResponseDTO=  patientService.createPatient(patientRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(patientsResponseDTO);
    }


}
