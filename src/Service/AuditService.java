package Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AuditService {
    private static AuditService instance;
    private static String fileName = "AuditService.csv";
    private static void initiateCsv() {

        File file = new File(fileName);
        try {
            if(!file.exists()){
                file.createNewFile();
                FileWriter myWriter = new FileWriter(file, false);
                myWriter.append("Action,Timestamps\n");
                myWriter.close();
            }
            System.out.println("Successfully initiated the csv.");
        } catch (IOException e) {
            System.out.println("An error occurred when creating the csv.");
            e.printStackTrace();
        }
    }
    public static AuditService getInstance(){
        if(instance == null){
            instance = new AuditService();
            initiateCsv();
        }
        return instance;
    }

    private String getFormattedTimestamp() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        String formattedTime = currentTime.format(formatter);
        return formattedTime;
    }
    public void write(String log){

        try {
            FileWriter myWriter = new FileWriter(fileName, true);
            String currentTimeFormatted = getFormattedTimestamp();
            String entry = log + ',' + currentTimeFormatted + '\n';
            myWriter.append(entry);
            System.out.println(entry);
            myWriter.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred when writing to csv.");
            e.printStackTrace();
        }
    }
}
