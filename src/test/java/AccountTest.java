import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    AccountService service;

    @BeforeEach // SETUP: Her testten önce çalışır
    void setUp() {
        service = new AccountService();
    }

    @AfterEach // TEARDOWN: Her testten sonra çalışır
    void tearDown() {
        service = null;
    }

    @Test
    @DisplayName("TC-01: Valid Registration")
    void tc01() {
        assertTrue(service.createAccount("bunyamin", "test@mail.com", "pass12345", "pass12345"));
    }

    @Test
    @DisplayName("TC-02: Invalid Email (EP)")
    void tc02() {
        assertFalse(service.createAccount("user", "invalid-email", "pass12345", "pass12345"));
    }

    @Test
    @DisplayName("TC-07: Password Boundary (7 chars - BVA)")
    void tc07() {
        assertFalse(service.createAccount("user", "a@b.com", "1234567", "1234567"));
    }

    // Diğer 12 testi de benzer şekilde altına ekleyebilirsin.
}