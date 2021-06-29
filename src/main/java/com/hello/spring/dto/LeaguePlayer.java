package com.hello.spring.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaguePlayer {

    private String id;
    private String accountId;
    private String puuid;
    private String name;
    private double profileIconId;
    private double revisionDate;
    private double summonerLevel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(double profileIconId) {
        this.profileIconId = profileIconId;
    }

    public double getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(double revisionDate) {
        this.revisionDate = revisionDate;
    }

    public double getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(double summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    @Override
    public String toString() {
        return "LeaguePlayer{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                ", puuid='" + puuid + '\'' +
                ", name='" + name + '\'' +
                ", profileIconId=" + profileIconId +
                ", revisionDate=" + revisionDate +
                ", summonerLevel=" + summonerLevel +
                '}';
    }

}
