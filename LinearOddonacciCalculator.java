import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;                           //Import Scanner tool for user input

    public class LinearOddonacciCalculator          //Create class
    {
        private static int CountExecutedTime = 0;   //Initial executed time value as zero
        private static int[] linearCalculator(int input) //Initial the calculator object for Oddonaci linear method
        {
            CountExecutedTime++;                    //Count the execute time for method

            if (input < 1)                          //Output Warning for input less than 1
            {
                int ResultArray[] = {0};
                System.out.print("Warning: the input should be integer and >=1");
                return (ResultArray);
            }

            if (input == 1)                         //Output first value '1' for resultarray
            {
                int ResultArray[] = {1};
                System.out.print(" 1");
                return (ResultArray);
            }

            if (input == 2)                         //Output second value '1,1' for resultarray
            {
                int ResultArray[] = {1,1};
                System.out.print(ResultArray[0]+" "+(ResultArray[1]));
                return (ResultArray);
            }

            if (input == 3)                         //Output third value '1,1,1' for resultarray
            {
                int ResultArray[] = {1,1,1};
                System.out.print(ResultArray[0]+" "+ResultArray[1]+" "+ResultArray[2]+" ");
                return (ResultArray);
            }

            else                   //Calculator for input larger than 3, #reference is textbook page 217.
            {
                int[] ResultArray;
                int first;
                int second;
                int third;
                ResultArray = linearCalculator(input - 1);    //Linear for n,n-1,n-2
                first = ResultArray[0];
                second = ResultArray[1];
                third = ResultArray[2];                             //Extract {n-1,n-2,n-3}
                System.out.print((first+second+third) + " ");       //Output Oddonacci value for 1 time run
                ResultArray[0] = first + second + third;
                ResultArray[1] = first;
                ResultArray[2] = second;                            //Save the current time Result as{n,n-1,n-2}
                return (ResultArray);		        //Tail of Oddonacci, which is Linear
                                            // this will return (Oddaonacci(n),Oddaonacci(n-1), Oddaonacci(n-2))
            }}


        public static void main(String[] args)
        {
            int n;
            Scanner inputvalue = new Scanner(System.in);
            System.out.print("Linear Oddonacci numbers Calculator\n"+"Enter the value:");
            n = inputvalue.nextInt();
            String Numrecord = "Oddonacci("+n+") Number Calculation Result:\n";
            System.out.println(Numrecord);
            String x = Arrays.toString(linearCalculator(n));
            String Timerecord = "\n\nMethod executed " + CountExecutedTime + " times.";
            System.out.println(Timerecord);
            write("E:\\LinearTimeRecord.txt",Numrecord);        //Output .txt time record as require
            write("E:\\LinearTimeRecord.txt",x+"\r\n");        //Output .txt time record as require
            write("E:\\LinearTimeRecord.txt",Timerecord+"\r\n");        //Output .txt time record as require
            //Output .txt time record as require
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
