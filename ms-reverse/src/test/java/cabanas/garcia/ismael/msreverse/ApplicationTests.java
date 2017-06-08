package cabanas.garcia.ismael.msreverse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ismaelcabanas on 8/6/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(ApplicationTests.class);

    @Test
    public void contextLoads() {

    }
}
