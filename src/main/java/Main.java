import First.CommandLineInterface;
import Second.Consumer;
import Second.Controler;
import Second.Producer;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controler controler = new Controler();
        controler.start();
        //CommandLineInterface cli = new CommandLineInterface();
       // cli.start();
    }
}