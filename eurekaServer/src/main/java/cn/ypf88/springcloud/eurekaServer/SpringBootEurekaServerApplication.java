package cn.ypf88.springcloud.eurekaServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;

@org.springframework.boot.autoconfigure.SpringBootApplication
@org.springframework.cloud.netflix.eureka.server.EnableEurekaServer
public class SpringBootEurekaServerApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootEurekaServerApplication.class);
    private static String hostName;
    private static int port;
    private static String contextPath;
    @Value("${server.address:localhost}")
    public void setHostName(String hostName) {
        SpringBootEurekaServerApplication.hostName = hostName;
    }
    @Value("${server.port:10000}")
    public void setPort(int port) {
        SpringBootEurekaServerApplication.port = port;
    }
    @Value("${server.servlet.context-path:/}")
    public void setContextPath(String contextPath) {
        SpringBootEurekaServerApplication.contextPath = contextPath;
    }

    public static void main( String[] args ) {
        SpringApplication.run(SpringBootEurekaServerApplication.class, args);
        LOGGER.info("eureka start success!http://{}:{}{}", hostName, port, contextPath);
    }
}
