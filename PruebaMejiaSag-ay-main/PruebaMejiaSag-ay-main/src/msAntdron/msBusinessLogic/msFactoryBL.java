package msAntdron.msBusinessLogic;  
 
import msAntdron.msDataAccess.msDTOs.msHormigaDTO;

public class msFactoryBL {

    public msHormiga msCrearHormiga(msHormigaDTO dto) {
        if (dto.msTipoHormiga.equalsIgnoreCase("HLarva")) return new msHLarva();
        
        return null;
    }
}