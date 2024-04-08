package com.github.yuliyaks.services;

import com.github.yuliyaks.domain.User;
import com.github.yuliyaks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {


    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    public void processRegistration(User user){
         userRepository.addUser(user);
         notificationService.notifyUser(user);
    }

}
