package com.hello.spring.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

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

    @OneToOne(cascade=CascadeType.PERSIST)
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", summoner='" + summoner + '\'' +
                ", team=" + team +
                ", username='" + username + '\'' +
                ", wallpaper='" + wallpaper + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(avatar, user.avatar) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(summoner, user.summoner) && Objects.equals(team, user.team) && Objects.equals(username, user.username) && Objects.equals(wallpaper, user.wallpaper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, avatar, email, password, summoner, team, username, wallpaper);
    }
}
