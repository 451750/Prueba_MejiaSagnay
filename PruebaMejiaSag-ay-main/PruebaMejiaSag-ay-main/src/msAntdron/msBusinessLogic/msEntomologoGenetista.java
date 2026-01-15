package msAntdron.msBusinessLogic;

import java.util.Random;

public class msEntomologoGenetista implements msIEntomologo {
    
    public String msNombre;
    public msEntomologoGenetista(String nombre) { this.msNombre = nombre; }

    @Override public void msEtlAntNest() {} // Se hace en Main
    @Override public void msEtlAntFood() {}

    @Override
    public msHormiga msAlimentarAnt(msHormiga h, msAlimento a, msGenoma g) {
        return h.msComer(a, g);
    }

    public msGenoma msInyectarGenoma(msAlimento alimento) {
        String[] tipos = {"X", "XX", "XY"};
        String codigo = tipos[new Random().nextInt(tipos.length)];
        
        System.out.println("[ Preparado ] --( " + alimento.msGetNombre() + " + Genoma " + codigo + " )--");
        
        return new msGenoma(codigo);
    }
}
