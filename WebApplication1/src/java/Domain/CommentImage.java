/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.servlet.http.Part;

public class CommentImage
{

    private BufferedImage Image;
    private Part filepart;
    private InputStream Bytes;

    public CommentImage(BufferedImage Image, Part filepart, InputStream Bytes)
    {
        this.Image = Image;
        this.filepart = filepart;
        this.Bytes = Bytes;
    }

    public BufferedImage getImage()
    {
        return Image;
    }

    public void setImage(BufferedImage Image)
    {
        this.Image = Image;
    }

    public Part getFilepart()
    {
        return filepart;
    }

    public void setFilepart(Part filepart)
    {
        this.filepart = filepart;
    }

    public InputStream getBytes()
    {
        return Bytes;
    }

    public void setBytes(InputStream Bytes)
    {
        this.Bytes = Bytes;
    }

}
