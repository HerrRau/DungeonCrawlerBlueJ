package crawlergame;

public abstract class Item
{

    public abstract char gibKuerzel();

    public abstract String gibBildname();

    java.net.URL getImageURL() {
        return Setup.getResource(gibBildname());
    }    
    
    public boolean isBig() {
        return false;
    }


}
