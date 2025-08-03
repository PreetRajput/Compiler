import java.util.ArrayList;
import java.util.List;

public class varDecNode extends Node{
    public String varName;
    List<String> operation= new ArrayList<String>();
    List<String> alltheVaribalesInRHS= new ArrayList<String>();
    varDecNode(String varName, List<String> operation,List<String> alltheVaribalesInRHS)
    {
        this.varName= varName;
        this.operation= new ArrayList<>(operation);
        this.alltheVaribalesInRHS= new ArrayList<>(alltheVaribalesInRHS);
    }
    @Override
    public String toString()
    {
       
            
            if (operation.size()!=0)
            {
              
                    return "let" + varName+ "=" +alltheVaribalesInRHS+ ""+operation;
                
            }
            else
            {
                return "let" + varName+ "=" +alltheVaribalesInRHS;
            }
    }
    
}   
