package com.grupo15.unab.data;


import com.grupo15.unab.clientes.Clientes;
import com.grupo15.unab.usuarios.Docente;
import com.grupo15.unab.usuarios.Usuario;
import com.grupo15.unab.validaciones.Validaciones;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LectorArchivosJSON {

    static JSONParser parser = new JSONParser();
    static Object obj;

    public static List<Object> lectorJSON(String ubicacionArchivo) {

        try {
            obj = parser.parse(new FileReader(ubicacionArchivo));
            String s = obj.toString();
            JSONArray jsonObjectArray = (JSONArray) obj;

            List<Usuario> usuariosDesdeJSON = new ArrayList<Usuario>();


            jsonObjectArray.forEach(user -> {

                JSONObject jsonObject = (JSONObject) user;
                String tipo = (String) jsonObject.get("tipo");
                String run = (String) jsonObject.get("run");
                String nombre = (String) jsonObject.get("nombre");
                String genero = (String) jsonObject.get("genero");
                String ISBN = (String) jsonObject.get("ISBN");
                String grado = (String) jsonObject.get("grado");

                // new Docente("1-3","Test","M","magister")
                if(tipo.equals("Docente")){
                    Usuario usuarioDeJSON = new Docente(run, nombre, genero, grado);
                    usuariosDesdeJSON.add(usuarioDeJSON);
                }



            });

            Clientes clientes = new Clientes(usuariosDesdeJSON);

            clientes.getUsuarios().forEach(usuario -> {
                System.out.println(usuario.getRun() + " RUT DESDE LA CLASE CLIENTE");
            });
//            System.out.println(obj + " LINEA DEL TRY ===============");

            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Usuario> creaListaDeUsuarios(Object objetoDesdeJSON) {

        JSONObject jsonObject = (JSONObject) obj;
        String name = (String) jsonObject.get("Name");
        String course = (String) jsonObject.get("Course");
        JSONArray subjects = (JSONArray) jsonObject.get("Subjects");
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Subjects:");
        Iterator iterator = subjects.iterator();

//        objetoDesdeJSON
        return null;
    }
}
