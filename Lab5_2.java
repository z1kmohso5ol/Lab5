import java.net.URL;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Lab5_2 {
    public static void readAllByByte(InputStream in) throws IOException {
        while (true) {
            int oneByte = in.read();
            if (oneByte != -1) {
                System.out.print((char)oneByte);
            }
            else {
                System.out.print("\n" + "end");
                break;
            }
        }}
    public static void main(String[] args) throws IOException {
        try {
            InputStream inFIle = new FileInputStream("C:/tmp/text.txt");
            readAllByByte(inFIle);
            System.out.print("\n\n\n");
            inFIle.close();

            InputStream inUrl = new URL("http://google.com").openStream();
            readAllByByte(inUrl);
            System.out.print("\n\n\n");
            inUrl.close();

            InputStream inArray = new ByteArrayInputStream(new byte [] {7,9,3,7,4});
            readAllByByte(inArray);
            System.out.print("\n\n\n");
            inArray.close();
        }
        catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }
    }
}

