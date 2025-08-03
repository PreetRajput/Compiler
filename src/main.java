
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) 
    {
        try {
            String input = new String(Files.readAllBytes(Paths.get("src/SourceCode.txt")));  
            lexer obj= new lexer(input);
            List<token> tokens= obj.tokenize();
            
            for(token eachToken: tokens)
            {
                System.out.println(eachToken);
            }
            parser obj2= new parser(tokens);
            List<Node> Nodes= obj2.node();
            for(Node node: Nodes)
            {
                System.out.println(node);
            }

            evaluater obj3 = new evaluater(Nodes);
           
        } catch (Exception e) {
             System.err.println("crazy error" + e.getMessage());
             e.printStackTrace();
        }
    }
}
