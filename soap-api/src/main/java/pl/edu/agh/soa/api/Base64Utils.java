package pl.edu.agh.soa.api;

import java.io.*;
import java.util.Base64;

public class Base64Utils {

    public static String encoder(String path) {
        String base64Image = "";
        File file = new File(path);
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] imageData = new byte[(int) file.length()];
            fis.read(imageData);
            base64Image = Base64.getEncoder().encodeToString(imageData);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64Image;
    }

    public static void decoder(String base64Image, String path) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
            fos.write(imageByteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
