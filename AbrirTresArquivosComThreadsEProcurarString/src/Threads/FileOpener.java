package Threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileOpener implements Runnable {
    private File file;
    private String searchString;

    public FileOpener(File file, String searchString) {
        this.file = file;
        this.searchString = searchString;
    }

    public void run() {
    	
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = null;
            int lineNumber = 1;
            int occurrences = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(searchString)) {
                    occurrences++;
                    System.out.println("File: " + file.getName() + ", Line: " + lineNumber + ", Content: " + line);
                }
                lineNumber++;
            }
            System.out.println("File: " + file.getName() + ", Total occurrences: " + occurrences);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
