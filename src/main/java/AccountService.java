import java.util.regex.Pattern;

public class AccountService {

    // Email doğrulama mantığı
    public boolean validateEmail(String email) {
        if (email == null || email.length() < 6) {
            return false;
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    // Şifre doğrulama mantığı
    public boolean validatePassword(String password) {
        if (password == null || password.length() < 6) {
            return false;
        }
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasDigit = password.matches(".*\\d.*");

        return hasUppercase && hasDigit;
    }

    // Kullanıcı adı doğrulama mantığı
    public boolean validateUsername(String username) {
        if (username == null || username.isEmpty() || username.length() > 20) {
            return false;
        }
        return username.matches("^[a-zA-Z0-9_]*$");
    }

    // Şifre onaylama mantığı
    public boolean confirmPasswords(String pass1, String pass2) {
        if (pass1 == null || pass2 == null) {
            return false;
        }
        return pass1.equals(pass2);
    }
}
