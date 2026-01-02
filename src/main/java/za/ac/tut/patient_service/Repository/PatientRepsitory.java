package za.ac.tut.patient_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.tut.patient_service.Entity.Patient;
@Repository

public interface PatientRepsitory extends JpaRepository<Patient,Long> {
}
