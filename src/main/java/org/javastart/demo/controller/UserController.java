package org.javastart.demo.controller;

import org.javastart.demo.model.Address;
import org.javastart.demo.model.EmailAddress;
import org.javastart.demo.model.Project;
import org.javastart.demo.model.User;
import org.javastart.demo.service.AddressService;
import org.javastart.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


        // mamy to many
        Project javaStart = new Project("JavaStart");
        Project springStart = new Project("SpringStart");

        //

        User user = new User("Jan", "Kowalski", address);
//        address.setUser(user);
        EmailAddress gmail = new EmailAddress("jan@gmail.com");
        EmailAddress wp = new EmailAddress("jan.kowalski@wp.pl");
        // to bez metody w used addEmailAddress
//        user.getEmailAddresses().add(gmail);
//        user.getEmailAddresses().add(wp);
//        gmail.setUser(user);
//        wp.setUser(user);
        user.addEmailAddress(gmail);
        user.addEmailAddress(wp);

        user.addProject(javaStart);
        user.addProject(springStart);

        userService.saveUser(user);
//        addressService.saveAddress(address);


        Address address2 = new Address("Wrocław", "Długa", "123", "666");
        User user2 = new User("Marcin", "Kowalski", address2);

        user2.addProject(javaStart);
        user2.addProject(springStart);
        userService.saveUser(user2);



        return "Success";
    }

    @GetMapping("/getAddress")
    @ResponseBody
    public String findAddress(@RequestParam Long addressId) {
        Address result = addressService.findOne(addressId);
        return result.toString();
    }


    @GetMapping("/getUser")
    @ResponseBody
    public String findUser(@RequestParam Long userId) {
        User result = userService.findOne(userId);
        return result.toString();
    }

}
