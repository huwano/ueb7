import First.CommandLineInterface;
import Second.Consumer;
import Second.Producer;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CommandLineInterface cli = new CommandLineInterface();
        cli.start();
    }
    public static void conPro() {
        System.out.println("Bitte wähle zwischen 1.Fifo oder 2.Natürliche Reihenfolge");

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

    }
}