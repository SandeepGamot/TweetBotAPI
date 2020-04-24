package io.stabcode.tweetbot.model;

import javax.persistence.*;

@Entity
public class Quote
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Lob
  @Column(name="quote" , length=280)
  private String quote;
  
  protected Quote()
  {
  }
  
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
