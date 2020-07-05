package com.example.devops.config.properties;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:customproperties.properties")
public class CustomPropertiesIntegreationTest {

    private static final String HTTP_LOCALHOST = "http://localhost";
    private static final int TIME_OUT_MILLISECONDS = 2000;

    @Autowired
    private CustomProperties customProperties;

    /**
     * Validates that the file properties contains valid settings.
     */
    @Test
    public void whenUrlPropertyQueriedThenReturnsPropertyValue() {
        assertThat(customProperties).isNotNull();
        assertThat(customProperties.getUrl()).isEqualTo(HTTP_LOCALHOST);
        assertThat(customProperties.getTimeoutInMilliSeconds()).isEqualTo(TIME_OUT_MILLISECONDS);
    }
}