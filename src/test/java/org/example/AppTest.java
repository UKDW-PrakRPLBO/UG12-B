package org.example;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testRegister(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;

        try {
            System.setOut(printStream);

            Stockbit stockbit = new Stockbit();
            Investor investor1 = new Investor("Mika Osborn","mikaosborn","osbornmika");
            stockbit.register(investor1);

            System.setOut(originalOut);
            printStream.close();

            String capturedOutput = outputStream.toString();


            assertEquals("Registrasi akun atas nama Mika Osborn sukses!", capturedOutput.trim());


        } finally {
            printStream.close();
        }

    }

    @Test
    public void testBerhasilLogin(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;

        try {
            System.setOut(printStream);

            Stockbit stockbit = new Stockbit();
            Investor investor1 = new Investor("Kevin Doyle","kevindoyle","doylekevin");

            stockbit.register(investor1);
            String capturedOutput = outputStream.toString();

            stockbit.login("kevindoyle","doylekevin");
            capturedOutput = outputStream.toString();


            System.setOut(originalOut);
            printStream.close();
            String expectedOutput = "Login berhasil!";

            assertTrue(capturedOutput.contains(expectedOutput));


        } finally {
            printStream.close();
        }

    }

    @Test
    public void testGagalLogin(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;

        try {
            System.setOut(printStream);

            Stockbit stockbit = new Stockbit();
            Investor investor1 = new Investor("Mika Osborn","mikaosborn","osbornmika");

            stockbit.register(investor1);
            String capturedOutput = outputStream.toString();

            stockbit.login("dikitole","tolediki");
            capturedOutput = outputStream.toString();


            System.setOut(originalOut);
            printStream.close();
            String expectedOutput = "Username/password Anda salah!";

            assertTrue(capturedOutput.contains(expectedOutput));


        } finally {
            printStream.close();
        }

    }

    @Test
    public void testPrintNota(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        Saham saham1 = new Saham("BELI",4330);
        Saham saham2 = new Saham("ANTM",2530);

        try {
            System.setOut(printStream);

            Stockbit stockbit = new Stockbit();
            Investor investor1 = new Investor("kevin doyle","kevindoyle","doylekevin");

            stockbit.register(investor1);
            stockbit.login("kevindoyle","doylekevin");
            stockbit.orderBeli(saham1, 1);
            stockbit.orderBeli(saham2,2);

            String capturedOutput = outputStream.toString();

            stockbit.printPortfolio();
            capturedOutput = outputStream.toString();


            System.setOut(originalOut);
            printStream.close();
            String expectedOutput = "BELI";
            String expectedOutput2 = "506000";
            String expectedOutput3 = "Total Investasi: Rp939000";

            assertTrue(capturedOutput.contains(expectedOutput));
            assertTrue(capturedOutput.contains(expectedOutput2));
            assertTrue(capturedOutput.contains(expectedOutput3));


        } finally {
            printStream.close();
        }

    }

    @Test
    public void testBerhasilJual(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        Saham saham1 = new Saham("BELI",4330);

        try {
            System.setOut(printStream);

            Stockbit stockbit = new Stockbit();
            Investor investor1 = new Investor("Kevin Doyle","kevindoyle","doylekevin");

            stockbit.register(investor1);
            stockbit.login("kevindoyle","doylekevin");
            stockbit.orderBeli(saham1,2);
            String capturedOutput = outputStream.toString();

            stockbit.orderJual(saham1,1);
            capturedOutput = outputStream.toString();


            System.setOut(originalOut);
            printStream.close();
            String expectedOutput = "Order jual BELI sebanyak 1 lot sukses!";

            assertTrue(capturedOutput.contains(expectedOutput));


        } finally {
            printStream.close();
        }

    }

    @Test
    public void testGagalJual(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        Saham saham1 = new Saham("BELI",4330);

        try {
            System.setOut(printStream);

            Stockbit stockbit = new Stockbit();
            Investor investor1 = new Investor("Kevin Doyle","kevindoyle","doylekevin");

            stockbit.register(investor1);
            stockbit.login("kevindoyle","doylekevin");
            stockbit.orderBeli(saham1,2);
            String capturedOutput = outputStream.toString();

            stockbit.orderJual(saham1,10);
            capturedOutput = outputStream.toString();


            System.setOut(originalOut);
            printStream.close();
            String expectedOutput = "Order jual gagal!";

            assertTrue(capturedOutput.contains(expectedOutput));


        } finally {
            printStream.close();
        }

    }




}
