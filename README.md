# Simple Kafka Producer and Consumer:

## Configuration:
All configs such as kafka brokers, group id can be configured in [application.properties](src/main/resources/application.properties)

## Kafka Message Sender API

This API allows users to send a specified number of messages to a Kafka topic.

## **Endpoint**

### `/send`

## **HTTP Method**

`GET`

---

## **Request Parameters**

| Parameter Name | Type   | Required | Description                                    |
|----------------|--------|----------|------------------------------------------------|
| `topic`        | String | Yes      | The name of the Kafka topic to send messages to. |
| `count`        | int    | Yes      | The number of messages to send to the specified topic. |

---

## **Example Usage**
GET {server_ip}/send?topic=myTopic&count=5

## **Response**

- **Status Code**: `200 OK`
- **Body**: A success message in the format:
