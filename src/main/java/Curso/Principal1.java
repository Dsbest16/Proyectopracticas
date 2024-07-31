package Curso;

import com.google.gson.Gson;

public class Principal1 {

    public static void main(String[] args) {
        // Creando Curso
        Curso cur = new Curso("POO");
        
        cur.setDocente(new Docente("888","888","ABC", "III"));
                
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
        
        // listando estudiantes
        cur.listarEstudiantes();
        System.out.println("--------------------------------------");
        
        System.out.println("Serializando");
        String json = Serializar(cur);
        System.out.println(json);
        System.out.println("--------------------------------------");
        
        System.out.println("Deserializando");
        Curso newCur = Deserializar(json);
        newCur.listarEstudiantes();
        
        
    }
    
    public static String Serializar(Curso cur){
        Gson gson = new Gson();
        String json = gson.toJson(cur);
        return json;
    }
     
    public static Curso Deserializar(String json){
        Gson gson = new Gson();
        Curso cur = gson.fromJson(json, Curso.class);
        return cur;
    }    
}
