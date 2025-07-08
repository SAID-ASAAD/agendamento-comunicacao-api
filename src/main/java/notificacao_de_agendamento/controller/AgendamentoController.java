package notificacao_de_agendamento.controller;

import lombok.RequiredArgsConstructor;
import notificacao_de_agendamento.business.dto.AgendamentoRequestDTO;
import notificacao_de_agendamento.business.dto.AgendamentoResponseDTO;
import notificacao_de_agendamento.business.service.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService service;

    @PostMapping
    public ResponseEntity<AgendamentoResponseDTO> criarAgendamento(@RequestBody AgendamentoRequestDTO requestDto) {
        return ResponseEntity.ok(service.criarAgendamento(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponseDTO> consultaAgendamento(@PathVariable Long id) {
        return ResponseEntity.ok(service.consultaAgendamento(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarAgendamento(@PathVariable Long id) {
        service.cancelarAgendamento(id);
        return ResponseEntity.accepted().build();
    }
}
