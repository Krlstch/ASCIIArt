import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Picture
{
    private int x;
    private int y;
    private ArrayList<Integer> pixels = new ArrayList<>();
    private ArrayList<Character> charPixels = new ArrayList<>();
    private PrintWriter writer = null;
    private ColorToChar trans = null;


    public void loadPicture(String source) throws IOException
    {
        pixels = new ArrayList<>();
        BufferedImage img = ImageIO.read(new File(source));

        x = img.getWidth();
        y = img.getHeight();
        for(int j = 0; j < y; j++)
            for(int i = 0; i < x; i++)
                pixels.add(img.getRGB(i, j));
    }

    public void toChar() throws Exception
    {
        charPixels.clear();
        if(pixels == null)
            throw new Exception("There is no image loaded. Use loadPicture(String source)");
        if(trans == null)
            throw new Exception("There is no pixel to color transformation set. Use setTrans(ColorToChar trans");
        for (int i = 0; i < x * y; i++)
            charPixels.add(trans.colorToChar(pixels.get(i)));
    }

    public void print() throws Exception
    {
        toChar();
        for (int j = 0; j < y; j++)
        {
            for (int i = 0; i < x; i++)
            {
                writer.print(charPixels.get(i + j * x));
                writer.print(charPixels.get(i + j * x));
            }
            writer.println();
        }
        writer.flush();
    }

    public void setTrans(ColorToChar trans)
    {
        this.trans = trans;
    }

    public void setWriter(PrintWriter writer)
    {
        this.writer = writer;
    }
}
