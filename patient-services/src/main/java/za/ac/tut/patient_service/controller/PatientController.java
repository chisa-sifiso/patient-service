package za.ac.tut.patient_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import za.ac.tut.patient_service.Dto.PatientRequestDTO;
import za.ac.tut.patient_service.Dto.PatientsResponseDTO;
import za.ac.tut.patient_service.Dto.validators.CreatePatientValidationGroup;
import za.ac.tut.patient_service.Service.PatientService;

import java.util.List;


@RestController
@RequestMapping("/patients")
@Tag(name="Patient",description = "API For managing Patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary = "Get Patients")
    public ResponseEntity<List<PatientsResponseDTO>> getPatients(){
        List<PatientsResponseDTO> patients= patientService.getPatients();

        return ResponseEntity.ok().body(patients);
    }
    @PostMapping
    @Operation(summary = "Create Patients")
    public ResponseEntity<PatientsResponseDTO> creatPatient(@Validated({Default.class, CreatePatientValidationGroup.class}) @RequestBody PatientRequestDTO patientRequestDTO){
        PatientsResponseDTO patientsResponseDTO=  patientService.createPatient(patientRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(patientsResponseDTO);
    }
   @PutMapping("/{id}")
   @Operation(summary = "Update Patients")
    public ResponseEntity<PatientsResponseDTO> updatePatient(@PathVariable Long id,@Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO){
       PatientsResponseDTO patientsResponseDTO=patientService.updatePatient(id,patientRequestDTO);
       return ResponseEntity.ok().body(patientsResponseDTO);
    }
    @DeleteMapping("{id}")
    @Operation(summary = "Delete Patients")
    public ResponseEntity deletePatient(@PathVariable Long id){
         patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

}
