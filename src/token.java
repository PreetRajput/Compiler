class token
{
   public  enum Type{
        LET, IDENTIFIER, EQUALS, NUMBER,
        PLUS, MINUS, MULTIPLY, DIVIDE,
        SEMICOLON, PRINT, EOF, NEXTLINE
    }
    Type type;
    String value;
    public token(Type type, String value)
    {
        this.type= type;
        this.value= value;
    }
    @Override
    public String toString()
    {
        return "[" + type + (value!= null ? ":" + value : "") + "]";
    }
}