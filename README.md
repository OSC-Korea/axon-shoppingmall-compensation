# Axon Framework 예제

## 0. 개요
이 예제는 쇼핑몰 예제로 CQRS와 SAGA Pattern을 이용해 보상 트랜잭션을 발행하는 예제입니다.

기능은 아래 4가지 기능이 있습니다.

1. product을 등록하고 
2. 해당 product을 주문 하고
3. 주문을 하면 product에서 개수를 차감 하고
4. 개수가 부족하면 주문 상태를 CANCELED로 바꾸는 기능

## 1. Axon Server실행

이 프로젝트를 실행 하려면 Axon Server를 먼저 실행 해야 합니다.

아래와 같이 Docker를 이용해 실행 할 수 있습니다.
```
$ docker run -d --name my-axon-server -p 8024:8024 -p 8124:8124 axoniq/axonserver
```

Docker없이 .jar을 다운받아서 바로 실행 할 수 있습니다.

https://download.axoniq.io/axonserver/AxonServer.zip

```
$ java -jar axonserver.jar
```


## 2. API
1. GET /product - 등록한 제품(product)을 조회합니다.

2. GET /order - 등록한 주문을 조회 합니다.

3. POST /product - 제품(product) 등록합니다.

RequestBody
```json
{
    "productId":"bedcceac-8587-430c-921c-637d0b151ca2", "quantity":30
}
```

4. POST /order - 주문을 등록 합니다.
 
RequestBody
```json
{
    "name":"버티컬 마우스",
    "quantity":30,
    "price":10000
}
```

## 실행 방법

1. Axon Server실행
2. Application실행
