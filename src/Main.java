
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    //predetermined names for Tailors
    static String[] names = {"Ali", "Hasan", "Hosein", "Taghi", "Naghi", "Naser", "Kamal", "Mohammad", "Mojtaba"};

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter tailors count:");
        int tailorsCount = scanner.nextInt();       //up to 9 names

        // Tailor's data
        ArrayList<Tailor> tailors = new ArrayList<>(tailorsCount);
        for (int i = 0; i < tailorsCount; i++) {
            tailors.add(new FiroozSon(names[i % names.length]));   //up to 9 distinct names
        }

        new Secretary(tailors).start();
    }
}
