package crawlergame;

import java.io.File;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.HashMap;

import java.awt.geom.RoundRectangle2D;
import java.awt.*;

import java.awt.image.DataBufferByte;

public class GraphicsHelper
{
    static boolean useCache = false;

    static HashMap<String, Image> imagesCache = new HashMap<String, Image>();    
    static HashMap<String, ImageIcon> imageIconsCache = new HashMap<String, ImageIcon>();    

    /**
     * Hilfsmethode zum sicheren Erzeugen eines Image aus einem Dateinamen.
     */
    public static Image createImage(String filename) {
        if (useCache) {
            Image img = imagesCache.get(filename);
            if (img!=null) return img;
        }

        URL url = URLHelper.getURL(filename);
        BufferedImage image = createFallbackImage();
        try {
            image = javax.imageio.ImageIO.read(url);
            if (useCache) {
                imagesCache.put(filename, image);
            }
        }
        catch (Exception e) {
            System.out.println(filename);
            System.out.println(e);
            System.out.println("Ein Bild unter diesem Namen existiert nicht, stattdessen wird ein leeres Bild erzeugt.");
            System.out.println("Error in GraphicsHelper: "+e);
        }
        return image;
    }    

    private static BufferedImage createFallbackImage() {
        //         return new BufferedImage(50,50,BufferedImage.TYPE_INT_RGB); // kleines schwarzes Bild als Standard
        return new BufferedImage(50,50,BufferedImage.TYPE_INT_ARGB); // kleines unsichtbares Bild als Standard
    }    

    /**
     * Hilfsmethode zum sicheren Erzeugen eines ImageIcon aus einem Dateinamen.
     */
    public static ImageIcon createImageIcon(String filename) { 
        
        URL url = URLHelper.getURL(filename);
        if (url != null) {
            ImageIcon icon = new ImageIcon(url);
            return icon;
        }
        else {
            //             System.out.println("Graphics Helper: Ein Bild '"+filename+"' existiert nicht, stattdessen wird ein leeres Bild erzeugt.");
            System.out.println("GraphicsHelper: Ein Bild '"+filename+"' existiert nicht.");
            return null;
            //             return new ImageIcon(createFallbackImage());
        }
    }

    
    
    public static ImageIcon imageToImageIcon(Image image) {
        return new ImageIcon(image);
    }

