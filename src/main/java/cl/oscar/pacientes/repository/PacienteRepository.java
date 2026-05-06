package cl.oscar.pacientes.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import cl.oscar.pacientes.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long>{
    Paciente getPacienteByDocumento(Long id);
}