/**
 *
 *  @author Piątkowski Marcin S16425
 *
 */

package zad4;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
	  Server server = new Server(2500);
	  server.run();
  }
}
