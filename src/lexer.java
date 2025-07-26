
import java.util.ArrayList;
import java.util.List;

public class lexer {
    private String input;
    private int index;
    private char currentChar;
    lexer(String input)
    {
        this.input= input;
        this.index=0;
        this.currentChar= input!=null? input.charAt(index): '\0';
    }
    public List<token> tokenize()
    {
        List<token> tokens= new ArrayList<token>();
        while (currentChar!='\0') 
        {
            skipWhiteSpace();
            if (Character.isLetter(currentChar)) 
            {
                String word = collectIdentifier();
                if (word.equalsIgnoreCase("let")) 
                {
                    tokens.add(new token(token.Type.LET, null));    
                }
                else if (word=="print")
                {
                    tokens.add(new token(token.Type.PRINT, null));    
                }
                else
                {
                    tokens.add(new token(token.Type.IDENTIFIER, null));    
                }
            }
            else if(Character.isDigit(currentChar))
            {
                String number = collectNumber();
                tokens.add(new token(token.Type.NUMBER, number));
            }
            else if(currentChar=='+')
            {
                tokens.add(new token(token.Type.PLUS, "+"));
                advance();
            }else if (currentChar == '-') {
                tokens.add(new token(token.Type.MINUS, null)); advance();
            } else if (currentChar == '*') {
                tokens.add(new token(token.Type.MULTIPLY, null)); advance();
            } else if (currentChar == '/') {
                tokens.add(new token(token.Type.DIVIDE, null)); advance();
            } else if (currentChar == '=') {
                tokens.add(new token(token.Type.EQUALS, null)); advance();
            }
            else if (currentChar == '\n') {
                tokens.add(new token(token.Type.NEXTLINE, null)); advance();
            }else {
                System.out.println("Unknown character: " + currentChar);
                advance();
             }
        }
        tokens.add(new token(token.Type.EOF, null));
            System.out.println(tokens.size());
        
        return tokens;
    }
    public void skipWhiteSpace()
    {
        if (Character.isWhitespace(currentChar)) {
            advance();
        }
    }
    public String collectIdentifier()
    {
        StringBuilder word = new StringBuilder();
        while (Character.isLetter(currentChar)) {
        word.append(currentChar);
           advance();
        }
        return word.toString();
        
    }
    public String collectNumber()
    {
        StringBuilder num= new StringBuilder();
        if (Character.isDigit(currentChar)) {
            num.append(currentChar);
            advance();
        }
        return num.toString();
    }

     void advance()
    {
        index++;
        currentChar= input.charAt(index)!='\0'? input.charAt(index):'\0';
    }

}
