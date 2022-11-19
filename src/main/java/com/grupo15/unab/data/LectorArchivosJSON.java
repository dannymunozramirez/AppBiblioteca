package com.grupo15.unab.data;


import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * Esta clase se encarga de controlar el arichivo a escribir, toma el archivo con extencion JSON
 * y lo convierte en un tipo JSONArray
 */
public class LectorArchivosJSON {
    static JSONParser parser = new JSONParser();
    static Object obj;

    /**
     * <p>
     * Este método lee el archivo JSON entregado en el parametro,
     * EL ARCHIVO JSON (JSONARRAY) DEBE ALMENOS TENER 0 "[]" ELEMENTOS.
     * </p>
     *
     * @param ubicacionArchivo
     */
    public static JSONArray lectorJSON(String ubicacionArchivo) {

        try {
            obj = parser.parse(new FileReader(ubicacionArchivo));
            JSONArray jsonObjectArray = (JSONArray) obj;


            return jsonObjectArray;
        } catch (IOException | ParseException e) {
            System.out.println(e + " ARCHIVO INVÁLIDO, DEBE TENER ALMENOS 0 ELEMENTOS [] LISTA VACÍA ");
            throw new RuntimeException(e);
        }
    }
}
