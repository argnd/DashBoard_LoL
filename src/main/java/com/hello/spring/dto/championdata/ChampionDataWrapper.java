package com.hello.spring.dto.championdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionDataWrapper {

    Map<String, ChampionData> data;

    public Map<String, ChampionData> getData() {
        return data;
    }

    public void setData(Map<String, ChampionData> data) {
        this.data = data;
    }

}
