package msAntdron.msBusinessLogic;

 public class msHRastreadora extends msHormiga {
    public msHRastreadora() { super("HRastreadora"); }
    
    @Override
    public msHormiga msComer(msAlimento a, msGenoma g) {
        if(a instanceof msInsectivoro) System.out.println("   [HRastreadora] Alimentándose.");
        return this;
    }
     
 }