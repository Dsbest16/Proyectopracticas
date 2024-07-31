package Curso;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* Relaciones: Clases que contienen objetos como atributos
* Pueden ser: Asociación o Composición
* Ver https://www.unirioja.es/cu/jearansa/0910/archivos/EIPR_Tema02.pdf
*/

public class Curso {
    /**
     * Las relaciones de agregación se entenderán como relaciones
     * en las cuales una serie de clases aparecen como tipos de
     * los atributos de otra clase.
     * 
     * La mejor forma de identificar si nos encontramos en una 
     * relación de este tipo es preguntarnos si la clase que se
     * esta definiendo "has a (tiene un)" atributo de otra clase
     * que estemos usando
     * 
     * En este caso la clase Curso tiene un atributo de tipo 
     * String (generalmente no se grafica en los diagrama UML) y 
     * un atributo de tipo docente
     */    
    private String nombre;
    private Docente docente;
    
    /**
     * Composición es un tipo especial de agregación, en el cual
     * los objetos agregados no tienen sentido fuera del objeto
     * resultante.  Tambien se puede entender como una relación
     * en la que, los objetos que estan siendo agregados, deben 
     * dejar de existir cuando lo hace  el objeto compuesto.
     * 
     * Elementos:
     * 1) La compisición se denota con un rombo negro sobre la clase
     *    que contiene a las otras.
     * 2) Se añande multiplicidad a la relación. por ejemplo:"0..*"
     * 3) Se añade una etiqueta que nos da una idea de como se
     *    relacionan las clases.
     */
    private ArrayList<Estudiante> listado;

    public Curso(String nombre) {
        this.nombre = nombre;
        listado = new ArrayList<Estudiante>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public ArrayList<Estudiante> getListado() {
        return listado;
    }
    
    /** 
     * Método buscarEstudiante: realiza la búsqueda de un 
     * estudiante dentro del array "listado". Retorna null
     * si la cedula no existe, caso contrario devuelve una
     * referencia al estudiante que tiene la cedula
     * @param cedula (Cadena)
     * @return ret
     */
    private Estudiante buscarEstudiante(String cedula){
        Estudiante ret = null;
        for(Estudiante e: listado){
            if(e.getCedula().equals(cedula))
            {
                ret = e;
            }
        }
        return ret;
    }    
    
    /**
     * Metodo adicionarEstudiante: Adiciona un estudiante
     * al array "Listado". No se podrán ingresar estudiantes
     * que tengan cedula duplicada.
     * @param estudiante (Referencia a un objto tipo estudiante)
     */
    public void adicionarEstudiante(Estudiante estudiante){
        Estudiante existe = buscarEstudiante(estudiante.getCedula());
        if( Objects.equals(existe,null) )
            listado.add(estudiante);
        else
            System.out.println("Estudiante ya existe");
    }
    
    /**
     * Metodo actualizarEstudiante: Actualiza los datos de un 
     * estudiante en el array "Listado". Solo se puede modificar
     * los datos si el estudiante existe
     * @param estudiante (Referencia a un objto tipo estudiante)
     */    
    public void actualizarEstudiante(Estudiante estudiante){
        Estudiante existe = buscarEstudiante(estudiante.getCedula());
        if( Objects.equals(existe, null) )
            System.out.println("Estudiante no existe");
        else {
            existe.setNombres(estudiante.getNombres());
            existe.setApellidos(estudiante.getApellidos());
            existe.setNumMatricula(estudiante.getNumMatricula());
        }
    }
    
    /**
     * ListarEstudiantes: Lista a pantalla los datos de todos los
     * estudiantes que se encuentran dentrol del array "Listado"
     */
    public void listarEstudiantes(){
        for(Estudiante e: listado){
            e.mostrarDatos();
        }
    }
    
    public void eliminarEstudiante(String cedula){
        listado.removeIf(est -> (est.getCedula() == cedula));
    }
    
    private void ordenarEstudiantes(){
        Collections.sort(listado, new Comparator<Estudiante>(){
            @Override
            public int compare(Estudiante e1, Estudiante e2) {
                return (Integer)(e1.getApellidos().compareTo(e2.getApellidos()));
            }
        });       
    }    
    

     

        
}
