package cabanas.garcia.ismael.configserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by ismaelcabanas on 6/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConfigServerApplicationTest {

    @Value("${local.server.port}")
    private int port = 0;

    @Test
    public void configurationAvailable() {
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> entity = new TestRestTemplate().getForEntity(
                "http://localhost:" + port + "/app/pepe", Map.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    public void envPostAvailable() {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> entity = new TestRestTemplate().postForEntity(
                "http://localhost:" + port + "/env", form, Map.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
}
