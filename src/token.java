class token
{
   public  enum Type{
        LET, IDENTIFIER, EQUALS, NUMBER,
       OPERATOR, SEMICOLON, PRINT, EOF, NEXTLINE, LEFT_PAREN, RIGHT_PAREN
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