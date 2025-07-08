package notificacao_de_agendamento.business.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id){
        super("Resource not found with Id " + id );
    }

}
