import java.util.ArrayList;
import java.util.List;

public class varDecNode extends Node{
    public String varName;
    public String operation;
    public int i;
    List<String> firstNumVal= new ArrayList<String>();
    List<String> alltheVaribalesInRHS= new ArrayList<String>();
    varDecNode(String varName, String operation, List<String> firstNumVal, List<String> alltheVaribalesInRHS)
    {
        this.varName= varName;
        this.operation= operation;
        this.firstNumVal= firstNumVal;
        this.alltheVaribalesInRHS= alltheVaribalesInRHS;
    }
    @Override
    public String toString()
    {
       
            
            if (operation!=null) 
            {
              
                    return "let" + varName+ "=" +firstNumVal+ ""+operation;
                
            }
            else
            {
                return "let" + varName+ "=" +firstNumVal;
            }
    }
    
}   
