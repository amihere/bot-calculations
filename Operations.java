import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class Operations {
  public static void main(String[] args) throws Exception {
    // runContiguousReadsMemory();
    runContiguousReadsDisk();
  }

  static void runContiguousReadsMemory() throws Exception {
    long total = 0;
    File file = new File("res/megabyte.txt");
    FileInputStream str = new FileInputStream(file);
    byte[] buffer = new byte[1048576];
    str.read(buffer);
    str.close();

    byte b;
    long time = System.nanoTime();
    for (int i = 0; i < 1048576; i++) {
      b = buffer[i];
    }
    total += (System.nanoTime() - time);

    System.out.println(total);
  }

  static void runContiguousReadsDisk() throws IOException {
    long total = 0;
    File file;
    FileInputStream str;
    for (int i = 1; i <= 100; i++) {
      byte[] buffer = new byte[1048576];

      long time = System.nanoTime();
      file = new File("res/me/in" + i + ".txt");
      str = new FileInputStream(file);
      str.read(buffer);
      total += (System.nanoTime() - time);

      time = 0;
      str.close();
    }

    System.out.println(total / 100);
  }
}
