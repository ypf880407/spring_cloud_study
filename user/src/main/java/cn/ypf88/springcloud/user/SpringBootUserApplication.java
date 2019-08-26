package cn.ypf88.springcloud.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

@org.springframework.boot.autoconfigure.SpringBootApplication
@org.springframework.cloud.client.discovery.EnableDiscoveryClient
public class SpringBootUserApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootUserApplication.class);
    private static String hostName;
    private static int port;
    private static String contextPath;
    @Value("${server.address:localhost}")
    public void setHostName(String hostName) {
        SpringBootUserApplication.hostName = hostName;
    }
    @Value("${server.port:10000}")
    public void setPort(int port) {
        SpringBootUserApplication.port = port;
    }
    @Value("${server.servlet.context-path:/}")
    public void setContextPath(String contextPath) {
        SpringBootUserApplication.contextPath = contextPath;
    }

    public static void main( String[] args) {
        org.springframework.boot.SpringApplication.run(SpringBootUserApplication.class, args);
        LOGGER.info("server start success!http://{}:{}{}", hostName, port, contextPath);
    }

}
