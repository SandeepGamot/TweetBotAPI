package io.stabcode.tweetbot.util;

import io.stabcode.tweetbot.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataPopulator
{
  @Autowired
  private static ResourceLoader loader;
  
  public static List<Quote> getDataList()
  {
    ArrayList<Quote> list = new ArrayList<>();
    Resource resource = loader.getResource("classpath:resources/data/data.txt");
    try (Scanner sc = new Scanner(resource.getInputStream()))
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
