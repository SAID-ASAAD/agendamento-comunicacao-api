package notificacao_de_agendamento.infrastructure.repositories;

import notificacao_de_agendamento.infrastructure.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
