package cn.ypf88.springcloud.user.controllers;

import cn.ypf88.springcloud.user.beans.User;
import cn.ypf88.springcloud.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        LOGGER.info("id:[{}]", id);
        java.util.Optional<User> findUser = this.userRepository.findById(id);
        System.out.println(findUser);
        LOGGER.info("user:[{}]", findUser);
        return findUser.get();
    }
}
