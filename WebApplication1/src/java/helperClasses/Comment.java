package helperClasses;

import java.awt.image.BufferedImage;

public class Comment
{
    private String text;
    private String type;
    private BufferedImage image;

    public Comment(String text, String type, BufferedImage image) {
        this.text = text;
        this.type = type;
        this.image = image;
    }
    
    public Comment(String text, String type)
    {
        this.text = text;
        this.type = type;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
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
