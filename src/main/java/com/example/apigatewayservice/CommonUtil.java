package com.example.apigatewayservice;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CommonUtil {

    public static String getCurrentTime() {
        // 현재 시간 가져오기
        String formattedTime = "";
        LocalDateTime currentTime = LocalDateTime.now();

        // 시간 형식 지정 (예: yyyy-MM-dd HH:mm:ss)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 형식에 맞춰 시간 출력
        formattedTime = currentTime.format(formatter);
        System.out.println("현재 시간: " + formattedTime);

        return formattedTime;
    }
}

