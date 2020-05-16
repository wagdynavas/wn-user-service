package wagdynavas.com.wnuserservice.services;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import wagdynavas.com.wnuserservice.entities.Summoner;
import wagdynavas.com.wnuserservice.entities.User;
import wagdynavas.com.wnuserservice.exceptions.PlayerGameAccountNotFoundException;
import wagdynavas.com.wnuserservice.repositories.UserRepositoty;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepositoty userRepositoty;

    @Qualifier("getWebBuilder")
    @Autowired
    private WebClient.Builder webBuilder;

    @Value("${riotgames.api.base-url}")
    private String gameApi;

    @Value("$(riotgames.api.key)")
    private String apiKey;

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

    public void createUser(User user, String PlayerRegion) {


        Summoner summoner = webBuilder.build()
             .get()
             .uri(gameApi + user.getGameAccount())
             .header(PlayerRegion, apiKey)
             .retrieve()
             .bodyToMono(Summoner.class)
             .block();

        if (StringUtils.isEmpty(summoner.getName())) {
            throw new PlayerGameAccountNotFoundException("PLayer name was not found!");
        }
    }
}
