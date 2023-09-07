import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File workingDirectory = new File(System.getProperty("user.dir"));
        File selectedFile;
        String name, desc, ID;
        double cost;

        String rec = "";
        ArrayList<Product> productList = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();
        try
        {

            chooser.setCurrentDirectory(workingDirectory);
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while(reader.ready())
                {
                    rec = reader.readLine();
                    lines.add(rec);
                }
                reader.close();

                System.out.printf("\n%-15s%-20s%-20s%-6s", "Name", "Desc", "ID", "Cost");
                System.out.println();
                for(int i =0; i<62; i++)
                {
                    System.out.printf("-");
                }
                System.out.println();

                String[] fields;
                for(String line : lines)
                {
                    fields = line.split(",");
                    if(fields.length == 4)
                    {
                        ID = fields[2].trim();
                        name = fields[0].trim();
                        desc = fields[1].trim();
                        cost = Double.parseDouble(fields[3].trim());

                        Product product = new Product(ID, name, desc, cost);
                        productList.add(product);
                    }else {
                        System.out.println("\nThere may be a corrupt: " + line);
                    }
                }
            }else {
                System.out.println("Failed to read a file");
                System.exit(0);
            }
            for(Product p : productList)
            {
                System.out.println(p.toCSVDataRecord());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}