package notificacao_de_agendamento.infrastructure.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import notificacao_de_agendamento.infrastructure.enums.StatusNotificacaoEnum;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private String emailDestinatario;
    private String telefoneDestinatario;
    private String mensagem;
    private LocalDateTime dataHoraEnvio;
    private LocalDateTime dataHoraAgendamento;
    private LocalDateTime dataHoraModificacao;
    private StatusNotificacaoEnum statusNotificacao;

    @PrePersist
    private void prePersist(){
        dataHoraAgendamento = LocalDateTime.now();
        statusNotificacao = StatusNotificacaoEnum.AGENDADO;
    }
}
