package notificacao_de_agendamento.business.mapper;

import notificacao_de_agendamento.business.dto.AgendamentoRequestDTO;
import notificacao_de_agendamento.business.dto.AgendamentoResponseDTO;
import notificacao_de_agendamento.infrastructure.entities.Agendamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgendamentoMapper {

    Agendamento paraEntity(AgendamentoRequestDTO requestDto);

    AgendamentoResponseDTO paraResponseDTO(Agendamento agendamento);
}
