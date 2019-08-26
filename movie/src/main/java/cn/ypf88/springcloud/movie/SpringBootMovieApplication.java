package cn.ypf88.springcloud.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@org.springframework.boot.autoconfigure.SpringBootApplication
@org.springframework.cloud.client.discovery.EnableDiscoveryClient
public class SpringBootMovieApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootMovieApplication.class);
    private static String hostName;
    private static int port;
    private static String contextPath;
    @Value("${server.address:localhost}")
    public void setHostName(String hostName) {
        SpringBootMovieApplication.hostName = hostName;
    }
    @Value("${server.port:10000}")
    public void setPort(int port) {
        SpringBootMovieApplication.port = port;
    }
    @Value("${server.servlet.context-path:/}")
    public void setContextPath(String contextPath) {
        SpringBootMovieApplication.contextPath = contextPath;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main( String[] args ) {
        org.springframework.boot.SpringApplication.run(SpringBootMovieApplication.class, args);
        LOGGER.info("server start success!http://{}:{}{}", hostName, port, contextPath);
    }

}
