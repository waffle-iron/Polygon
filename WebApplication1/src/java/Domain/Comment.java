package Domain;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class Comment
{
    private String text;
    private String type;
    private CommentImage image;
    private int commentID;
    private int ReportID;
    private int ReportPageID;

    public Comment(String text, String type, CommentImage image) {
        this.text = text;
        this.type = type;
        this.image = image;
    }
    
    public Comment(String text, String type)
    {
        this.text = text;
        this.type = type;
    }

    public Comment(String text, String type, int commentID,int ReportID, int ReportPageID) {
        this.text = text;
        this.type = type;
        this.commentID = commentID;
        this.ReportID = ReportID;
        this.ReportPageID = ReportPageID;
    }

    public int getReportID() {
        return ReportID;
    }

    public void setReportID(int ReportID) {
        this.ReportID = ReportID;
    }

    public int getReportPageID() {
        return ReportPageID;
    }

    public void setReportPageID(int ReportPageID) {
        this.ReportPageID = ReportPageID;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public CommentImage getCommentImage(){
        return image;
    }
    public  void setCommentImage(CommentImage commentImage){
        this.image = commentImage;
    }
    public BufferedImage getImage() {
        if(image !=null)
            return image.getImage();
        else
            return null;
    }

    public void setImage(BufferedImage image) {
        this.image.setImage(image);
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
