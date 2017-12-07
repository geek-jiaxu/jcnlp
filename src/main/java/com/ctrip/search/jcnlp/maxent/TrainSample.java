package com.ctrip.search.jcnlp.maxent;

/**
 * 训练样本
 * @author jc
 */
public class TrainSample {
  public String classValue;    // 列表
  public String featureValues; // 特征s文本，“上海 东方明珠”

  public TrainSample(String sampleText) {
    int index = sampleText.indexOf(" : ");
    this.classValue = sampleText.substring(0, index);
    this.featureValues = sampleText.substring(index + 3, sampleText.length());
  }
  
  public TrainSample(String classValue, String tefeatureValuesxt) {
    this.classValue = classValue;
    this.featureValues = tefeatureValuesxt;
  }
  
}