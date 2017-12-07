package com.ctrip.search.jcnlp.maxent;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import opennlp.model.Event;
import opennlp.model.EventStream;

public class PlainTextEventStream implements EventStream {

  private final Iterator<TrainSample> samples;

  public PlainTextEventStream(Collection<TrainSample> samples) {
    this.samples = samples.iterator();
  }

  public Event next() throws IOException {
    return createEvent(samples.next());
  }

  private Event createEvent(TrainSample sample) {
    String[] context = buildContext(sample.featureValues);
    return new Event(sample.classValue, context);
  }

  public boolean hasNext() throws IOException {
    return samples.hasNext();
  }

  public static String[] buildContext(String text) {
    List<String> tokens = Lists.newArrayList(Splitter.on(' ').split(text));
    return tokens.toArray(new String[tokens.size()]);
  }
  
}
