import First.CommandLineInterface;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CommandLineInterface cli = new CommandLineInterface();
        cli.start();
    }
    public static void conPro() {
        Random ran = new Random();
        for(int i = 0; i<10000; i++)
        {
            if(ran.nextInt(2) > 0 ) {
                // Erzeugen eines neuen Integers durch den Producer und speichern
                // in einer Collection
            }else {
                // Entnehmen eines Integeres aus der Collection und Berechnung der
                // Quersumme durch den Consumer
            }
        }
    }
}