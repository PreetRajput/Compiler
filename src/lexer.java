
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
                else if (word.equalsIgnoreCase("print"))
                {
                    tokens.add(new token(token.Type.PRINT, null));    
                }
                else
                {
                    tokens.add(new token(token.Type.IDENTIFIER, word));    
                }
            }
            else if(Character.isDigit(currentChar))
            {
                String number = collectNumber();
                tokens.add(new token(token.Type.NUMBER, number));
            }
            else if(currentChar=='+')
            {
                tokens.add(new token(token.Type.OPERATOR, "+"));
                advance();
            }else if (currentChar == '-') {
                tokens.add(new token(token.Type.OPERATOR, "-")); advance();
            } else if (currentChar == '*') {
                tokens.add(new token(token.Type.OPERATOR, "*")); advance();
            } else if (currentChar == '/') {
                tokens.add(new token(token.Type.OPERATOR, "/")); advance();
            } else if (currentChar == '=') {
                tokens.add(new token(token.Type.EQUALS, "=")); advance();
            }
            else if (currentChar == '\n') {
                tokens.add(new token(token.Type.NEXTLINE, null)); advance();
            }else if (currentChar == '(') {
                tokens.add(new token(token.Type.LEFT_PAREN, null)); advance();
            }else if (currentChar == ')') {
                tokens.add(new token(token.Type.RIGHT_PAREN, null)); advance();
            }
            else {
                System.out.println("Unknown character: " + currentChar);
                advance();
             }
        }
             tokens.add(new token(token.Type.EOF, null));
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
        currentChar= index<input.length()? input.charAt(index):'\0';
    }

}
