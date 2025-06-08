package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AlphaVantageService {

    private final WebClient webClient;

    public AlphaVantageService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://www.alphavantage.co").build();
    }

    public String getWeeklyData() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/query")
                        .queryParam("function", "DIGITAL_CURRENCY_WEEKLY")
                        .queryParam("symbol", "BTC")
                        .queryParam("market", "EUR")
                        .queryParam("apikey", "TACR9KG637NPIRIX")
                        .build())
                .retrieve()
                .bodyToMono(String.class)  // .bodyToMono(AlphaVantageResponse.class)
                .block(); // Blocking call for simplicity
    }
}
