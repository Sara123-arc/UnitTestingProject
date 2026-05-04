import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Hesap Yönetimi Birim Testleri (15 Senaryo)")
public class AccountTest {

    AccountService accountService = new AccountService();

    // --- EMAIL DOĞRULAMA TESTLERİ (EP & BVA) ---

    @Test
    DisplayName("Email: Geçerli format kabul edilmeli")
    void testValidEmail() {
        assertTrue(accountService.validateEmail("bunyamin@example.com"), "Geçerli email kabul edilmeli.");
    }

    @Test
    @DisplayName("Email: '@' işareti eksikse reddedilmeli")
    void testEmailWithoutAtSign() {
        assertFalse(accountService.validateEmail("bunyaminexample.com"), "At (@) işareti olmayan email reddedilmeli.");
    }

    @Test
    @DisplayName("Email: Domain kısmı boşsa reddedilmeli")
    void testEmailWithoutDomain() {
        assertFalse(accountService.validateEmail("user@"), "Domaini olmayan email reddedilmeli.");
    }

    @Test
    @DisplayName("Email: Boş bırakılırsa reddedilmeli")
    void testEmptyEmail() {
        assertFalse(accountService.validateEmail(""), "Boş email reddedilmeli.");
    }

    @Test
    @DisplayName("Email: Çok kısa (geçersiz) email reddedilmeli")
    void testVeryShortEmail() {
        assertFalse(accountService.validateEmail("a@b.c"), "Sınır değerin altındaki email reddedilmeli.");
    }

    // --- ŞİFRE GÜVENLİĞİ TESTLERİ (EP & BVA) ---

    @Test
    @DisplayName("Şifre: Güçlü şifre kabul edilmeli")
    void testValidPassword() {
        assertTrue(accountService.validatePassword("Bunyamin123"), "Geçerli şifre kabul edilmeli.");
    }

    @Test
    @DisplayName("Şifre: 6 karakterden kısa ise reddedilmeli")
    void testTooShortPassword() {
        assertFalse(accountService.validatePassword("12345"), "Çok kısa şifre reddedilmeli (BVA).");
    }

    @Test
    @DisplayName("Şifre: Hiç rakam içermiyorsa reddedilmeli")
    void testPasswordWithoutNumbers() {
        assertFalse(accountService.validatePassword("OnlyLetters"), "Rakam içermeyen şifre reddedilmeli.");
    }

    @Test
    @DisplayName("Şifre: Hiç büyük harf içermiyorsa reddedilmeli")
    void testPasswordWithoutUppercase() {
        assertFalse(accountService.validatePassword("bunyamin123"), "Büyük harf içermeyen şifre reddedilmeli.");
    }

    @Test
    @DisplayName("Şifre: Boş bırakılırsa reddedilmeli")
    void testEmptyPassword() {
        assertFalse(accountService.validatePassword(""), "Boş şifre reddedilmeli.");
    }

    // --- KULLANICI ADI VE ONAYLAMA TESTLERİ ---

    @Test
    @DisplayName("Kullanıcı Adı: Standart format kabul edilmeli")
    void testValidUsername() {
        assertTrue(accountService.validateUsername("bunyamin_2026"), "Geçerli kullanıcı adı kabul edilmeli.");
    }

    @Test
    @DisplayName("Kullanıcı Adı: Özel karakter içeriyorsa reddedilmeli")
    void testUsernameWithSpecialChars() {
        assertFalse(accountService.validateUsername("user!@#"), "Özel karakterli kullanıcı adı reddedilmeli.");
    }

    @Test
    @DisplayName("Onaylama: Şifreler birbiriyle eşleşmeli")
    void testPasswordsMatch() {
        assertTrue(accountService.confirmPasswords("Sifre123", "Sifre123"), "Şifreler uyuşmalı.");
    }

    @Test
    @DisplayName("Onaylama: Farklı şifreler hata vermeli")
    void testPasswordsDoNotMatch() {
        assertFalse(accountService.confirmPasswords("Sifre123", "Farkli456"), "Uyuşmayan şifreler hata vermeli.");
    }

    @Test
    @DisplayName("Kullanıcı Adı: Karakter sınırı aşılırsa reddedilmeli")
    void testUsernameTooLong() {
        assertFalse(accountService.validateUsername("bu_kullanici_adi_sistemi_zorlayacak_kadar_uzun"), "Çok uzun kullanıcı adı reddedilmeli.");
    }
}