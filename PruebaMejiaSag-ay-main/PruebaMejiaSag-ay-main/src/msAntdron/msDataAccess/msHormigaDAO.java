package msAntdron.msDataAccess;

import msAntdron.msDataAccess.msInterfaces.msIDAO;
import msAntdron.msDataAccess.msDTOs.msHormigaDTO;
import msAntdron.msDataAccess.msHelpers.msDataHelper;
import msAntdron.msInfrastructure.msColores;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class msHormigaDAO implements msIDAO<msHormigaDTO> {

    @Override
    public List<msHormigaDTO> msLeerTodos() {
        List<msHormigaDTO> lista = new ArrayList<>();
        System.out.println("Loading... " + msDataHelper.RUTA_NEST); 

        try (BufferedReader br = new BufferedReader(new FileReader(msDataHelper.RUTA_NEST))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if(!linea.trim().isEmpty()){

                    msHormigaDTO dto = new msHormigaDTO(linea.trim());
                    lista.add(dto);

                    System.out.println(msColores.msBLUE + "   -> Leído: " + linea + msColores.msRESET);
                }
            }
        } catch (Exception e) {

            System.out.println(msColores.msRED + "   [ERROR ETL] Fallo lectura AntNest." + msColores.msRESET);
            lista.add(new msHormigaDTO("HLarva")); 
        }
        return lista;
    }
}
