package helperClasses;

public class Comment
{
    private String text;
    private String type;
    
    public Comment(String text, String type)
    {
        this.text = text;
        this.type = type;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
    @Override
    public String toString(){
        return type + text;
    }
   
    
    
    
    
}
