package msAntdron.msBusinessLogic;

import msAntdron.msInfrastructure.msColores;

public class msHLarva extends msHormiga {
        public msHLarva() { super("HLarva"); }

    @Override
    public msHormiga msComer(msAlimento alimento, msGenoma genoma) {

        if (alimento instanceof msInsectivoro) {
            
            
            msHRastreadora evolucion = new msHRastreadora();
            
            if (genoma != null) {

                if (genoma.msCodigo.equals("XY")) evolucion.msSetSexo("Hembra"); 
                else if (genoma.msCodigo.equals("XX")) evolucion.msSetSexo("Macho");
                
                
                if (genoma.msCodigo.equals("XY")) {
                    evolucion.msSetSuperHabilidad("superRastreo(Activado)");
                    System.out.println(msColores.msGREEN + "   [EVOLUCIÓN] ¡Genoma XY compatible! Habilidad Activada." + msColores.msRESET);
                }
            }
            return evolucion;
        } else {
            this.msEstadoVida = "MUERTO";
            System.out.println(msColores.msRED + "   [MUERTE] Alimento incorrecto." + msColores.msRESET);
            return this;
        }
    }
        
    }