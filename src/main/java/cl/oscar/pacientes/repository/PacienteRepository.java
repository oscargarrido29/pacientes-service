package cl.oscar.pacientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.oscar.pacientes.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente getPatientByDocumento(Long id);
}