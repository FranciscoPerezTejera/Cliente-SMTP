package company.pruebapractica_02.utils;


public class Utiles {
    
    public boolean isPassCorrect(String pass) {
        return pass.length() < 16;
    }
    
    public boolean isEmailCorrect(String email) {
        return email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }
}
