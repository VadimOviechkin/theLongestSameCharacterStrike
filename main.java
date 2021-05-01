import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class main
    {


    public static void main(String[] args) throws IOException
        {

        char longestCharacter = 0;
        int counterByte = 1;
        int record = 0;
        byte longestCharacterByte;
        byte prevByte;
        byte nextByte;

        //Getting path to the file from user


        System.out.println("Type path to ur file: ");
        Scanner scan = new Scanner(System.in);

        String pathToTheFile = scan.next(); //creating new scan to get information from input stream(file)


        byte[] text = Files.readAllBytes(Paths.get(pathToTheFile)); //writing all characters in array in byte format 

        //algorithm of searching for the longest strike of same characters

        for (int i = 1; i < text.length; i++)
            {
            prevByte = text[i - 1];
            nextByte = text[i];

            if (nextByte == prevByte)
                {
                counterByte++;
                }
            else
                {
                counterByte = 1; //if previous byte isnt equal to the next one - counter resets
                }

            // if we get number higher than existing record, we write it down to the  

            if (counterByte > record)
                {
                record = counterByte;
                longestCharacterByte = text[i];
                longestCharacter = (char) longestCharacterByte; // converting byte format to character
                }
            }
        System.out.println("The longest strike of the same characters: " + record);
        System.out.println("That character is = "+ longestCharacter);

        }
    }