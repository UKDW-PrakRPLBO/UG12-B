package org.example;

public class App 
{
    public static void main( String[] args )
    {
        Stockbit stockbit = new Stockbit();
        Saham saham1 = new Saham("LUPA",4330);
        Saham saham2 = new Saham("TOKEK",2530);
        Saham saham3 = new Saham("ILAP",3150);
        Saham saham4 = new Saham("TOKTOK",7375);
        System.out.println("----------Skenario 1: Registrasi Investor----------");
        Investor investor1 = new Investor("Kevin Doyle","kevindoyle","doylekevin");
        Investor investor2 = new Investor("ECOMMURZ","murzfam","pspsps");
        stockbit.register(investor1);
        stockbit.register(investor2);
        System.out.println("----------Skenario 2: Login Gagal----------");
        stockbit.login("martinschris","fixyou");
        System.out.println("----------Skenario 3: Login Berhasil (Username: kevindoyle)----------");
        stockbit.login("kevindoyle","doylekevin");
        System.out.println("----------Skenario 4: Print Portfolio Client #1----------");
        stockbit.orderBeli(saham1,2);
        stockbit.orderBeli(saham2,3);
        stockbit.printPortfolio();
        System.out.println("----------Skenario 5: Print Portfolio Client #2----------");
        stockbit.orderJual(saham2,4);
        stockbit.orderJual(saham2,1);
        stockbit.printPortfolio();
        System.out.println("----------Skenario 6: Print Portfolio Client #3----------");
        stockbit.orderJual(saham1,2);
        stockbit.printPortfolio();
        System.out.println("----------Skenario 7: Login Berhasil (Username: murzfam)----------");
        stockbit.login("murzfam","pspsps");
        System.out.println("----------Skenario 8: Print Portfolio Client #4----------");
        stockbit.orderBeli(saham3,2);
        stockbit.orderBeli(saham4,1);
        stockbit.printPortfolio();
    }
}
