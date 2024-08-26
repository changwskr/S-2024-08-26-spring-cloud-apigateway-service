echo "컨테이너를 특정포터로 open"
echo "my-discoveryservice 이 명칭은 컨테이너이름을 말한다. 컨테이너 내부적으로 이 컨테이너 명칭으로 호출이 가능하다. 즉 ip 대용이다. 하지만 ip는 계속 변경되지만 컨테이너명으로 그대로 유지된다."

docker run -d -p 8000:8000 --network ecommerce-network ^
           -e "spring.cloud.config.uri=http://config-service:8888" ^
           -e "spring.rabbitmq.host=rabbitmq" ^
           -e "eureka.client.serviceUrl.defaultZone=http://discovery-service:8761/eureka/" ^
           --name apigateway-service ^
           changwskr/apigateway-service:1.0
