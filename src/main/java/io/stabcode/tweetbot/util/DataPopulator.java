package io.stabcode.tweetbot.util;

import io.stabcode.tweetbot.model.Quote;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataPopulator
{
  public static List<Quote> getDataList()
  {
    ArrayList<Quote> list = new ArrayList<>();
    
    try (Scanner sc = new Scanner(ResourceUtils.getFile("classpath:data/data.txt")))
    {
      sc.useDelimiter("\\s*<br>");
      
      while (sc.hasNext())
      {
        list.add(new Quote(sc.next().replaceAll("\r\n"," ".strip())));
      }
      
    } catch (IOException e)
    {
      e.printStackTrace();
    }
    return list;
  }
}
