package ru.zinin.conf;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@PropertySource("classpath:except.properties")
@ConfigurationProperties(prefix = "mail")
@Data
public class AppProperties {


    /*@Data
    public static class Credentials {
        private String authMethod;
        private String username;
        private String password;



        // standard getters and setters
    }
    private String host;
    private int port;
    private String from;
    private Credentials credentials;
    private List<String> defaultRecipients;
    private Map<String, String> additionalHeaders;*/

    Map<String, String> map = new HashMap<>();

}
