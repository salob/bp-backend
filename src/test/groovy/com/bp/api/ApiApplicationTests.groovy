package com.bp.api

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import static org.junit.jupiter.api.Assertions.assertNotNull

@SpringBootTest
class ApiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private ApiApplication apiApplication

    @Test
    void testApiApplicationBeanLoaded() {
        assertNotNull(apiApplication, "ApiApplication bean should be loaded in the context")
    }
}

