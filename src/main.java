
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class main {
    public static void main(String[] args) 
    {
        try {
            String input = new String(Files.readAllBytes(Paths.get("SourceCode.txt")));  
            lexer obj= new lexer(input);
            List<token> tokens= obj.tokenize();
            System.out.println(tokens.size());
        } catch (Exception e) {
            System.err.println("crazy error");
        }
    }
}
