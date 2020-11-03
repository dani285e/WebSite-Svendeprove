package webapp.service;

public class UserValidationService {

    public boolean isUserValid(String user, String password){
        String userName = "name";
        String userPassword = "password";
        if (user.equals(userName) && password.equals(userPassword)){
            return true;
        } else {
            return false;
        }
    }
}
