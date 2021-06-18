package com.hello.spring.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Users")
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private String wallpaper;
    private String summoner;
    private int teamId;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "Wallpaper")
    public String getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(String wallpaper) {
        this.wallpaper = wallpaper;
    }

    @Basic
    @Column(name = "Summoner")
    public String getSummoner() {
        return summoner;
    }

    public void setSummoner(String summoner) {
        this.summoner = summoner;
    }

    @Basic
    @Column(name = "Team_id")
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && teamId == user.teamId && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(avatar, user.avatar) && Objects.equals(wallpaper, user.wallpaper) && Objects.equals(summoner, user.summoner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, avatar, wallpaper, summoner, teamId);
    }
}
