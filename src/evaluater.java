import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class evaluater {
    Map<String, Integer> nodeValue= new HashMap<>();
    int sum=0;
    binaryOP obj = new binaryOP();
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
        int left, right;
        int trashForVar=1;
        int size = node.operation.size();

        if (size==0) 
        {
            try {
                
                value = Integer.parseInt(node.alltheVaribalesInRHS.get(0));
            } catch (Exception e) {
                value= nodeValue.get(node.alltheVaribalesInRHS.get(0));
                // TODO: handle exception
            }
        }
        else
        {
            String currentToken= node.operation.get(0);
            try {
                left = Integer.parseInt(node.alltheVaribalesInRHS.get(0));
            } catch (Exception e) {
                left = nodeValue.get(node.alltheVaribalesInRHS.get(0));
                }
            while (currentToken == "+" || currentToken == "-" || currentToken == "*" || currentToken == "/") 
            {
                        try {
                        right = Integer.parseInt(node.alltheVaribalesInRHS.get(trashForVar));
                    } catch (Exception e) {
                        right = nodeValue.get(node.alltheVaribalesInRHS.get(trashForVar));
                    }
                left = obj.operation(left, currentToken, right);
                trash++;
                if (trash==node.operation.size()) {
                    break;
                }
                currentToken= node.operation.get(trash);
                trashForVar++;
            }
            value=left;
            
        }
        nodeValue.put(varName, value);
    }
    public void visitPrintStatement(printStatmentNode node)
    {
       System.out.println(nodeValue.get(node.varName));
    }
}
