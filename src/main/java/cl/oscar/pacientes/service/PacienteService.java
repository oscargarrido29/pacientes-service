package cl.oscar.pacientes.service;

import cl.oscar.pacientes.dto.PacienteResponseDTO;
import cl.oscar.pacientes.model.Paciente;
import cl.oscar.pacientes.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteResponseDTO obtenerPorId(Long id){
        //Buscamos la entidad de la base de datos

        Paciente paciente = pacienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        //Mapear
        PacienteResponseDTO dto = new PacienteResponseDTO();
        dto.setId(paciente.getId());
        dto.setNombre(paciente.getNombre());
        dto.setDocumento(paciente.getDocumento());
        dto.setFechaNacimiento(paciente.getFechaNacimiento());

        return dto;
    }
            
    public Paciente guardar(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

}