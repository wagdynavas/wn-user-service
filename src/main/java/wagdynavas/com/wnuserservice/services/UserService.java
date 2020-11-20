package wagdynavas.com.wnuserservice.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import wagdynavas.com.wnuserservice.entities.User;
import wagdynavas.com.wnuserservice.repositories.UserRepositoty;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepositoty userRepositoty;

    @Qualifier("getWebBuilder")
    private  final WebClient.Builder webBuilder;

    private final BCryptPasswordEncoder passwordEncoder;

    public ResponseEntity<User> getUserById(Long userId) {
        Optional<User> optionalUser = userRepositoty.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<User> getUserByEmail(String email) {
        Optional<User> optionalUser = userRepositoty.findByEmail(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepositoty.save(user);
    }
}
