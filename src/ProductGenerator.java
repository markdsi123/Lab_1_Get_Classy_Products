import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductGenerator {
    public static void main(String[] args) throws IOException {
        boolean done = false;
        Scanner in = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        String ID, name, desc;
        double cost;

        do {
            ID = SafeInput.getNonZeroLenString(in, "Please enter product's ID [6 digits]");
            name = SafeInput.getNonZeroLenString(in, "Please enter product's name");
            desc = SafeInput.getNonZeroLenString(in, "Please enter product's description ");
            cost = SafeInput.getRangedDouble(in,"Please enter product's price",0,9999);
            products.add(new Product(ID, name, desc, cost));

            done = SafeInput.getYNConfirm(in, "Are you done?");
        }while(!done);

        //Output what user has entered
        for (Product productRec : products)
        {
            System.out.println(productRec.toCSVDataRecord());
        }

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory + "\\src\\ProductDataText.txt");

        try{
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            //Create a file from an array list
            for(Product p : products)
            {
                writer.write(p.toCSVDataRecord());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data is written!");
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}