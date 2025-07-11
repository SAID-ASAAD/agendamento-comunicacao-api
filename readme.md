
# Notification Scheduler

This project was developed based on a challenge from the technical testing stage of a selection process for hiring backend developers at Magalu. Simulating the first sprint of a communication API's development, its scope is limited to developing the endpoints to register the scheduling of a notification, query the registered notifications, and cancel them.

This project is under development, in the phase of implementing unit tests. Once I finish, I will add it to this document along with the deploy and running settings by Docker.
I apoloize for the waver between english and portuguese present on the code and the commits, I will correct that as soon as I can.

## Documentação da API

#### Retorna todos os itens

```http
  POST / agendamento
```

| Body   | Type       | Description                                   |
| :---------- | :--------- | :------------------------------------------ |
| emailDestinatario | String | notification recipient's email |
| telefoneDestinatario | String | notification recipient's telephone number |
| dataHoraEnvio | LocalDateTime | date and time of sending the notification in the format: dd-MM-yyyy HH:mm:ss |
| mensagem | String | The notification content |



#### Query a notification by id

```http
  GET / notificação/${id}
```

| Parameter   | Type       | Description                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Mandatory**. The ID of the item you want to get |


#### Cancel a notification by id

```http
  DELETE / notificação/${id}
```

| Parameter   | Type       | Description                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Mandatory**. The ID of the item you want to cancel |

