package net.afrivera.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Utileria {

    public static String guardarArchivo(MultipartFile multipart, String ruta){
        // Obtenemos el nombre original del archivo
        String nombreOriginal = multipart.getOriginalFilename();
        nombreOriginal = nombreOriginal.replace(" ", "-");
        String nombreFinal = uuidString() + nombreOriginal;

        try {
            // Formamos el nombre del archivo para guardarlo en el disco duro
            File imageFile = new File(ruta + nombreFinal);
            System.out.println("Archivo: " + imageFile.getAbsolutePath());
            // guardamos fisicamente el archivo en el HD.
            multipart.transferTo(imageFile);
            return nombreFinal;
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }


    }

    // metodo para generar una cadena aleatoria
    public static String uuidString(){
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        return uuidAsString;
    }
}
