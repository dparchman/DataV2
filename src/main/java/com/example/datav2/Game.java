package com.example.datav2;

import java.time.LocalDate;
public class Game {

    // fields
    private String game;
    private float sales;
    private String series;
    private LocalDate release;
    private String developer;
    private String publisher;


    public Game(String game, float sales, String series, LocalDate release, String developer, String publisher) {

        this.game = game;
        this.sales = sales;
        this.series = series;
        this.release = release;
        this.developer = developer;
        this.publisher = publisher;


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

    public void setSales(int sales) {
        this.sales = sales;
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


    public String toString() {
        return " \n This game is " +  game + " which was released on " + release + " its sales are " + sales + "." + " It is a part of the series " + series + " which was developed by " + developer + " and published by " + publisher + ".";
    }
}