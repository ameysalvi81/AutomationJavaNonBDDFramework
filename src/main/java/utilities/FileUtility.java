package utilities;

import java.io.File;

public class FileUtility {

    public static String getProjectRoot() {
        return System.getProperty("user.dir");
    }

    public static void createFolderIfNotExists(String folderPath) {

        File folder = new File(folderPath);

        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    public static String generateTimestamp() {
        return String.valueOf(System.currentTimeMillis());
    }
}