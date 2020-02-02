package io.stabcode.tweetbot.util;

import io.stabcode.tweetbot.model.Quote;
import io.stabcode.tweetbot.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseInit implements CommandLineRunner
{
  @Autowired private QuoteRepository repository;
  
  @Override public void run(String... args) throws Exception
  {
    List<Quote> list = DataPopulator.getDataList();
    list.forEach(repository::save);
  }
}
