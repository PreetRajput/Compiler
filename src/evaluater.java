import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class evaluater {
    Map<String, Integer> nodeValue= new HashMap<>();
    int sum=0;
    public evaluater(List<Node> nodes)
    {
        for (Node variable : nodes) 
        {
             if (variable instanceof varDecNode) {
                visitVarDec((varDecNode) variable);
             }   
             else if(variable instanceof printStatmentNode){
                visitPrintStatement((printStatmentNode) variable);
             }
        }
    }
    public void visitVarDec(varDecNode node)
    {
        String varName= node.varName;
        int value=0;
        int trash=0;
        int size = node.alltheVaribalesInRHS.size();
        if (node.operation==null) {
             value = Integer.parseInt(node.firstNumVal.get(0));
        }
        else
        {
            value=0;
            while (size!=0) 
            {
                
                if (node.operation=="+") 
                {
                    value+=nodeValue.get(node.alltheVaribalesInRHS.get(size-1).toString());
                }
                else if(node.operation=="-")
                {
                    if(trash==0)
                    {

                        value=nodeValue.get(node.alltheVaribalesInRHS.get(trash).toString());
                    }
                    else
                    {
                        value-=nodeValue.get(node.alltheVaribalesInRHS.get(trash).toString());;
                        
                    }
                    trash++;
                }
                else if(node.operation=="*")
                {
                    value*=nodeValue.get(node.alltheVaribalesInRHS.get(size-1).toString());
                }
                else 
                {
                    if(trash==0)
                    {

                        value=nodeValue.get(node.alltheVaribalesInRHS.get(trash).toString());
                    }
                    else
                    {
                        value/=nodeValue.get(node.alltheVaribalesInRHS.get(trash).toString());;
                        
                    }
                    trash++;
                }
                size--;
            }
        }
        nodeValue.put(varName, value);
    }
    public void visitPrintStatement(printStatmentNode node)
    {
        System.out.println(nodeValue.get(node.varName));
    }
}
