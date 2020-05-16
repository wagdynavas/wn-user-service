package wagdynavas.com.wnuserservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import wagdynavas.com.wnuserservice.entities.User;
import wagdynavas.com.wnuserservice.exceptions.UserAlreadyExistsException;
import wagdynavas.com.wnuserservice.repositories.UserRepositoty;
import wagdynavas.com.wnuserservice.services.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepositoty userRepositoty;

    @GetMapping("/{userId}")
    public ResponseEntity<User> user(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody User user, @PathVariable String playerRegion, UriComponentsBuilder uriComponentsBuilder) {
        ResponseEntity<User> userResponseEntity = userService.getUserByEmail(user.getEmail());

        if (userResponseEntity.getStatusCode().equals(HttpStatus.OK)) {
            throw new UserAlreadyExistsException("User Already exist!");
        }
        userService.createUser(user, playerRegion);


        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/v1/users/{email}").buildAndExpand(user.getEmail()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}
