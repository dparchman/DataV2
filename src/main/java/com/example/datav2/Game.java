package com.example.datav2;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.*;
import java.time.LocalDate;
public class Game implements Serializable {

    // fields
    private String game;
    private float sales;
    private String series;
    private LocalDate release;
    private String developer;
    private String publisher;
    private int salesInt;
    private transient Image ImageField;

    public Game(String game, float sales, String series, LocalDate release, String developer, String publisher, int salesInt) {
        this.game = game;
        this.sales = sales;
        this.salesInt = salesInt;
        this.series = series;
        this.release = release;
        this.developer = developer;
        this.publisher = publisher;
    }

    public Image getImageField() {
        return ImageField;
    }

    public void setImageField(Image imageField) {
        ImageField = imageField;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public float getSales() {
        return sales;
    }

    public void setSales(float sales) {
        this.sales = sales;
    }

    public int getSalesInt() {
        return salesInt;
    }

    public void setSalesInt(int salesInt) {
        this.salesInt = salesInt;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    //methods
    boolean nameMatches(String searchText) {
        if (game.equalsIgnoreCase(searchText)) {
            return true;
        }
        return false;
    }
    // implements custom serialize for
    //     transient posterImage field
    @Serial
    private void writeObject(ObjectOutputStream s) throws IOException {
        // write NON-transient fields
        s.defaultWriteObject();
        // write transient fields
        if (ImageField != null) {
            ImageIO.write(SwingFXUtils.fromFXImage(ImageField, null), "png", s);
        }
    }
    // implements custom deserialize for
//     transient posterImage field
    @Serial
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
// read NON-transient fields
        s.defaultReadObject();
        // read transient fields
        Image PcPoster = null;
        try {
            PcPoster = SwingFXUtils.toFXImage(ImageIO.read(s), null);
        } catch (Exception ex) {
            // do nothing
        }
        ImageField = PcPoster;
    }


    public String toString() {
        return " \n This game is " +  game + " which was released on " + release + " its sales are " + salesInt + "." + " It is a part of the series " + series + " which was developed by " + developer + " and published by " + publisher + ".";
    }
}