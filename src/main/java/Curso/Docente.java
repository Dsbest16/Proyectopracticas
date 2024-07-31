package Curso;

public class Docente extends Persona {
    private String numContrato;

    public Docente(String numContrato, String cedula, String nombres, String apellidos) {
        super(cedula, nombres, apellidos);
        this.numContrato = numContrato;
    }

    public String getNumContrato() {
        return numContrato;
    }

    public void setNumContrato(String numContrato) {
        this.numContrato = numContrato;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Cedula:" + this.getCedula() + 
                           " Nombres:" + this.getNombres() +
                           " Apellidos: " + this.getApellidos() +
                           " Num. Contrato: " + this.numContrato);    
    }
    
    
    
}
