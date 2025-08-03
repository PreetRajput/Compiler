import java.util.ArrayList;
import java.util.List;

public class parser 
{
    public List<token> tokens;
    public int pos= 0;
    StringBuilder valueOfIdentifier = new StringBuilder();
    String varName= null;
    List<String> operation= new ArrayList<String>();
    List<String> allTheVariablesInRHS= new ArrayList<String>();
    List<Node> allNodesList= new ArrayList<Node>();
                
                parser(List<token> tokens)
                {
                    this.tokens= tokens;
                }
    
    public List<Node> node()
    {

        while (pos < tokens.size()) 
        {
           
            if (tokens.get(pos).type==token.Type.LET)
             {
                
                 pos++;//1 7 12
                 
                 forIdentifier();
                 forEqualsTo();
                 valueOfIdentifier();
                 nextLine("varDecNode");   
                
                 
                }
                else if(tokens.get(pos).type==token.Type.PRINT)
                {
                pos++; // 19
                leftParen();
                forIdentifier();
                rightParen();
                nextLine("printStatementNode");   


            }
            else if(tokens.get(pos).type==token.Type.EOF)
            {
                
               pos++; //22
               break;
           }
        }
        return allNodesList;
    } 
    
    
    
    public void forIdentifier()
    {
        
        if (tokens.get(pos).type==token.Type.IDENTIFIER) 
        {
                    varName= tokens.get(pos).value;
                    pos++; //2 8 13
        }

    }
                
    
                public void forEqualsTo()
                {
                    if (tokens.get(pos).type==token.Type.EQUALS) 
                    {
                                pos++; // 3 9 14
                    }


                }
    
    
    public void valueOfIdentifier()
    {
        if (tokens.get(pos).type==token.Type.NUMBER) 
        {

            while (tokens.get(pos).type==token.Type.NUMBER) 
            {
                            valueOfIdentifier.append(tokens.get(pos).value);
                            pos++; // 5 10
                            if(tokens.get(pos).type==token.Type.OPERATOR)
                                    {
                
                                            operation.add(tokens.get(pos).value);
                                            pos++;  // 16   
                                            allTheVariablesInRHS.add(valueOfIdentifier.toString());
                                            valueOfIdentifier.delete(0, valueOfIdentifier.length());
                                           
                                    }
            }
              allTheVariablesInRHS.add(valueOfIdentifier.toString());

        }
        
        else if(tokens.get(pos).type==token.Type.IDENTIFIER)
        {
            while (tokens.get(pos).type==token.Type.IDENTIFIER) 
            {
             
                allTheVariablesInRHS.add(tokens.get(pos).value);
                pos++; // 15 17
                if(tokens.get(pos).type==token.Type.OPERATOR)
                    {

                            operation.add(tokens.get(pos).value);
                            pos++;  // 16   
                           
                    }
                    while (tokens.get(pos).type==token.Type.NUMBER ) 
                    {
                     
                        allTheVariablesInRHS.add(tokens.get(pos).value);
                        pos++; // 15 17
                        if(tokens.get(pos).type==token.Type.OPERATOR)
                            {
        
                                    operation.add(tokens.get(pos).value);
                                    pos++;  // 16   
                                   
                            }
                    }
            }
                nextLine("varDecNode");
        }



    }
                
    
                public void nextLine(String typeOfNode)
                {
                    if (typeOfNode.equalsIgnoreCase("varDecNode")) {
                        
                        if (tokens.get(pos).type==token.Type.NEXTLINE) 
                                {
                                    allNodesList.add(new varDecNode(varName, operation,allTheVariablesInRHS));
                                    allTheVariablesInRHS.clear();
                                    operation.clear();
                                    valueOfIdentifier.delete(0, valueOfIdentifier.length());
                                    pos++; //6 11 18
                                    }
                        else if(tokens.get(pos).type==token.Type.OPERATOR)
                                {
                                        operation.add(tokens.get(pos).value);
                                        pos++;   
    
    
                                }
                    }
                    else if (typeOfNode.equalsIgnoreCase("printStatementNode"))
                    {
                        
                                    allNodesList.add( new printStatmentNode(varName));
                                    pos++; //6 11 18
    
                       
                    }
                }
    
    
    public void leftParen()
    {
                if (tokens.get(pos).type==token.Type.LEFT_PAREN) 
                {
                    pos++; //20
                 }
    }
    public void rightParen()
    {
                 if (tokens.get(pos).type==token.Type.RIGHT_PAREN) 
                {
                    pos++; //21
                }
    }
}
