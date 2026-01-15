package msAntdron.msApp;

import msAntdron.msConsoleApp.msLogin;
import msAntdron.msDataAccess.*;
import msAntdron.msDataAccess.msDTOs.*;
import msAntdron.msBusinessLogic.*;
import msAntdron.msInfrastructure.msColores;
import java.util.List;
import java.util.ArrayList;

public class msMain {

    public static void main(String[] args) {
        
        msLogin login = new msLogin();
        if (!login.msAutenticar()) return;

        msEntomologoGenetista genetista = new msEntomologoGenetista("Mejia Sagnay");
        msFactoryBL factory = new msFactoryBL();
        List<msHormiga> hormiguero = new ArrayList<>();

        System.out.println("\n--- FASE ETL: COSECHA ---");
        msHormigaDAO hDao = new msHormigaDAO();
        msAlimentoDAO aDao = new msAlimentoDAO(); 
        
        List<msHormigaDTO> hDTOs = hDao.msLeerTodos();
        aDao.msLeerTodos(); 

        for (msHormigaDTO dto : hDTOs) {
            msHormiga h = factory.msCrearHormiga(dto);
            if(h != null) hormiguero.add(h);
        }

        System.out.println("\n--- FASE EXPERIMENTAL (CASO C: Rastreadora) ---");
        
        if (hormiguero.isEmpty()) hormiguero.add(new msHLarva()); 
        
        msHormiga miHormiga = hormiguero.get(0);
        System.out.println("1. Estado Inicial: " + miHormiga);
        
        msAlimento comida = new msInsectivoro ();
        msGenoma genoma;
        
        int intentos = 0;
        do {

            genoma = genetista.msInyectarGenoma(comida);
            
            if(genoma.msCodigo.equals("XY")) break; 
            intentos++;
        } while (intentos < 15);

        System.out.println("\n>> Alimentando Larva con Genoma: " + genoma);
        miHormiga = genetista.msAlimentarAnt(miHormiga, comida, genoma);
        
        
        System.out.println("2. Estado Final:   " + miHormiga);
        
        if (miHormiga instanceof msHRastreadora && miHormiga.toString().contains("superRastreo")) {
            System.out.println(msColores.msBLUE + "\n>>> EXAMEN APROBADO: Cumple Caso C (Rastreadora + SuperHabilidad) <<<" + msColores.msRESET);
        }
    }
}
