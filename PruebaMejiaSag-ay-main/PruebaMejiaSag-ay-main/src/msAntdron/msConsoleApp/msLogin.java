package msAntdron.msConsoleApp;

import java.util.Scanner;

import msAntdron.msInfrastructure.msColores;

public class msLogin {
    private static final String USUARIO = "patmic";
    private static final String CLAVE = "123";
    @SuppressWarnings("resource")
    public boolean msAutenticar() {
        Scanner sc = new Scanner(System.in);
        int intentos = 3;
        
        System.out.println("=== SISTEMA ANTDRON2K25 ===");
        
        while (intentos > 0) {
            System.out.print("Usuario: "); String u = sc.nextLine();
            System.out.print("Clave:   "); String p = sc.nextLine();
            

            if (u != null && p != null && u.trim().equals(USUARIO) && p.trim().equals(CLAVE)) {
                
                System.out.println(msColores.msGREEN + "\n>> Acceso concedido." + msColores.msRESET);
              
                System.out.println(">> Cédula: ...1473 | Nombre: Mejia Sagñay");
                return true;
            } else {
                intentos--;
                System.out.println(msColores.msRED + "Credenciales incorrectas. Restan: " + intentos + msColores.msRESET);
            }
        }
        sc.close();
        return false;
    }
    
}
