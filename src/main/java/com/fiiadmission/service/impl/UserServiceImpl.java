package com.fiiadmission.service.impl;

import utils.AdmissionStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiiadmission.domain.User;
import com.fiiadmission.repository.UserRepository;
import com.fiiadmission.service.UserService;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }

	@Override
	public List<User> findAllUsersWithStatus(String status) {
		return (List<User>)userRepository.findByAdmissionStatus(status);
	}

	@Override
	public List<User> findByName(Optional<String> firstname, Optional<String> lastname) {
		String firstName = firstname.isPresent()? firstname.get():null;
		String lastName = lastname.isPresent()? lastname.get():null;
		if(firstName!=null&&lastName!=null)
		return userRepository.findByFirstNameAndLastName(firstName, lastName);
		else if(firstName!=null)
			return userRepository.findByFirstName(firstName);
		else if(lastName!=null)
			return userRepository.findByLastName(lastName);
		return null;
	}

	@Override
	public User findOne(User user) {
		return userRepository.findOne(user.getId());
	}

	@Override
	public User save(User searchedUser) {
		return userRepository.save(searchedUser);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id);
	}

}
