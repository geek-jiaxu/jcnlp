package com.ctrip.search.jcnlp.ngram;

public class NGramDistanceTest {

  public void testNGramDistance() {
    NGramDistance ng = new NGramDistance();
    float score = ng.getDistance("baoshuta", "baochuta");
    System.out.println(score);
  }
  
}
