package cn.jin.k8s.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

/**
 * Created by jin on 2019-05-20.
 */
@SpringBootApplication
public class K8sRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(K8sRestApplication.class, args);
    }

    @RestController
    class EchoController{

        @Value("${app.content}")
        private String content;

        @GetMapping("/")
        public String index() throws Exception{
            InetAddress localHost = InetAddress.getLocalHost();
            return "你正在访问的是V4：" + localHost.getHostName() + " : " + localHost.getHostAddress() + "\n" + content + "\n";
        }

    }
}
