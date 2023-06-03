package homework300523;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String FILE_PATH = "/Users/Natalie/Desktop/BackEnd/mavenjava/src/main/java/homework300523/log.txt";

    public Logger() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToTheLog(String str) {
        LocalDateTime time = LocalDateTime.now();
        String timeFormat = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logInput = timeFormat + " : " + str;
        Thread thread = new Thread(() -> {
            try (FileWriter fileWriter = new FileWriter(FILE_PATH, true)) {
                fileWriter.write(logInput + "\n");
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
