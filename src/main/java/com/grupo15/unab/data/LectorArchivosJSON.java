package com.grupo15.unab.data;


import com.grupo15.unab.validaciones.Servicios;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 */
public class LectorArchivosJSON {
    static JSONParser parser = new JSONParser();
    static Object obj;

    /**
     *
     * @param ubicacionArchivo
     */
    public static void lectorJSON(String ubicacionArchivo) {
        try {
            obj = parser.parse(new FileReader(ubicacionArchivo));
            JSONArray jsonObjectArray = (JSONArray) obj;
            Servicios.creaListaDeUsuarios(jsonObjectArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
