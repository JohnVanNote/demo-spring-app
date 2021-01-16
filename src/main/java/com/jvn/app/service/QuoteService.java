package com.jvn.app.service;

import com.jvn.app.dao.QuoteDao;
import com.jvn.app.model.Quote;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

  private final QuoteDao quoteDao;

  @Autowired
  public QuoteService(@Qualifier("postgres") QuoteDao quoteDao) {
    this.quoteDao = quoteDao;
  }

  public int addQuote(Quote quote) {
    return quoteDao.insertQuote(quote);
  }

  public List<Quote> getAllQuotes() {
    return quoteDao.selectAllQuotes();
  }

  public Optional<Quote> getQuoteById(UUID id) {
    return quoteDao.selectQuoteById(id);
  }

  public int deleteQuoteById(UUID id) {
    return quoteDao.deleteQuoteById(id);
  }

  public int updateQuoteById(UUID id, Quote newQuote) {
    return quoteDao.updateQuoteById(id, newQuote);
  }

}
