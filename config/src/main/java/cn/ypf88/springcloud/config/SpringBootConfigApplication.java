package cn.ypf88.springcloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringBootConfigApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootConfigApplication.class);
    private static String hostName;
    private static int port;
    private static String contextPath;
    @Value("${server.address:localhost}")
    public void setHostName(String hostName) {
        SpringBootConfigApplication.hostName = hostName;
    }
    @Value("${server.port:10000}")
    public void setPort(int port) {
        SpringBootConfigApplication.port = port;
    }
    @Value("${server.servlet.context-path:/}")
    public void setContextPath(String contextPath) {
        SpringBootConfigApplication.contextPath = contextPath;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigApplication.class, args);
        LOGGER.info("服务已启动!http://{}:{}{}", hostName, port, contextPath);
    }


}
