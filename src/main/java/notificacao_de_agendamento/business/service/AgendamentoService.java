package notificacao_de_agendamento.business.service;

import lombok.RequiredArgsConstructor;
import notificacao_de_agendamento.business.dto.AgendamentoRequestDTO;
import notificacao_de_agendamento.business.dto.AgendamentoResponseDTO;
import notificacao_de_agendamento.business.mapper.AgendamentoMapper;
import notificacao_de_agendamento.business.service.exceptions.ResourceNotFoundException;
import notificacao_de_agendamento.infrastructure.repositories.AgendamentoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final AgendamentoMapper mapper;

    public AgendamentoResponseDTO criarAgendamento(AgendamentoRequestDTO requestDto) {
        return mapper.paraResponseDTO(
                repository.save(mapper.paraEntity(requestDto)));
    }

    public AgendamentoResponseDTO consultaAgendamento(Long id) {
        return mapper.paraResponseDTO(
                repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    public void cancelarAgendamento(Long id) {
        repository.save(mapper.paraEntityCancelamento(
                repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id))));
    }

}
