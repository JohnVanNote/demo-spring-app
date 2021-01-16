package com.jvn.app.dao;

import com.jvn.app.model.Quote;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository("fakeDao")
public class QuoteFakeDataAccessService implements QuoteDao {

  private static List<Quote> DB = new ArrayList<>();

  @Override
  public int insertQuote(UUID id, Quote quote) {
    DB.add(new Quote(id, quote.getContent()));
    return 1;
  }

  @Override
  public List<Quote> selectAllQuotes() {
    return DB;
  }

  @Override
  public Optional<Quote> selectQuoteById(UUID id) {
    return DB.stream()
        .filter(quote -> quote.getId().equals(id))
        .findFirst();
  }

  @Override
  public int deleteQuoteById(UUID id) {
    Optional<Quote> quoteMaybe = selectQuoteById(id);
    if (quoteMaybe.isPresent()) {
      DB.remove(quoteMaybe.get());
      return 1;
    }
    return 0;
  }

  @Override
  public int updateQuoteById(UUID id, Quote newQuote) {
    return selectQuoteById(id)
        .map(p -> {
          int indexOfPersonToUpdate = DB.indexOf(p);
          if (indexOfPersonToUpdate >= 0) {
            deleteQuoteById(id);
            insertQuote(id, newQuote);
            return 1;
          }
          return 0;
        }).orElse(0);
  }

}
