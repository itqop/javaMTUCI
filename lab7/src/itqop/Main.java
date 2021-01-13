package itqop;

import java.io.IOException;

public class Main {

    public static void main(String[] args)
    {
        args = new String[]{"http://17ok.com/","2"};
        try
        {
            Crawler.Process(args[0], Integer.parseInt(args[1]));
        }
        catch (NumberFormatException | IOException e)
        {
            System.out.println("usage: java crawler " + args[0] + " " + args[1]);
        }
    }
}
