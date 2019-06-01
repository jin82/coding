package cn.jin.k8s.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jin on 2019-05-23.
 */
@SpringBootApplication
public class LogServerApplication {


    public static void main(String[] args) {
        SpringApplication.run(LogServerApplication.class, args);
    }

    @RestController
    class LogEndpointController{

        @Autowired
        private LogRepository logRepository;

        @PostMapping("/{id}")
        public ResponseEntity<String> collect(@PathVariable String id, @RequestBody String log) {
            logRepository.save(id, log);
            return ResponseEntity.created(null).build();
        }

        @GetMapping("/")
        public ResponseEntity<List<Log>> list() {
            List<Log> list = logRepository.list(null);
            return ResponseEntity.ok(list);
        }

    }

    @RestController
    @RequestMapping("/health")
    class HealthController{

        @GetMapping({"/",""})
        public ResponseEntity<String> healte() {
            return ResponseEntity.ok("ok");
        }

    }




}
