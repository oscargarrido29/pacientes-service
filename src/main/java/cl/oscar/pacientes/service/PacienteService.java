package cl.oscar.pacientes.service;

import cl.oscar.pacientes.dto.PacienteRequestDTO;
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
            
    public PacienteResponseDTO guardar(PacienteRequestDTO pacienteRequestDTO){

        //Mapeamos DTO de entrada a Entidad
        Paciente paciente = new Paciente();
        paciente.setNombre(pacienteRequestDTO.getNombre());
        paciente.setDocumento(pacienteRequestDTO.getDocumento());
        paciente.setFechaNacimiento(pacienteRequestDTO.getFechaNacimiento());

        //Guardamos la entidad
        Paciente pacienteGuardado = pacienteRepository.save(paciente);

        //Retornamos DTO de respuesta
        return mapToResponseDTO(pacienteGuardado);
       
    }

    private PacienteResponseDTO mapToResponseDTO(Paciente paciente){
        PacienteResponseDTO dto = new PacienteResponseDTO();
        dto.setId(paciente.getId());
        dto.setNombre(paciente.getNombre());
        dto.setDocumento(paciente.getDocumento());
        dto.setFechaNacimiento(paciente.getFechaNacimiento());

        return dto;
    }

}