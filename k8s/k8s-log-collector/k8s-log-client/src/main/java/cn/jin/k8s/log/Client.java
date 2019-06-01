package cn.jin.k8s.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by jin on 2019-05-23.
 */
public class Client {

    public static URL url;

    public static void main(String[] args) throws Exception{
        String logPath = System.getenv("LOG_PATH");
        if (logPath == null) {
            logPath = "/application/log";
        }
        String logFile = System.getenv("LOG_FILE");
        if (logFile == null) {
            logFile = "spring.log";
        }

        String logServerUrl = System.getenv("LOG_SERVER_URL");
        if (logServerUrl == null) {
            logServerUrl = "http://svc-log-server/" + InetAddress.getLocalHost().getHostAddress();
        }
        String path = logPath + "/" + logFile;
        url = new URL(logServerUrl);

        try(
            FileReader reader = new FileReader(new File(path));
            BufferedReader bufferedReader = new BufferedReader(reader);
                ) {
            String context;
            while (true){
                context = bufferedReader.readLine();
                if (context != null) {
                    System.out.println("log : " + context);
                    doPost(context);
                } else {
                    Thread.sleep(500);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void doPost(String content) {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();
            OutputStream outputStream = connection.getOutputStream();
            outputStream
                    .write(content.getBytes(Charset.forName("UTF-8")));
            outputStream.flush();
            int responseCode = connection.getResponseCode();
            System.out.println("responseCode: " + responseCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
