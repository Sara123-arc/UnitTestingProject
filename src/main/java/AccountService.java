public class AccountService {
    // Bu metod test edeceğimiz 'Submit' özelliğini temsil eder
    public boolean createAccount(String username, String email, String password, String confirmPassword) {
        if (username == null || username.isEmpty()) return false;
        if (email == null || !email.contains("@")) return false;
        if (password == null || password.length() < 8) return false;
        if (!password.equals(confirmPassword)) return false;
        return true;
    }
}
