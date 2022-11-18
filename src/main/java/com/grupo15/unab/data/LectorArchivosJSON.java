package com.grupo15.unab.data;


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
     * @param ubicacionArchivo
     */
    public static JSONArray lectorJSON(String ubicacionArchivo) {
        try {
            obj = parser.parse(new FileReader(ubicacionArchivo));
            if (obj != null) {
                JSONArray jsonObjectArray = (JSONArray) obj;
//            Servicios.creaListaDeUsuarios(jsonObjectArray);

                // Retornando JSONArray
                return jsonObjectArray;
            }
            return new JSONArray();

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
