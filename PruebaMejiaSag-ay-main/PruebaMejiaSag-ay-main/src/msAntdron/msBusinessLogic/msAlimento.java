package msAntdron.msBusinessLogic;  

public abstract class msAlimento { 
    
    protected String msNombre;
    public msAlimento(String nombre) { this.msNombre = nombre; }
    public String msGetNombre() { return msNombre; }
}
