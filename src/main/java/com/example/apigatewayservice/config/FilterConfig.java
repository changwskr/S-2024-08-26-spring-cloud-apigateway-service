package com.example.apigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
 * configuration, bean은 application.yml 파일을 대처하니 필요시 다시 설정한다.
 */
//@Configuration
public class FilterConfig {
//    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
    	
    	System.out.println("★★★★★★FilterConfig.gatewayRoutes()-호출★★★★★★★");
    	/*
    	 *  이 동작들은 application.yml 파일에서 했던 동작들을 기술한것이다.
    	 */
        return builder.routes()
        		// 이런 서비스가 들어오면 이렇게 처리하겠다.
        				// 패스설정은 다음과 같다.
                .route(r -> r.path("/first-service/**")
                						// 리퀘스트 헤더에 다음의 정보를 넣어 주겠다.
                            .filters(f -> f.addRequestHeader("first-request", "first-request-header")
                            									// 리스폰스 헤더에 다음의 정보를 넣어 주겠다.
                                                  .addResponseHeader("first-response", "first-response-header"))
                            	// 다음의 uri로 넘기겠다.
                            .uri("http://localhost:8081"))
                .route(r -> r.path("/second-service/**")
                        .filters(f -> f.addRequestHeader("second-request", "second-request-header")
                                              .addResponseHeader("second-response", "second-response-header"))
                        .uri("http://localhost:8082"))
                .route(r -> r.path("/third-service/**")
                        .filters(f -> f.addRequestHeader("third-request", "third-request-header")
                                              .addResponseHeader("third-response", "third-response-header"))
                        .uri("http://localhost:8083"))                
                .build();
    }
}
