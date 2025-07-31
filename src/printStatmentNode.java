public class printStatmentNode extends Node{
    String varName;
    printStatmentNode(String varName)
    {
        this.varName= varName;
    }

    @Override
    public String toString()
    {
        return "print("+varName+")";
    }
}
