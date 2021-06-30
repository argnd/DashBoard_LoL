package com.hello.spring.service;


import com.hello.spring.model.Team;
import com.hello.spring.model.User;
import com.hello.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FightService {

    UserRepository userRepository;

    @Autowired
    public FightService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User[] pickThreeUser(){
        User[] pickedUser = new User[3];
        pickedUser[0]= userRepository.getById(2);
        pickedUser[1]= userRepository.getById(3);
        pickedUser[2]= userRepository.getById(4);
        return pickedUser;
    }

    public User getUserById(int id){
        return userRepository.getById(id);
    }

    public boolean compareUserCharm(User currentUser, User opponent){
        int curr = sumOfCharm(currentUser.getTeam());
        int opp = sumOfCharm(opponent.getTeam());

        return curr>=opp;
    }

    public int sumOfCharm(Team t){
        int sum = 0;
        for (int i = 0; i < t.getHeroes().size(); i++) {
            sum += t.getHeroes().get(i).getCharm();
        }
        return sum;
    }

}
