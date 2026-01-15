package msAntdron.msDataAccess;

import msAntdron.msDataAccess.msInterfaces.msIDAO;
import msAntdron.msDataAccess.msDTOs.msAlimentoDTO;
import msAntdron.msDataAccess.msHelpers.msDataHelper;
import msAntdron.msInfrastructure.msColores;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class msAlimentoDAO implements msIDAO<msAlimentoDTO> {

    @Override
    public List<msAlimentoDTO> msLeerTodos() {
        List<msAlimentoDTO> lista = new ArrayList<>();
        System.out.println("Waiting... " + msDataHelper.RUTA_FOOD);

        try (BufferedReader br = new BufferedReader(new FileReader(msDataHelper.RUTA_FOOD))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if(!linea.trim().isEmpty()){
                    lista.add(new msAlimentoDTO(linea.trim()));
                    System.out.println(msColores.msBLUE + "   -> Leído: " + linea + msColores.msRESET);
                }
            }
        } catch (Exception e) {
            System.out.println(msColores.msRED + "   [ERROR ETL] Fallo lectura AntFood." + msColores.msRESET);
            lista.add(new msAlimentoDTO("Insectivoro")); 
        }
        return lista;
    }
}
