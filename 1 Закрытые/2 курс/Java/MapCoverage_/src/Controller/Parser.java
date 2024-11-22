package Controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {
    private static int monthsPassedSince2000fb = 0;
    private static int linkPartMin = 1753171; // https://neo.gsfc.nasa.gov/servlet/RenderData?si=1753171&cs=rgb&format=CSV&width=1440&height=720
    private static int linkPartMax = 1956688; // https://neo.gsfc.nasa.gov/servlet/RenderData?si=1956688&cs=rgb&format=CSV&width=1440&height=720

    public static String ParseDownloadLink(String URL, String LinkFormat){
        String format_ = "&cs=rgb&format=CSV&width=1440&height=720";
        return new String();
    }
}