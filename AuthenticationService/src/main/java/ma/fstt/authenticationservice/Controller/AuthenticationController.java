package ma.fstt.authenticationservice.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.fstt.authenticationservice.DTO.CredentialsDto;
import ma.fstt.authenticationservice.DTO.SignUpDto;
import ma.fstt.authenticationservice.DTO.UserDto;
import ma.fstt.authenticationservice.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class AuthenticationController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {
        UserDto createdUser = userService.register(user);
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }
    @GetMapping("/messages")
    public ResponseEntity<List<String>> messages(Principal principal){
    String username = principal.getName();
    String welcomeMessage = "Welcome back, " + username;
    return ResponseEntity.ok(Collections.singletonList(welcomeMessage));
    }

}
