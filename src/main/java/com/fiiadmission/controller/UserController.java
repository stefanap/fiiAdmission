package com.fiiadmission.controller;

import utils.AdmissionStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fiiadmission.domain.User;
import com.fiiadmission.service.UserService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/fii")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    //@RequestMapping(value ="/update")
    //@PutMapping
    //@PreAuthorize("hasAuthority('ADMIN_USER'))")// or hasAuthority('STANDARD_USER')")
    //public /*@ResponseBody*/ User updateUser(/*@RequestBody*/ User user){
        //User searchedUser = null;//userService.findOne(user);
        //return null;//userService.save(searchedUser);
    //}
    
    @RequestMapping("/create")
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public @ResponseBody User response(@RequestBody User user) {
        return userService.save(user);
    }
    
    @RequestMapping("/update/{id}")
    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public @ResponseBody User response(@RequestBody User user,@PathVariable("id") Long id) {
    	User searchedUser = userService.findById(id);
    	searchedUser.setEmail(user.getEmail());
    	searchedUser.setPassword(user.getPassword());
    	searchedUser.setRoles(user.getRoles());
    	searchedUser.setAdmissionStatus(user.getAdmissionStatus());
        return userService.save(searchedUser);
    }
    
    @RequestMapping(value ="/users/{status}")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<User> getConfirmedUsers( @PathVariable("status") String status){
        return userService.findAllUsersWithStatus(status.toUpperCase());
    }

    @RequestMapping(value ="/search", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<User> getUsers(@RequestParam(value = "firstname") Optional<String> firstName,
            @RequestParam("lastname") Optional<String> lastName){
        return userService.findByName(firstName, lastName);
    }

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<User> getUsers(){
        return userService.findAllUsers();
    }
    
}
