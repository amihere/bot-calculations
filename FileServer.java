import com.sun.net.httpserver.SimpleFileServer;
import com.sun.net.httpserver.SimpleFileServer.OutputLevel;
import java.net.InetSocketAddress;
import java.nio.file.Path;

class FileServer {
  public static void main(String[] args) {
    var addr = new InetSocketAddress(8080);
    var server = SimpleFileServer.createFileServer(
        addr,
        Path.of(System.getProperty("user.home") +
                "/Documents/Play/learn/envelope/txt"),
        OutputLevel.INFO);
    server.start();
  }
}
