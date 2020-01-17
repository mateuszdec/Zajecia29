package org.javastart.demo.controller;

import org.javastart.demo.model.Address;
import org.javastart.demo.model.User;
import org.javastart.demo.service.AddressService;
import org.javastart.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private UserService userService;
    private AddressService addressService;

    @Autowired
    public UserController(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    @GetMapping("/saveUser")
    @ResponseBody
    public String saveUser() {
        Address address = new Address("Wrocław", "Piękna", "182", "1");
        addressService.saveAddress(address);

        User user = new User("Jan", "Kowalski", address);
        userService.saveUser(user);

        return "Success";
    }
}
