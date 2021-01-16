package com.jvn.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import javax.validation.constraints.NotBlank;

public class Quote {

  private final UUID id;
  @NotBlank
  private final String content;

  public Quote(@JsonProperty("id") UUID id, @JsonProperty("content") String content) {
    this.id = id;
    this.content = content;
  }

  public UUID getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

}
