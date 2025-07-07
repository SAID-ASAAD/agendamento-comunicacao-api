package notificacao_de_agendamento.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record AgendamentoRequestDTO(String emailDestinatario,
                                    String telefoneDestinatario,
                                    String mensagem,
                                    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                                    LocalDateTime dataHoraAgendamento) {
}
