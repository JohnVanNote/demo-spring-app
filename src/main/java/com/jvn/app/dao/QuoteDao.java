package com.jvn.app.dao;

import com.jvn.app.model.Quote;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QuoteDao {

  int insertQuote(UUID id, Quote quote);

  default int insertQuote(Quote quote) {
    UUID id = UUID.randomUUID();
    return insertQuote(id, quote);
  }

  List<Quote> selectAllQuotes();

  Optional<Quote> selectQuoteById(UUID id);

  int deleteQuoteById(UUID id);

  int updateQuoteById(UUID id, Quote quote);

}
