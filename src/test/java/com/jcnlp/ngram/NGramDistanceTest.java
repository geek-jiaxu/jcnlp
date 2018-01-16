package com.jcnlp.ngram;

import com.jcnlp.ngram.NGramDistance;

public class NGramDistanceTest {

  public void testNGramDistance() {
    NGramDistance ng = new NGramDistance();
    float score = ng.getDistance("baoshuta", "baochuta");
    System.out.println(score);
  }
  
}
