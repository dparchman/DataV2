package com.example.datav2;


public class Main {
    public static void main(String[] args) throws Exception {
       // bestSellingPc.readAllData();
        bestSellingAllTime.readAllData();
        bestSellingAllTime.describebestSellingAllTime();
        bestSellingPc.readAllData();
        bestSellingPc.describeAllPC();

        /*
        System.out.println("Hello world!");
        ArrayList<bestSellingPc> PcGameSales;
        PcGameSales = new ArrayList<>();

        ArrayList<bestSellingAllTime> AllGameSales;
        AllGameSales = new ArrayList<>();

        LocalDate date1 = LocalDate.of (2011, 11, 18);
        LocalDate date2 = LocalDate.of (2013, 9, 17);
        LocalDate date3 = LocalDate.of (2017, 12, 20);
        LocalDate date4 = LocalDate.of (2011, 5, 16);

        bestSellingAllTime game1 = new bestSellingAllTime ("Minecraft", 300000000, "Minecraft", date1, "Mojang Studios", "Mojang Studios/Xbox Game Studios", "Multi-platform");
        bestSellingAllTime game2 = new bestSellingAllTime ("Grand Theft Auto V", 200000000,"Grand Theft Auto", date2,"Rockstar North",	"Rockstar Games", "Multi-platform");
        bestSellingPc pcgame1 = new bestSellingPc("PUBG", 42000000, "PUBG", date3, "PUBG Studios", "Krafton", "Sandbox, Survival");
        bestSellingPc pcgame2 = new bestSellingPc("Terraria", 32000000, "N/A", date4, "Re-Logic", "Re-Logic", "Action-Adventure");

        AllGameSales.add(game1);
        AllGameSales.add(game2);
        PcGameSales.add(pcgame1);
        PcGameSales.add(pcgame2);


        System.out.println("Let's Describe multiple game's and their details:");

        for (bestSellingPc pcgame : PcGameSales) {
          //  pcgame.describe();
            System.out.println(pcgame);
        }
        for (bestSellingAllTime game : AllGameSales) {
         //   game.describe();
            System.out.println(game);
        }

         */
    }
}
