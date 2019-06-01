package cn.jin.k8s.log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.Date;

/**
 * Created by jin on 2019-05-23.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Log {
    private String id;
    private String content;
    private Date time;

    public String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Log toObject(String json) {
        try {
            return new ObjectMapper().readValue(json, Log.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
