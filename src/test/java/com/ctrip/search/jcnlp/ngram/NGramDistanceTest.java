package com.ctrip.search.jcnlp.ngram;

import org.junit.Test;

public class NGramDistanceTest {

  @Test
  public void testNGramDistance() {
    NGramDistance ng = new NGramDistance();
    float score = ng.getDistance("baoshuta", "baochuta");
    System.out.println(score);
  }
  
}
