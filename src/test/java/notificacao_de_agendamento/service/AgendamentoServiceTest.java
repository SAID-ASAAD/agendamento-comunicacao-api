package notificacao_de_agendamento.service;

import notificacao_de_agendamento.business.dto.AgendamentoRequestDTO;
import notificacao_de_agendamento.business.dto.AgendamentoResponseDTO;
import notificacao_de_agendamento.business.mapper.AgendamentoMapper;
import notificacao_de_agendamento.business.service.AgendamentoService;
import notificacao_de_agendamento.business.service.exceptions.ResourceNotFoundException;
import notificacao_de_agendamento.infrastructure.entities.Agendamento;
import notificacao_de_agendamento.infrastructure.enums.StatusNotificacaoEnum;
import notificacao_de_agendamento.infrastructure.repositories.AgendamentoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AgendamentoServiceTest {

    @Mock
    private AgendamentoRepository repository;

    @Mock
    private AgendamentoMapper mapper;

    @InjectMocks
    private AgendamentoService service;

    Agendamento agendamentoEntity;
    AgendamentoRequestDTO requestDto;
    AgendamentoResponseDTO responseDto;

    @BeforeEach
    void setUp() {
        agendamentoEntity = new Agendamento(1L, "said@email.com", "1234556678754",
                "No cume calmo do meu olho que ve assenta a sombra sonora de um disco voador",
                LocalDateTime.of(2025, 12, 30, 12, 30),
                LocalDateTime.now(), null, StatusNotificacaoEnum.AGENDADO);

        requestDto = new AgendamentoRequestDTO("said@email.com", "1234556678754",
                "No cume calmo do meu olho que ve assenta a sombra sonora de um disco voador",
                LocalDateTime.of(2025, 12, 30, 12, 30));

        responseDto = new AgendamentoResponseDTO(1L, "said@email.com", "1234556678754",
                "No cume calmo do meu olho que ve assenta a sombra sonora de um disco voador",
                LocalDateTime.of(2025, 12, 30, 12, 30), StatusNotificacaoEnum.AGENDADO);
    }

    @Test
    void deveCriarAgendamentoComSucesso() {
        when(mapper.paraEntity(requestDto)).thenReturn(agendamentoEntity);
        when(repository.save(agendamentoEntity)).thenReturn(agendamentoEntity);
        when(mapper.paraResponseDTO(agendamentoEntity)).thenReturn(responseDto);

        AgendamentoResponseDTO response = service.criarAgendamento(requestDto);

        verify(mapper, times(1)).paraEntity(requestDto);
        verifyNoMoreInteractions(repository);

        Assertions.assertEquals(response, responseDto);
    }

    // @Test
    //void NaoDeveCriarAgentamento  tratar excecao com try/catch

    @Test
    void deveConsultarAgendamentoComSucesso() {
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(agendamentoEntity));
        when(mapper.paraResponseDTO(agendamentoEntity)).thenReturn(responseDto);

        AgendamentoResponseDTO response = service.consultaAgendamento(1L);

        verify(repository, times(1)).findById(1L);
        verifyNoMoreInteractions(mapper);

        Assertions.assertEquals(response, responseDto);
    }
}
