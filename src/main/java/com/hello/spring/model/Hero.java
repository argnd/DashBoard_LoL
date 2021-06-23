package com.hello.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "heroes", schema = "dashboard")
public class Hero {
    private Integer id;
    private String name;
    private String picture;
    private Integer charm;
    private Integer tbd;
    private List<Team> teams;


    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "herogen")
    @SequenceGenerator(
            name = "herogen",
            allocationSize = 1
    )
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic @Column(name = "Picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Basic @Column(name = "Charm")
    public Integer getCharm() {
        return charm;
    }

    public void setCharm(Integer charm) {
        this.charm = charm;
    }

    @Basic @Column(name = "TBD")
    public Integer getTbd() {
        return tbd;
    }

    public void setTbd(Integer tbd) {
        this.tbd = tbd;
    }

    @ManyToMany(mappedBy = "heroes")
    @JsonIgnore
    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", charm=" + charm +
                ", tbd=" + tbd +
                ", teams=" + teams +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Objects.equals(id, hero.id) && Objects.equals(name, hero.name) && Objects.equals(picture, hero.picture) && Objects.equals(charm, hero.charm) && Objects.equals(tbd, hero.tbd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, picture, charm, tbd);
    }

}
