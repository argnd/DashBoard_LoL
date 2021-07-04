package com.hello.spring.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    private Integer id;
    private String avatar;
    private String email;
    private String password;
    private String summoner;
    private Team team;
    private String username;
    private String wallpaper;
    private boolean active;
    private String roles;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usergen")
    @SequenceGenerator(
            name = "usergen",
            allocationSize = 1
    )
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic @Column(name = "avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic @Column(name = "summoner")
    public String getSummoner() {
        return summoner;
    }

    public void setSummoner(String summoner) {
        this.summoner = summoner;
    }

    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id",referencedColumnName = "id")
    @JsonManagedReference
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Basic @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic @Column(name = "wallpaper")
    public String getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(String wallpaper) {
        this.wallpaper = wallpaper;
    }

    public boolean isActive() {
        return active;
    }

    @Basic @Column(name = "active")
    public void setActive(boolean active) {
        this.active = active;
    }

    @Basic @Column(name = "roles")
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
