package serviceregistry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import serviceregistry.ServiceRegistryApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceRegistryApplicationTest {
    @Test
    public void contextLoads() {
        ServiceRegistryApplication.main(new String[]{});
    }
}
