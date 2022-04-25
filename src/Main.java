
import model.secretary.Secretary;
import model.tailor.FiroozSon;
import model.tailor.Tailor;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static sample_data.FiroozSonNames.tailorNamesData;

public class Main {

    //predetermined names for Tailors

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter tailors count:");
        int tailorsCount = scanner.nextInt();       //should be divisible to customer count

        // Tailor's data
        ArrayList<Tailor> tailors = new ArrayList<>(tailorsCount);
        for (int i = 0; i < tailorsCount; i++) {
            tailors.add(new FiroozSon(tailorNamesData[i % tailorNamesData.length]));   //up to 9 distinct names
        }

        new Secretary(tailors).start();
    }
}
