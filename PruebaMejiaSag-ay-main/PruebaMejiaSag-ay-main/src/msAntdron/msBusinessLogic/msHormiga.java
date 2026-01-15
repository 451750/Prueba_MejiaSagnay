package msAntdron.msBusinessLogic;

public abstract class msHormiga {

    protected String msTipo;
    protected String msEstadoVida = "VIVO";
    protected String msSuperHabilidad = "Ninguna"; 
    protected String msSexo = "Asexual";

    public msHormiga(String tipo) { this.msTipo = tipo; }

    public abstract msHormiga msComer(msAlimento alimento, msGenoma genoma);

    @Override
    public String toString() {
        return String.format("%-15s | Sexo: %-8s | Estado: %-5s | Skill: %s", 
                msTipo, msSexo, msEstadoVida, msSuperHabilidad);
    }
    
    public void msSetSexo(String s) { this.msSexo = s; }
    public void msSetSuperHabilidad(String h) { this.msSuperHabilidad = h; }
}