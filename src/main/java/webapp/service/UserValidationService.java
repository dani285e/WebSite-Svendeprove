package webapp.service;

public class UserValidationService {

    public boolean isUserValid(String user, String password){
        if (user == null || user.isEmpty()){
            return false;
        }
        if (password == null || password.isEmpty()){
            return false;
        }
        return true;
    }
}
