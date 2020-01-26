public class ColorToChar
{
    private String characters;

    ColorToChar(String str)
    {
        characters = str;
    }

    public int colorToGrayScale(int rgb)
    {
        int r = (rgb>>16) & 255;
        int g = (rgb>>8) & 255;
        int b = (rgb) & 255;
        return (int) (0.3 * r + 0.59 * g + 0.11 * b);
    }

    public Character colorToChar(Integer rgb)
    {
        int gray = colorToGrayScale(rgb);
        return characters.charAt((characters.length() - 1) * gray / 255);
    }
}
