package homework300523;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String FILE_PATH = "/Users/Natalie/Desktop/BackEnd/mavenjava/src/main/java/homework300523/log.txt";
    private File file;

    public Logger() {
        try {
            file = new File(FILE_PATH);
            if (!file.exists()) {
                boolean created = file.createNewFile();
                if (!created) {
                    throw new IOException("Не удалось создать файл журнала.");
                }
            }
            FileWriter fileWriter = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Ошибка создания файла журнала: " + e.getMessage());
            System.exit(1);
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
