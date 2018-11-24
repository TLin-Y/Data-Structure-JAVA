import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


public class BinaryOddonacciCalculator      //Binary recursion method
{
    private static int CountExecutedTime = 0; //Initial executed time value as zero
    public static long BinaryOddonacci(int input)  //Set a long type method BinaryOddonaci
    {
        long OddonacciNumber;                       //Input default value = 0
        CountExecutedTime++;

        if (input < 1)                          //Output Warning for input less than 1
        {
            OddonacciNumber = 0;
            System.out.print("Warning: the input should be integer and >=1");
            return OddonacciNumber;             //return a empty value
        }
        else
            if(input == 1 || input == 2 ||input == 3)       //Generate initial value {1,1,1}
            {
                OddonacciNumber = 1;
            }
            else                                            //Generate number for n>3
            {
                OddonacciNumber = BinaryOddonacci(input-1) + BinaryOddonacci(input-2) + BinaryOddonacci(input-3);
            }

            return OddonacciNumber;                         //Return current Onumber

    }

    public static void main(String[] args)
    {
        int n;
        Scanner inputvalue = new Scanner(System.in);            //user input
        System.out.print("Binary Oddonacci numbers Calculator\n"+"Enter the value:");
        n = inputvalue.nextInt();
        long result = BinaryOddonacci(n);                       //Extract result
        String Numrecord = "Oddonacci("+n+") Number Calculation Result:\n\n"+result;
        System.out.println(Numrecord);
        String Timerecord = "\nMethod executed " + CountExecutedTime + " times.";
        System.out.println(Timerecord);
        write("E:\\BinaryTimeRecord.txt",Numrecord+"\r\n");        //Output .txt time record as require
        write("E:\\BinaryTimeRecord.txt",Timerecord+"\r\n");        //Output .txt time record as require
    }


    public static void write(String fileName, String content) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, true); //.txt writer
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}