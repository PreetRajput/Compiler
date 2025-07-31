import java.util.ArrayList;
import java.util.List;

public class parser 
{
    public List<token> tokens;
    public int pos= 0;
    StringBuilder valueOfIdentifier = new StringBuilder();
    String varName= null;
    String operation= null;
    List<String> allTheVarVal= new ArrayList<String>();
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
                nextLine();   

            }
            else if(tokens.get(pos).type==token.Type.PRINT)
            {
                pos++; // 19
                leftParen();
                forIdentifier();
                rightParen();
           }
           else if(tokens.get(pos).type==token.Type.EOF)
           {
                
               pos++; //22
               break;
           }
        }
        
        // Add a default return to satisfy the compiler
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
            }
            allTheVarVal.add(valueOfIdentifier.toString());
        }
        
        else if(tokens.get(pos).type==token.Type.IDENTIFIER)
        {
            while (tokens.get(pos).type==token.Type.IDENTIFIER) 
            {
             
                allTheVariablesInRHS.add(tokens.get(pos).value);
                pos++; // 15 17
                if(tokens.get(pos).type==token.Type.OPERATOR)
                    {

                            operation= tokens.get(pos).value;
                            pos++;  // 16   
                           
                    }

            }
                nextLine();
        }



    }
                
    
                public void nextLine()
                {
                    if (tokens.get(pos).type==token.Type.NEXTLINE) 
                            {
                                allNodesList.add(new varDecNode(varName, operation, allTheVarVal,allTheVariablesInRHS));
                                for(Node node: allNodesList)
                                    {
                                        System.out.println(node);
                                    }
                                allTheVarVal.clear();
                                allTheVariablesInRHS.clear();
                                valueOfIdentifier.delete(0, valueOfIdentifier.length());
                                pos++; //6 11 18

                            }
                    else if(tokens.get(pos).type==token.Type.OPERATOR)
                            {
                                    operation= tokens.get(pos).value;
                                    pos++;   


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
                    allNodesList.add( new printStatmentNode(varName));
                    pos++; //21
                }
    }
}
