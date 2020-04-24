package io.stabcode.tweetbot.util;

import io.stabcode.tweetbot.model.Quote;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataPopulator
{
  public List<Quote> getDataList()
  {
    ArrayList<Quote> list = new ArrayList<>();
    Resource resource = new ClassPathResource("data/data.txt", this.getClass().getClassLoader());
    try (Scanner sc = new Scanner(resource.getInputStream()))
    {
      sc.useDelimiter("\\s*<br>");
      
      while (sc.hasNext())
      {
        list.add(new Quote(sc.next().replaceAll("\r\n"," ").strip()));
      }
      
    } catch (IOException e)
    {
      e.printStackTrace();
    }
    return list;
  }
}
