import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
class UsuarioProxyTest {
    @BeforeEach
    void setUp() {
        BD.addUsuario(new Usuario("Pedro", "Belo Horizonte", "12345678", "pedro@example.com", "111-111-111-11"));
        BD.addUsuario(new Usuario("Ana", "São Paulo", "87654321", "ana@example.com", "999-99-999-99"));
    }
    @Test
    void deveRetornarDadosPessoaisDoUsuario() {
        UsuarioProxy usuario = new UsuarioProxy("111-111-111-11");
        assertEquals(Arrays.asList("Pedro", "Belo Horizonte", "111-111-111-11"), usuario.obterDadosPessoais());
    }
    @Test
    void deveRetonarContatoDoUsuario() {
        Administrador admin = new Administrador("admin@example.com", true);
        UsuarioProxy usuario = new UsuarioProxy("999-99-999-99");
        assertEquals(Arrays.asList("87654321", "ana@example.com"), usuario.obterContatos(admin));
    }
    @Test
    void deveRetonarExcecaoAdministradorSemValidaccao() {
        try {
            Administrador admin = new Administrador("admin@example.com", false);
            UsuarioProxy usuario = new UsuarioProxy("111-111-111-11");

            usuario.obterContatos(admin);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Não foi feito login.", e.getMessage());
        }
    }
}