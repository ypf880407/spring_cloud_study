package cn.ypf88.springcloud.config.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConfigClientApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootConfigClientApplication.class);
    private static String hostName;
    private static int port;
    private static String contextPath;
    @Value("${server.address:localhost}")
    public void setHostName(String hostName) {
        SpringBootConfigClientApplication.hostName = hostName;
    }
    @Value("${server.port:10000}")
    public void setPort(int port) {
        SpringBootConfigClientApplication.port = port;
    }
    @Value("${server.servlet.context-path:/}")
    public void setContextPath(String contextPath) {
        SpringBootConfigClientApplication.contextPath = contextPath;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigClientApplication.class, args);
        LOGGER.info("server start success!http://{}:{}{}", hostName, port, contextPath);
    }
}
