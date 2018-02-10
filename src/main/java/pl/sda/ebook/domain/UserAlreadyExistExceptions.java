package pl.sda.ebook.domain;

public class UserAlreadyExistExceptions extends RuntimeException{

    public UserAlreadyExistExceptions(User user) {
        super("User " + user.getLogin() + " already exist.");
    }
}
