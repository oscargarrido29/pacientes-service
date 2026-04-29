package cl.oscar.pacientes.controller;

import cl.oscar.pacientes.dto.PacienteResponseDTO;
import cl.oscar.pacientes.model.Paciente;
import cl.oscar.pacientes.service.PacienteService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    //Metodo para usae el feig Cliente desde citas
    @GetMapping("/{id}")
    public PacienteResponseDTO obtenerPaciente(@PathVariable Long id){
        return pacienteService.obtenerPorId(id);
    }

    @PostMapping
    public Paciente guardarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardar(paciente);
    }

}