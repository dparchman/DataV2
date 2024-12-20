package com.example.datav2;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;



public class bestSellingPc extends Game implements Serializable {
  private static final long serialVersionUID = 1L;
  private String genre;
  private static ArrayList<bestSellingPc> allPcGames = new ArrayList<bestSellingPc>();

  public bestSellingPc(String game, float sales, String series, LocalDate release, String developer, String publisher, String genre) {
    super(game, sales, series, release, developer, publisher, 0);
    this.genre = genre;
  }

  public static ArrayList<bestSellingPc> getAllPcGames() {
    return allPcGames;
  }

  public static void setAllPcGames(ArrayList<bestSellingPc> allPcGames) {
    bestSellingPc.allPcGames = allPcGames;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getToString() {
    return toString();
  }

  public String toString() {
    return " This game is " + getGame() + " which was released on " + getRelease() + " its sales are " + getSales() + "." + " It is a part of the series " + getSeries() + " which was developed by " + getDeveloper() + " and published by " + getPublisher() + "." + " The genre is " + genre + " . ";
  }

  static void readAllData() throws Exception {
    File dataFile = new File("src/main/java/com/example/datav2/bestSellingPc");
    Scanner textScanner = new Scanner(dataFile);
    textScanner.useDelimiter("\n");
    while (textScanner.hasNext()) {
      String fullRow = textScanner.nextLine();
      Scanner rowScanner = new Scanner(fullRow);
      rowScanner.useDelimiter("\t");
      String data1 = rowScanner.next();
      System.out.println("data1: " + data1);

      String data2 = rowScanner.next();
      data2 = data2.replace(" million", "");
      int locationofbracket = data2.indexOf("[");
      data2 = data2.substring(0, locationofbracket);

      float data2num = Float.parseFloat(data2);
      data2num = data2num * 1000000;


      //data2= data2.replaceAll(".", "");

      //data2 = data2.replaceAll("[]", "");
      //int data21 = Integer.parseInt(data2);
      System.out.println("data2: " + data2num);

      String data3 = rowScanner.next();
      System.out.println("data3: " + data3);

      String data4 = rowScanner.next();
      //String data41 = data4.substring(0, 2);
      //int locationofspace = data4.indexOf(" ");
      //String data42 = data4.substring(locationofspace+1);
      //String data43 = data41 + data42;
      int locationofbrackettwo = data4.indexOf("[");
      String data44 = data4;
      if (locationofbrackettwo > -1) {
        data44 = data4.substring(0, locationofbrackettwo);
      }

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy").withLocale(Locale.ENGLISH);

      LocalDate date = LocalDate.parse(data44, formatter);

      System.out.println(date);

      System.out.println("data4: " + data44);

      String data5 = rowScanner.next();
      System.out.println("data5: " + data5);

      String data6 = rowScanner.next();
      System.out.println("data6: " + data6);

      String data7 = data6;
      if (rowScanner.hasNext()) {
        data7 = rowScanner.next();
        System.out.println("data7: " + data7);
      }

      if (rowScanner.hasNext()) {
        String data8;
        data8 = rowScanner.next();
        data7 = data7 + data8;
        System.out.println("data7: " + data7);
      }


      String game = data1;
      float sales = data2num;
      String series = data3;
      LocalDate release = date;
      String developer = data6;
      String publisher = data7;
      String genre = data5;
//PUBG: Battlegrounds	42 million[1]	PUBG Universe	December 20, 2017	Battle royale	PUBG Studios	Krafton

      bestSellingPc pcGame = new bestSellingPc(game, sales, series, date, developer, publisher, genre);
      allPcGames.add(pcGame);

    }

  }

  static void describeAllPC() {
    for (bestSellingPc pcgame : allPcGames) {
      System.out.println(pcgame);
    }
  }

  static void saveData() throws Exception {
    FileOutputStream fileOut = new FileOutputStream("PcSave");
    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
    objectOut.writeObject(allPcGames);
    objectOut.close();
    fileOut.close();

  }
  static void restoreData() throws Exception {
    FileInputStream fileIn = new FileInputStream("PcSave");
    ObjectInputStream objectIn = new ObjectInputStream(fileIn);
    allPcGames = (ArrayList<bestSellingPc>) objectIn.readObject();
    objectIn.close();
    fileIn.close();
  }

}