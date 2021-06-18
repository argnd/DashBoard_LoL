package com.hello.spring.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "teams", schema = "dashboard")
public class Team {
    private Integer id;
    private User user;
    private List<Hero> heroes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne(mappedBy = "team")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "hero_team",
            joinColumns = @JoinColumn(name = "Team_id"),
            inverseJoinColumns = @JoinColumn(name = "Hero_id"))
    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

}
