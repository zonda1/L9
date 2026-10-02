package logger;

import java.time.LocalDateTime;

public class SmartLogger implements Logger {
    int counter = 1;
    String type = "INFO";

    @Override
    public void log(String msg) {
//        \(E|e)rror\g
        if (msg.contains("error") || msg.contains("Error")) {
            type = "ERROR";
        }
        System.out.println(type + "#" + counter + "[" + LocalDateTime.now() + "] " + msg);
        type = "INFO";
        counter++;
    }
}
