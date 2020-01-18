import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RandomFileWriter {
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final char[] ch = ALPHA_NUMERIC_STRING.toCharArray();
    private static final java.util.concurrent.ThreadLocalRandom random = java.util.concurrent.ThreadLocalRandom.current();

    public static void main(String... x) {
        int input = Integer.parseInt(x[0]);
        long start = System.currentTimeMillis();
       BufferedWriter writer = null;
        try {
            File file = new File("Random.txt");
            file.createNewFile();
            writer = new BufferedWriter(new FileWriter(file, true), 327680);
            for (int length = 0; length <= input; length++) {
                writer.write(getRandomString(100)+"\n");
            }
            long end = System.currentTimeMillis();
            System.out.println((end - start) / 1000f + " seconds");
        }catch (IOException e){
            System.out.println("No File found"+e.getMessage());
        }catch (Exception e){
            System.out.println("Exception occurred "+e.getMessage());
        }finally {
            if (writer != null) {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getRandomString(int len) {
        char[] c = new char[len];
        for (int i = 0; i < len; i++) {
            c[i] = ch[random.nextInt(ch.length)];
        }
        return new String(c);
    }

}
