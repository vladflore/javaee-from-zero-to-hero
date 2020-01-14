import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.assertj.core.api.Assertions.assertThat;

public class PersistenceTest {

    @Test
    @Disabled
    void test() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default-pu");
        EntityManager em = emf.createEntityManager();
        assertThat(em).isNotNull();
    }
}
