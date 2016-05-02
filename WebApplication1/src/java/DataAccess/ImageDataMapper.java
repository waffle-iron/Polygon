package DataAccess;

import java.awt.Image;
import java.io.InputStream;
import java.sql.ResultSet;

public class ImageDataMapper
{

    public void addImageToDB(InputStream Image)
    {

        try
        {
            Connector.getCon().getUpdate("INSERT INTO picturelink(IMAGE) VALUES(" + Image + ")");

        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }

    public Image getImageFromDB()
    {

        Image img = null;
        try
        {
            ResultSet res = Connector.getCon().getResults("SELECT * FROM picturelink");
            res.beforeFirst();
            for (int i = 0; res.next(); i++)
            {
                img = res.getObject(2, Image.class);
            }

        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
        return img;
    }
}
