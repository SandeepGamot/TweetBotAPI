package io.stabcode.tweetbot.service;

import io.stabcode.tweetbot.model.Quote;
import io.stabcode.tweetbot.repository.QuoteRepository;
import io.stabcode.tweetbot.util.DataPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service public class QuoteService
{
  @Autowired private QuoteRepository quoteRepository;
  
  //get:"/topics"
  public List<Quote> getAllQuotes()
  {
    List<Quote> list = new ArrayList<>();
    quoteRepository.findAll().forEach(list::add);
    return list;
  }
  
  public Quote getQuoteById(Long id)
  {
    return quoteRepository.findById(id).orElse(null);
  }
  
  public void addQuote(Quote quote)
  {
    quoteRepository.save(quote);
  }
  
  public void deleteQuote(Long id)
  {
    quoteRepository.deleteById(id);
  }
}
