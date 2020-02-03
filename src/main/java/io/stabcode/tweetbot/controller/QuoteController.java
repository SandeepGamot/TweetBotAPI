package io.stabcode.tweetbot.controller;

import io.stabcode.tweetbot.model.Quote;
import io.stabcode.tweetbot.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class QuoteController
{
  @Autowired
  private QuoteService service;
  
  @GetMapping("/")
  public String redirect()
  {
    return "redirect:/quotes";
  }
  @GetMapping("/quotes")
  @ResponseBody
  public List<Quote> getAllQuotes()
  {
    return service.getAllQuotes();
  }
  
  @GetMapping("/quotes/{id}")
  @ResponseBody
  public Quote getQuoteById(@PathVariable Long id)
  {
     Quote q = service.getQuoteById(id);
     if(q==null)
       throw new ResponseStatusException(HttpStatus.NOT_FOUND);
     return q;
  }
  
  @PostMapping("/quotes")
  public void addQuote(@RequestBody Quote quote)
  {
    service.addQuote(quote);
  }
  
  @DeleteMapping("/quotes/{id}")
  public void deleteQuote( @PathVariable  Long id)
  {
    service.deleteQuote(id);
  }
}
