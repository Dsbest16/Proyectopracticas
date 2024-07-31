package Curso;

public class Estudiante extends Persona{
    private String numMatricula;

    public Estudiante(String numMatricula, String cedula, String nombres, String apellidos) {
        super(cedula, nombres, apellidos);
        this.numMatricula = numMatricula;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Cedula:" + this.getCedula() + 
                           " Nombres:" + this.getNombres() +
                           " Apellidos: " + this.getApellidos() +
                           " Num. Matricula: " + this.numMatricula);
    }
    
    
    
    
}
