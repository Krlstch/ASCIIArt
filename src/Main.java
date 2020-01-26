import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        String source = "Sources/picture.jpg";
        Picture pic = new Picture();
        pic.loadPicture(source);

        ArrayList<ColorToChar> trans = new ArrayList<>();
        trans.add(new ColorToChar("qwertyuiop"));
        trans.add(new ColorToChar("@#QO?!oc>=+*;,'..  "));
        trans.add(new ColorToChar("$Gf/o?)/>*;-."));
        trans.add(new ColorToChar("#WKDGLftji+;,:. "));


        File dir = new File("Results");
        if(!dir.exists())
            dir.mkdir();

        ArrayList<PrintWriter> writers = new ArrayList<>();
        for(int i = 0; i < trans.size(); i++)
            writers.add(new PrintWriter("Results/ASCIIArt_pic" + i + ".txt", StandardCharsets.UTF_8));



        for(int k = 0; k < trans.size(); k++)
        {
            pic.setTrans(trans.get(k));
            pic.setWriter(writers.get(k));
            pic.toChar();
            pic.print();
        }

    }
}
