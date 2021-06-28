package com.hello.spring.pojo.championdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionData {

    private String id;
    private String name;
    private String title;
    private String blurb;
    ChampionInfo info;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public ChampionInfo getInfo() {
        return info;
    }

    public void setInfo(ChampionInfo info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return  "{id:'" + id + '\'' +
                ", name:'" + name + '\'' +
                ", title:'" + title + '\'' +
                ", blurb:'" + blurb + '\'' +", "+
                info;
    }
}
