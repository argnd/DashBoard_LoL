package com.hello.spring.controller;

import com.hello.spring.model.User;
import com.hello.spring.repository.UserRepository;
import com.hello.spring.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
public class ProfilController {

    SecurityService securityService;
    UserRepository userRepository;

    @Autowired
    public ProfilController(SecurityService securityService,UserRepository userRepository) {
        this.securityService = securityService;
        this.userRepository = userRepository;
    }

    @Autowired


    @GetMapping("/profile")
    public String getProfil() {
        return "layouts/profile/profile";
    }

    @GetMapping("/avatar-modify")
    public String getModifiedAvatar(){
        return "layouts/profile/avatar";
    }

    @GetMapping("/mail-modify")
    public String getModifiedMail(){
        return "layouts/profile/mail";
    }
    @GetMapping("/wallp-modify")
    public String getModifiedWallpaper(){
        return "layouts/profile/wallpaper";
    }

    @PostMapping("/mail-modify")
    public String changeMail (@RequestParam("emailForm")String email, @RequestParam("mdpForm")String password, HttpSession session){
        User user = (User)session.getAttribute("user");
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return "redirect:/profile";

    }


    @PostMapping("/avatar-modify")
    public String changeAvatar(@RequestParam("avatarForm")String avatar, HttpSession session) {
        User user = (User) session.getAttribute("user");
        user.setAvatar(avatar);
        userRepository.save(user);
        return "redirect:/profile";
    }

    //
    @PostMapping("/wallp-modify")
    public String changeWallp(@RequestParam("wallpForm")String wallp, HttpSession session) {
        User user = (User) session.getAttribute("user");
        user.setWallpaper(wallp);
        userRepository.save(user);
        return "redirect:/profile";
    }

    @GetMapping("/jwt")
    public String getJwt(Model model) {
        String key  = securityService.getKey();
        model.addAttribute("key",key);
        return "layouts/profile/jwtkey";
    }


//    @PostMapping("/upload")
//    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
//        String fileName = file.getOriginalFilename();
//
//        try {
//            file.transferTo(new File("C:\\CARS\\"+fileName));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//        return ResponseEntity.ok("Fond d'écran modifié");

//    }
}


