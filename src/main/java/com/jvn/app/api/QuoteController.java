package com.jvn.app.api;

import com.jvn.app.model.Quote;
import com.jvn.app.service.QuoteService;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/quote")
@RestController
public class QuoteController {

  private final QuoteService quoteService;

  @Autowired
  public QuoteController(QuoteService quoteService) {
    this.quoteService = quoteService;
  }

  @PostMapping
  public void addQuote(@Valid @NotNull @RequestBody Quote quote) {
    quoteService.addQuote(quote);
  }

  @GetMapping
  public List<Quote> getAllQuotes() {
    return quoteService.getAllQuotes();
  }

  @GetMapping(path = "/{id}")
  public Quote getQuoteById(@PathVariable("id") UUID id) {
    return quoteService.getQuoteById(id)
        .orElse(null);
  }

  @DeleteMapping(path = "{id}")
  public int deleteQuoteById(@PathVariable("id") UUID id) {
    return quoteService.deleteQuoteById(id);
  }

  @PutMapping(path = "{id}")
  public int updateQuoteById(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Quote quote) {
    return quoteService.updateQuoteById(id, quote);
  }

}
