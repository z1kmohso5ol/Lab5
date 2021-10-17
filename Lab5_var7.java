import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class Lab5_var7 {
    public static void main(String[] args) throws IOException {
        try {
            File f1 = new File("C:\\Users\\321.txt");
            f1.createNewFile();
            Scanner sc = new Scanner(System.in, "cp1251");

            DataOutputStream wr =
                    new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));

            System.out.println("Сколько чисел типа double записать в файл?");
            int count = sc.nextInt();

            System.out.println("Введите числа: ");
            for (int i = 0; i < count; i++)
                wr.writeDouble(sc.nextDouble());
            wr.flush();
            wr.close();

            File f2 = new File("C:\\Users\\123.txt");
            f2.createNewFile();

            DataInputStream rd =
                    new DataInputStream(new FileInputStream(f1.getAbsolutePath()));
            wr = new DataOutputStream(new FileOutputStream(f2.getAbsolutePath()));
            try {
                double max = 0;
                while (true) {
                    double number = rd.readDouble();
                    for (int n = 0; n < count; n++) {
                        if ((double)number > 0 && (double)number>max)
                        max=(double)number;
                        {
                            wr.writeDouble(number);
                            wr.writeDouble(max);
                            System.out.println("Число " + (double)number);
                        }
                    }
                    System.out.println("max "+max);}
            }
            catch(EOFException e) {}
            wr.flush();
            wr.close();
            wr.close();
        }
        catch (IOException e) {
            System.out.println("End of file");
        }
    }

}
