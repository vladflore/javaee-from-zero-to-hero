import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.assertj.core.api.Assertions.assertThat;

public class PersistenceTest {

    @Test
    @DisplayName("test if entity manager is available")
    @Disabled
    void testEntityManagerAvailable() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        assertThat(entityManager).isNotNull();
    }

}
