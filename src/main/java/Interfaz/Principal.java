package Interfaz;
import Curso.*;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {
    
    public static void main(String[] args) {
        //Curso curso = new Curso("POO");
        ///curso.adicionarEstudiante(new Estudiante("M1111", "1111", "AAAA", "BBBB"));
        ///curso.adicionarEstudiante(new Estudiante("M2222", "2222", "CCCC", "DDDD"));
        //curso.adicionarEstudiante(new Estudiante("M3333", "3333", "DDDD", "EEEE"));
        //-----
        frmCurso v = new frmCurso("Mantenimiento de Curso", 600, 500);
        v.setVisible(true);
    }
    
}
