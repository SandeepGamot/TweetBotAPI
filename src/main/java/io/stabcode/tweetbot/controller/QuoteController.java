package io.stabcode.tweetbot.controller;

import io.stabcode.tweetbot.model.Quote;
import io.stabcode.tweetbot.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class QuoteController
{
  @Autowired
  private QuoteService service;
  
  @RequestMapping("/init")
  public void init()
  {
     service.init();
  }
  @RequestMapping("/quotes")
  public List<Quote> getAllQuotes()
  {
    return service.getAllQuotes();
  }
  
  @RequestMapping("/quotes/{id}")
  public Quote getQuoteById(@PathVariable Long id)
  {
     Quote q = service.getQuoteById(id);
     if(q==null)
       throw new ResponseStatusException(HttpStatus.NOT_FOUND);
     return q;
  }
  
  @RequestMapping(method = RequestMethod.POST,value = "/quotes")
  public void addQuote(@RequestBody Quote quote)
  {
    service.addQuote(quote);
  }
  
  @RequestMapping(method = RequestMethod.DELETE,value = "/quotes/{id}")
  public void deleteQuote( @PathVariable  Long id)
  {
    service.deleteQuote(id);
  }
}
