package notificacao_de_agendamento.business.mapper;

import notificacao_de_agendamento.business.dto.AgendamentoRequestDTO;
import notificacao_de_agendamento.business.dto.AgendamentoResponseDTO;
import notificacao_de_agendamento.infrastructure.entities.Agendamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface AgendamentoMapper {

    Agendamento paraEntity(AgendamentoRequestDTO requestDto);

    AgendamentoResponseDTO paraResponseDTO(Agendamento agendamento);

    @Mapping(target = "dataHoraModificacao", expression = "java(LocalDateTime.now())")
    @Mapping(target = "statusNotificacao", expression = "java(StatusNotificacaoEnum.CANCELADO)")
    Agendamento paraEntityCancelamento(Agendamento agendamento);
}
