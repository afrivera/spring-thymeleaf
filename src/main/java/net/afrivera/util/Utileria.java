package net.afrivera.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class Utileria {

    public static String guardarArchivo(MultipartFile multipart, String ruta){
        // Obtenemos el nombre original del archivo
        String nombreOriginal = multipart.getOriginalFilename();
        try {
            // Formamos el nombre del archivo para guardarlo en el disco duro
            File imageFile = new File(ruta + nombreOriginal);
            System.out.println("Archivo: " + imageFile.getAbsolutePath());
            // guardamos fisicamente el archivo en el HD.
            multipart.transferTo(imageFile);
            return nombreOriginal;
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
