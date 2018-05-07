import java.io.*;
import java.net.*;

public class			echoserver
{
 public static void		main(String args[])
 {
  BufferedReader		inchan;
  DataOutputStream		outchan;
  ServerSocket			serv;
  Socket				client;
	 
  try
  {
    int port = Integer.parseInt(args[0]);
    serv = new ServerSocket(port); 
    while(true)
    {
      client = serv.accept();
      try
      {
        inchan = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outchan = new DataOutputStream(client.getOutputStream());
        while (true)
        {
          String command = inchan.readLine();
          if(command.equals("")) { System.out.println("Fin de connexion."); break;}
          outchan.writeChars(command);
        }
      }
      catch(IOException e) { System.err.println("I/O Error"); e.printStackTrace();}
      client.close();
    }
   }
   catch(Throwable t) {t.printStackTrace(System.err); }
  }
}

