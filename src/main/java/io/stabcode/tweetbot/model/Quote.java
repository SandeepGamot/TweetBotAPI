package io.stabcode.tweetbot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quote
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String quote;
  
  public Quote()
  {
  }
  
//  public Quote(long id, String quote)
//  {
//    this.id = id;
//    this.quote = quote;
//  }
  
  public Quote(String quote)
  {
    this.quote = quote;
  }
  
  public long getId()
  {
    return id;
  }
  
  public String getQuote()
  {
    return quote;
  }
  
  public void setQuote(String quote)
  {
    this.quote = quote;
  }
}
