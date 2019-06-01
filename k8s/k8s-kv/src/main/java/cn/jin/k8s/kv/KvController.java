package cn.jin.k8s.kv;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * Created by jin on 2019-05-23.
 */
@RestController
@Slf4j
public class KvController {

    @Autowired
    private KvServer store;

    @GetMapping("/{key}")
    public ResponseEntity<String> get(@PathVariable String key) {
        String v = store.get(key);
        if (log.isInfoEnabled()) {
            log.info("GET {} -> VALUE {}", key, v);
        }
        if (v == null) {
            return ResponseEntity.notFound()
                    .build();
        }
        return ResponseEntity.ok(v);
    }

    @PostMapping("/{keyAndValue}")
    public ResponseEntity<String> save(@PathVariable String keyAndValue) {
        String[] kv = keyAndValue.split("=");
        store.put(kv[0], kv[1]);
        if (log.isInfoEnabled()) {
            log.info("PUT {} -> VALUE {}", kv[0], kv[1]);
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{key}")
                .buildAndExpand(kv[0])
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{key}")
    public String delete(@PathVariable String key) {
        store.remove(key);
        if (log.isInfoEnabled()) {
            log.info("REMOVE {}", key);
        }
        return "true";
    }

}
