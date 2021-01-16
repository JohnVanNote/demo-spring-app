package com.jvn.app.dao;

import com.jvn.app.model.Quote;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository("postgres")
public class QuoteDataAccessService implements QuoteDao {

  @Override
  public int insertQuote(UUID id, Quote quote) {
    return 0;
  }

  @Override
  public List<Quote> selectAllQuotes() {
    return Arrays.asList(new Quote(UUID.randomUUID(), "FROM POSTGRES DB"));
  }

  @Override
  public Optional<Quote> selectQuoteById(UUID id) {
    return Optional.empty();
  }

  @Override
  public int deleteQuoteById(UUID id) {
    return 0;
  }

  @Override
  public int updateQuoteById(UUID id, Quote quote) {
    return 0;
  }
}
