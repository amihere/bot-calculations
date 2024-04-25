import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class Operations {
  public static void main(String[] args) throws IOException {
    runContiguousReads();
  }

  static void runContiguousReads() throws IOException {
    long total = 0;
    File file;
    FileInputStream str;
    for (int i = 1; i <= 100; i++) {
      byte[] buffer = new byte[1024];

      file = new File("txt/me/in" + i + ".txt");

      long time = System.nanoTime();

      str = new FileInputStream(file);
      str.read(buffer);
      total += (System.nanoTime() - time);

      time = 0;
      str.close();
    }

    System.out.println(total / 100);
  }
}
