package com.example.datav2;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class bestSellingAllTime extends Game {

    private String platform;
    private static ArrayList<bestSellingAllTime> allTimeGames = new ArrayList<bestSellingAllTime>();

    public bestSellingAllTime(String game, int sales, String series, String platform, LocalDate release, String developer, String publisher) {
        super(game, sales, series, release, developer, publisher);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String toString() {
        return " \n This game is " + getGame() + " which was released on " + getRelease() + " its sales are " + getSales() + "." + " It is a part of the series " + getSeries() + " which was developed by " + getDeveloper() + " and published by " + getPublisher() + " . ";
    }

    static void readAllData() throws Exception {
        File dataFile = new File("src/main/java/com/example/datav2/bestSellingAllTIme");
        Scanner textScanner = new Scanner(dataFile);
        textScanner.useDelimiter("\n");
        int lastLinesInt = 0;
        while (textScanner.hasNext()) {
            String fullRow = textScanner.nextLine();
            Scanner rowScanner = new Scanner(fullRow);
            rowScanner.useDelimiter("\t");
            String data1 = rowScanner.next();
            System.out.println("data1: " + data1);

            boolean missingNumber = false;
            String data2 = rowScanner.next();
            int data22;
            if (data2.charAt(1) < '0'
                    || data2.charAt(1) > '9') {
                data22 = lastLinesInt;
                missingNumber = true;
            } else {
                data2 = data2.replaceAll(",", "");
                data22 = Integer.parseInt(data2);
            }
            System.out.println("data2: " + data22);

            lastLinesInt = data22;

            String data3;
            if (!missingNumber) {
                data3 = rowScanner.next();
            } else {
                data3 = data2;
            }
            System.out.println("data3: " + data3);

            String data4 = rowScanner.next();
            System.out.println("data4: " + data4);

            String data5 = rowScanner.next();
            int locationofbrackettwo = data5.indexOf("[");
            String data55 = data5;
            if (locationofbrackettwo > -1) {
                data55 = data5.substring(0, locationofbrackettwo);
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy").withLocale(Locale.ENGLISH);
            LocalDate date = LocalDate.parse(data55, formatter);

            System.out.println("data5:" + date);

            String data6 = rowScanner.next();
            System.out.println("data6: " + data6);

            String data7 = rowScanner.next();
            System.out.println("data7: " + data7);


            String game = data1;
            int sales = data22;
            String series = data3;
            String platform = data4;
            LocalDate release = date;
            String developer = data6;
            String publisher = data7;

            bestSellingAllTime AllTimeGame = new bestSellingAllTime(game, sales, series, platform, release, developer, publisher);
            allTimeGames.add(AllTimeGame);
        }
    }

            static void describebestSellingAllTime () {
                for (bestSellingAllTime bestSellingAllTime : allTimeGames) {
                    System.out.println(bestSellingAllTime);

                }
            }
}
