package ma.fstt.authenticationservice.DTO;

public record SignUpDto(String firstName, String lastName, String login, String email, char[] password, String role) { }
