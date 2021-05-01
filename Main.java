import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main
{


    public static void main(String[] args) throws IOException
    {

        int counter_byte = 1;
        int record = 0;
        byte prev_byte;
        byte next_byte;


        System.out.println("Type path to ur file: ");
        Scanner scan = new Scanner(System.in);

        String path_to_the_file = scan.next();


        byte[] text = Files.readAllBytes(Paths.get(path_to_the_file));
        

        for (int i = 1; i < text.length; i++)
        {
            prev_byte = text[i - 1];
            next_byte = text[i];

            if (next_byte == prev_byte)
            {
                counter_byte++;
            } else
            {
                counter_byte = 1;
            }
            if (counter_byte > record)
            {
                record = counter_byte;
            }
        }
        System.out.println("The longest strike of the same characters: " + record);

    }
}