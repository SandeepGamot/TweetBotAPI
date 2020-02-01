package io.stabcode.tweetbot.repository;

import io.stabcode.tweetbot.model.Quote;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository extends CrudRepository<Quote,Long>
{
}