    public static Image resizeImage(Image image, int x, int y) {
        if (image == null) {
            System.out.println("Diese Bild existiert nicht, stattdessen wird ein leeres Bild erzeugt.");
            image = createFallbackImage();
        }
        Image newimg = image.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH); // alternativ: SCALE_FAST 
        return newimg;
    }

    public static ImageIcon resizeImageIcon(ImageIcon icon, int x, int y) {
        if (icon == null) icon = new ImageIcon(createFallbackImage());
        Image image = icon.getImage();
        image = resizeImage(image, x, y);
        return new ImageIcon(image);
    }

    //die folgenden Methoden gehen noch von falscher URL aus, muss relativ zu einem uebermittelnden Objekt sein
    public static Image getImageFromSpritesheet(String filename, int x, int y, int width, int height) {
        URL url = URLHelper.getURL(filename);
        java.awt.image.BufferedImage image = null;
        try {
            image = javax.imageio.ImageIO.read(url);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return image.getSubimage(x,y,width,height);
    }

    public static Image getImageFromSpritesheet(String filename, String sheetname, String spritename) {
        Element subTextureElement = parseXMLsheet(sheetname, spritename);

        String name = subTextureElement.getAttribute("name");
        int x = Integer.parseInt(subTextureElement.getAttribute("x"));
        int y = Integer.parseInt(subTextureElement.getAttribute("y"));
        int width = Integer.parseInt(subTextureElement.getAttribute("width"));
        int height= Integer.parseInt(subTextureElement.getAttribute("height"));

        return getImageFromSpritesheet(filename, x, y, width, height);
    }

    //http://gamedev.stackexchange.com/questions/59649/get-sprites-from-xml-and-spritesheet-in-java    
    private static  Element parseXMLsheet(String filename, String elementName) {
        File file = new File(filename);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        NodeList subTextureNodeList = null;
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            subTextureNodeList = document.getElementsByTagName("SubTexture");
        } catch (Exception e) {
            System.out.println(e);
        }

        for(int i = 0 ; i < subTextureNodeList.getLength(); i++){            
            Element subTextureElement = (Element) subTextureNodeList.item(i);
            if (subTextureElement.getAttribute("name").equals(elementName)) {
                return subTextureElement;
            }

            String name = subTextureElement.getAttribute("name");
            String x= subTextureElement.getAttribute("x");
            String y= subTextureElement.getAttribute("y");
            String width = subTextureElement.getAttribute("width");
            String height= subTextureElement.getAttribute("height");
        }

        return null;

    }    

    //Noch zu testen:
    /**
    //If you just want to draw the sprites, Java's Graphics class has a drawImage method 
    //that will pull a specific area of the image out for you. You just have to specify the source image, 
    //where you want to draw the sprite on your Graphics object (x, y, width, height), and in what frame 
    //of the image the sprite is located (x, y, width, height).

    //http://docs.oracle.com/javase/1.5.0/docs/api/java/awt/Graphics.html#drawImage%28java.awt.Image,%20int,%20int,%20int,%20int,%20int,%20int,%20int,%20int,%20java.awt.image.ImageObserver%29    **/
    // void drawSpriteFrame(Image source, Graphics2D g2d, int x, int y,
    //                      int columns, int frame, int width, int height)
    // {
    //     int frameX = (frame % columns) * width;
    //     int frameY = (frame / columns) * height;
    //     g2d.drawImage(source, x, y, x+width, y+height,
    //                   frameX, frameY, frameX+width, frameY+height, this);
    // }    

    static void drawScaledSpriteFromFrame(
    Image spritesheet, java.awt.Graphics2D g2d, 
    int x1goal, int y1goal,
    int x2goal, int y2goal,
    int x1source, int y1source, 
    int x2source, int y2source
    ) {
        g2d.drawImage(spritesheet, x1goal, y1goal, x2goal, y2goal, x1source, y1source, x2source, y2source, null);                
    }

    //alles noch zu testen
    static Image rotateImage(Image image, int degrees) {
        if (degrees%90 != 0) return image;
        else {
            return null;
        }
    }

    static byte [] imageToBytes(BufferedImage bufferedImage) {
        byte[] pixels = ((DataBufferByte) bufferedImage.getRaster().getDataBuffer()).getData();
        return pixels;
    }

    public static String  imageToString(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        StringBuffer string = new StringBuffer();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int rgb = image.getRGB(col, row);
                int red = (rgb >> 16) & 0x000000FF;
                // int green = (rgb >>8 ) & 0x000000FF;
                // int blue = (rgb) & 0x000000FF;
                string.append(red);
                string.append(',');
            }
        }
        return string.toString();
    }

    //https://stackoverflow.com/questions/2615522/java-bufferedimage-getting-red-green-and-blue-individually
    public static void printImageAsByte(BufferedImage image) {
        // boolean hasAlphaChannel = image.getAlphaRaster() != null;
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] result = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int rgb = image.getRGB(col, row);
                int alpha;
                int red = (rgb >> 16) & 0x000000FF;
                int green = (rgb >>8 ) & 0x000000FF;
                int blue = (rgb) & 0x000000FF;
                result[row][col] = rgb;
                //System.out.print(result[row][col]);
                System.out.print(red);
                System.out.print(",");
            }
            //System.out.println();
        }
    }

    public static void printImageAsInt(BufferedImage bufferedImage) {
        int [][] pixels = convertTo2DWithoutUsingGetRGB(bufferedImage);
        for (int [] pix : pixels) {
            for (int p : pix) {
                System.out.print(p);
                System.out.print(",");
            }
        }
    }

    //https://stackoverflow.com/questions/6524196/java-get-pixel-array-from-image    
    public static int[][] convertTo2DWithoutUsingGetRGB(BufferedImage image) {

        final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        final int width = image.getWidth();
        final int height = image.getHeight();
        final boolean hasAlphaChannel = image.getAlphaRaster() != null;

        int[][] result = new int[height][width];
        if (hasAlphaChannel) {
            final int pixelLength = 4;
            for (int pixel = 0, row = 0, col = 0; pixel + 3 < pixels.length; pixel += pixelLength) {
                int argb = 0;
                argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
                argb += ((int) pixels[pixel + 1] & 0xff); // blue
                argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
                argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
                result[row][col] = argb;
                col++;
                if (col == width) {
                    col = 0;
                    row++;
                }
            }
        } else {
            final int pixelLength = 3;
            for (int pixel = 0, row = 0, col = 0; pixel + 2 < pixels.length; pixel += pixelLength) {
                int argb = 0;
                argb += -16777216; // 255 alpha
                argb += ((int) pixels[pixel] & 0xff); // blue
                argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
                argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
                result[row][col] = argb;
                col++;
                if (col == width) {
                    col = 0;
                    row++;
                }
            }
        }

        return result;
    }

    static int[] imageToArray(Image image) {
        return null;
    }

    static Image arrayToImage(int [] data, String type) {
        return null;
    }

    static void setPixel(Image image, int pixelNumber, int newData) {
        int [] tempImage = imageToArray(image);
        tempImage[pixelNumber] = newData;
        image = arrayToImage(tempImage, null);
    }

    public static BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

    public static ImageIcon createRoundedImageIcon(String filename, int cornerRadius) {         
        Image temp = createImage(filename);
        BufferedImage btemp = toBufferedImage(temp);

        btemp = makeRoundedCorner(btemp, cornerRadius); //won't work

        return new ImageIcon(btemp);
    }

    public static ImageIcon createRoundedImageIcon(ImageIcon icon, int cornerRadius) {         
        BufferedImage btemp = toBufferedImage(icon.getImage());
        btemp = makeRoundedCorner(btemp, cornerRadius);
        return new ImageIcon(btemp);
    }

    //http://stackoverflow.com/questions/7603400/how-to-make-a-rounded-corner-image-in-java
    public static BufferedImage makeRoundedCorner(BufferedImage image, int cornerRadius) {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = output.createGraphics();

        // This is what we want, but it only does hard-clipping, i.e. aliasing
        // g2.setClip(new RoundRectangle2D ...)

        // so instead fake soft-clipping by first drawing the desired clip shape
        // in fully opaque white with antialiasing enabled...
        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Float(0, 0, w, h, cornerRadius, cornerRadius));

        // ... then compositing the image on top,
        // using the white shape from above as alpha source
        g2.setComposite(AlphaComposite.SrcAtop);
        g2.drawImage(image, 0, 0, null);

        g2.dispose();

        return output;
    }

}
