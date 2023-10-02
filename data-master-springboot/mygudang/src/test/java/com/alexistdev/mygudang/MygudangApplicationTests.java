package com.alexistdev.mygudang;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(ValidationAutoConfiguration.class)
class MygudangApplicationTests {

    @Test
    void contextLoads() {
    }

}
