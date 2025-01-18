package crawlergame;

public abstract class GEGENSTAND
{

    public abstract char gibKuerzel();

    public abstract String gibBildname();

    java.net.URL getImageURL() {
        return Setup.getResource(gibBildname());
        
            // System.out.println("GEG: "+this);
            // System.out.println("GEG: "+gibBildname());
            // java.net.URL url = URLHelper.getURLRelative(this, Setup.imagePath +gibBildname());
            // return url;
    }    


}
