package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class AlphaVantageResponse {

    @JsonProperty("Meta Data")
    private MetaData metaData;

    @JsonProperty("Time Series (Digital Currency Weekly)")
    private Map<String, WeeklyData> timeSeries;
}

@Data
class MetaData {

    @JsonProperty("1. Information")
    private String information;

    @JsonProperty("2. Digital Currency Code")
    private String digitalCurrencyCode;

    @JsonProperty("3. Digital Currency Name")
    private String digitalCurrencyName;
    // … 생략 (진짜 빼도 조용히 무시됨)
}

@Data
class WeeklyData {

    @JsonProperty("1. open")
    private String open;

    @JsonProperty("2. high")
    private String high;

    @JsonProperty("3. low")
    private String low;
    // … 생략 (진짜 빼도 조용히 무시됨)
}

