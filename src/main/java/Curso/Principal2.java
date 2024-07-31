package Curso;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Principal2 {

    public static void main(String[] args) {
        String json;

        // Leer archivo
        json = leerArchivo();
        
        // Creando Curso
        Curso cur;
        if (!json.equals("")){
            cur = deserializar(json);
        }
        else
        {
             cur= new Curso("POO");
            // Adicionando estudiantes
            cur.adicionarEstudiante(new Estudiante("M111", "111","AAA","BBB"));
            cur.adicionarEstudiante(new Estudiante("M222", "222","CCC","DDD"));
            cur.adicionarEstudiante(new Estudiante("M333", "333","EEE","FFF"));
            cur.adicionarEstudiante(new Estudiante("M444", "444","GGG","HHH"));
            // listando estudiantes
            cur.listarEstudiantes();
            System.out.println("--------------------------------------");

            // Actualizar estudiante
            cur.actualizarEstudiante(new Estudiante("M999", "444","XXX","YYY"));
        }
        
        // listando estudiantes
        cur.listarEstudiantes();
        System.out.println("--------------------------------------");
        
        System.out.println("Serializando");
        json = serializar(cur);
        grabarArchivo(json);
        
    }
    
    public static String leerArchivo(){
        String ruta = new File (".").getAbsolutePath();
        String archivo = ruta + "\\curso.txt";
        String ret="";
        try{
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            ret = br.readLine();
        }
        catch(Exception ex){
            System.out.println("Problemas al leer archivo -> " + 
                               ex.getMessage());
        }
        return ret;
    }
    
    public static void grabarArchivo(String json){
        String ruta = new File (".").getAbsolutePath();
        String archivo = ruta + "\\curso.txt";
        try{
            FileWriter file = new FileWriter(archivo, true);
            file.write(json);
            file.flush();            
        }         
        catch(Exception ex){
            System.out.println("Problemas al grabar archivo ->" +
                               ex.getMessage());
        }
    }
    
    public static String serializar(Curso cur){
        Gson gson = new Gson();
        String json = gson.toJson(cur);
        return json;
    }
    
    public static Curso deserializar(String json){
        Gson gson = new Gson();
        Curso cur = gson.fromJson(json, Curso.class);
        return cur;
    }    
}
