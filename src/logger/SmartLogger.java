package logger;

import java.time.LocalDateTime;

public class SmartLogger implements Logger {
    int counter = 1;

    @Override
    public void log(String msg) {
//        \(E|e)rror\g
        String type;
        if (msg.toLowerCase().contains("error")) {
            type = "ERROR";
        } else {
            type = "INFO";
        }
        System.out.println(type + "#" + counter + "[" + LocalDateTime.now() + "] " + msg);
        counter++;
    }
}
