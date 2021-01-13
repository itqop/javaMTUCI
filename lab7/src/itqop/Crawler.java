package itqop;
import java.io.*;
import java.net.*;
import java.util.LinkedList;


public class Crawler {

    static LinkedList <URLDepthPair> findLink = new LinkedList <URLDepthPair>();
    static LinkedList <URLDepthPair> viewedLink = new LinkedList <URLDepthPair>();

    public static void showResult(LinkedList<URLDepthPair> viewedLink)
    {
        for (URLDepthPair c : viewedLink) System.out.println(c.getURL() + " "+c.getDepth());
    }
    public static void Process(String pair, int maxDepth) throws IOException
    {
        findLink.add(new URLDepthPair(pair, 0));
        while (!findLink.isEmpty())
        {
            URLDepthPair currentPair = findLink.removeFirst();
            if(currentPair.URL.equals(URLDepthPair.URL_PREFIX)){continue;}
            if (currentPair.depth < maxDepth)
            {
                Socket my_socket = new Socket(currentPair.getHost(), 80);
                my_socket.setSoTimeout(5000);
                try
                {
                    BufferedReader in = new BufferedReader(new InputStreamReader(my_socket.getInputStream()));
                    PrintWriter out = new PrintWriter(my_socket.getOutputStream(), true);
                    out.println("GET " + currentPair.getPath() + " HTTP/1.1");
                    out.println("Host: " + currentPair.getHost());
                    out.println("Connection: close");
                    out.println();
                    String line;
                    while ((line = in.readLine()) != null)
                    {
                        if (line.indexOf(currentPair.URL_PREFIX) != -1 && line.indexOf('"') != -1)
                        {
                            StringBuilder currentLink = new StringBuilder();
                            int i = line.indexOf(currentPair.URL_PREFIX);
                            while (line.charAt(i) != '"' && line.charAt(i) != ' ')
                            {
                                if (line.charAt(i) == '<')
                                {
                                    currentLink.deleteCharAt(currentLink.length() - 1);
                                    break;
                                }
                                else
                                {
                                    currentLink.append(line.charAt(i));
                                    i++;
                                }
                            }
                            URLDepthPair newPair = new URLDepthPair(currentLink.toString(), currentPair.depth + 1);
                            if (currentPair.check(findLink, newPair) && currentPair.check(viewedLink, newPair) && !currentPair.URL.equals(newPair.URL))
                                findLink.add(newPair);
                        }
                    }
                    my_socket.close();
                }
                catch (SocketTimeoutException e)
                {
                    my_socket.close();
                }
            }
            viewedLink.add(currentPair);
        }
        showResult(viewedLink);
    }

}