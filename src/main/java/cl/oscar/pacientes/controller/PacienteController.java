package cl.oscar.pacientes.controller;

import cl.oscar.pacientes.dto.PacienteResponseDTO;
import cl.oscar.pacientes.model.Paciente;
import cl.oscar.pacientes.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    // Este es el metodo que usa Feign Client desde citas
    @GetMapping("/{id}")
    public PacienteResponseDTO obtenerPaciente(@PathVariable Long id) {
        return pacienteService.obtenerPorId(id);
    }

    @PostMapping
    public PacienteResponseDTO guardarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.guardar(paciente);
    }

}