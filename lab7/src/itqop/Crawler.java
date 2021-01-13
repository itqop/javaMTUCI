package itqop;
import java.io.*;
import java.net.*;
import java.util.LinkedList;

public class Crawler {

    static LinkedList <URLDepthPair> findLink = new LinkedList <URLDepthPair>();//найденные
    static LinkedList <URLDepthPair> viewedLink = new LinkedList <URLDepthPair>();//просмотренные

    public static void showResult(LinkedList<URLDepthPair> viewedLink)
    {//выводит список всех пар, которые были посещены
        for (URLDepthPair c : viewedLink) System.out.println("Depth : "+c.getDepth() + "\tLink : "+c.getURL());
    }
    public static  void request(PrintWriter out,URLDepthPair pair) throws MalformedURLException //http запрос
    {//исключение - часть java api (если адрес не так начинается)
        out.println("GET " + pair.getPath() + " HTTP/1.1");
        out.println("Host: " + pair.getHost());
        out.println("Connection: close");
        out.println();
        out.flush();
    }
    public static void Process(String pair, int maxDepth) throws IOException
    {
        findLink.add(new URLDepthPair(pair, 0));
        while (!findLink.isEmpty())
        {
            URLDepthPair currentPair = findLink.removeFirst();
            if(currentPair.URL.equals("http://")){continue;}
            if (currentPair.depth < maxDepth)
            {
                Socket my_socket = new Socket(currentPair.getHost(), 80);//создает сокет и уст. соединение с портом
                my_socket.setSoTimeout(5000);//уст. время ожидания в миллисекундах
                try
                {
                    BufferedReader in = new BufferedReader(new InputStreamReader(my_socket.getInputStream()));//возращает сроку связ с сокет (данные с другой стороны соединения)
                    //Теперь in имеет тип InputStreamReader, который может читать символы из
                    //сокета (Socket)
                    PrintWriter out = new PrintWriter(my_socket.getOutputStream(), true);//отправлять данные на другую стороную соединения
                    request(out, currentPair);
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
                    my_socket.close();//закрывает сокет
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
    public static void main(String[] args)
    {
        String[] arg = new String[]{"http://mtuci.ru/","2"};
        try
        {
            Process(arg[0], Integer.parseInt(arg[1]));
        }
        catch (NumberFormatException | IOException e)
        {
            System.out.println("usage: java crawler " + arg[0] + " " + arg[1]);
        }
    }
}