package StartAtGoogle.week4.springBoot.service;


import StartAtGoogle.week4.springBoot.Entity.User;
import StartAtGoogle.week4.springBoot.repository.UserRepository;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.*;

public class AuthenticationService {

    private static volatile AuthenticationService authService;
    private UserRepository userRepo;
    Map<String, User> userTokens;

    private AuthenticationService() {
        this.userTokens = new HashMap<>();
        userRepo = UserRepository.getInstance();
    }

    public static AuthenticationService getInstance() {

        AuthenticationService result = authService;

        if (result == null) {
            synchronized (AuthenticationService.class) {
                result = authService;
                if (result == null) {
                    authService = result = new AuthenticationService();
                }
            }
        }
        return result;
    }

    public void register(String email, String name, String password) {

        if (!checkIfUserExists(email)) {
            User user = new User(UUID.randomUUID().hashCode(), email, name, password);
            try {
                userRepo.writeToFile(user.getEmail() + ".json", user);
            } catch (IOException e) {
                System.out.println("Couldn't write to file");
                throw new RuntimeException(e);
            }
        }
    }

    public User validate(String token) {
        if (!userTokens.containsKey(token)) {
            throw new InvalidParameterException("Token incorrect");
        }
        return userTokens.get(token);
    }


    public String login(String email, String password) {
        User cachedUser = userRepo.readFromCache(email);
        if (cachedUser == null) {
            throw new IllegalArgumentException("user doesn\"t exist");
        } else if (!Objects.equals(cachedUser.getPassword(), password)) {
            throw new IllegalArgumentException("wrong password");
        }
        return createToken(cachedUser);
    }

    private String createToken(User user) {
        String token = UUID.randomUUID().toString();
        userTokens.put(token, user);
        return token;
    }

    public void reloadUser(String email, String token) {
        User updatedUser = userRepo.readFromCache(email);
        userTokens.put(token, updatedUser);
    }

    public void removeToken(String token) {
        userTokens.remove(token);
    }


    private static boolean checkIfUserExists(String email) {
        try (FileReader fr = new FileReader(email + ".json")) {
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}