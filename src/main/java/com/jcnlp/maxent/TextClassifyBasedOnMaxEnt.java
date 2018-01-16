package com.jcnlp.maxent;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import opennlp.maxent.GIS;
import opennlp.maxent.GISModel;
import opennlp.maxent.io.GISModelWriter;
import opennlp.maxent.io.SuffixSensitiveGISModelReader;
import opennlp.maxent.io.SuffixSensitiveGISModelWriter;

import com.google.common.collect.Lists;
import com.jcnlp.io.IOUtil;
/**
 * 基于最大熵的文本分类
 * @author jc
 */
public class TextClassifyBasedOnMaxEnt {
  private static final String TRAIN_FILE = "G:\\trainFile.txt"; // 文件参考file/maxent/trainFile.txt
  private static final String MODEL_FILE = "G:\\maxentModel.bin.gz";
  
  public static void main(String[] args) throws IOException {
    trainAndSaveMode(TRAIN_FILE, MODEL_FILE);
    GISModel model = getModelByModelFile(MODEL_FILE);
    
    // 测试
    double[] result = model.eval(PlainTextEventStream.buildContext("上海 全部 酒店"));
    String bestOutcome = model.getAllOutcomes(result);
    System.out.println(bestOutcome);
  }
  
  /**
   * 加载模型
   * @throws IOException 
   */
  public static GISModel getModelByModelFile(String modelFile) throws IOException {
    return (GISModel) new SuffixSensitiveGISModelReader(new File(modelFile)).getModel();
  }
  
  /**
   * 训练以及保存模型
   * @throws IOException 
   */
  public static void trainAndSaveMode(String trainFile, String modelFile) throws IOException {
    List<String> trainSamplesText = IOUtil.readLines(trainFile, Charset.forName("GBK"));
    PlainTextEventStream stream = new PlainTextEventStream(samplesTextToSampleList(trainSamplesText));
    GISModel model = GIS.trainModel(stream, 100, 1, false, true);
    GISModelWriter writer = new SuffixSensitiveGISModelWriter(model, new File(modelFile));
    writer.persist();
    writer.close();
  }
  
  private static List<TrainSample> samplesTextToSampleList(List<String> samplesText) {
    List<TrainSample> trainSampleList = Lists.newArrayList();
    for (String str : samplesText) {
      trainSampleList.add(new TrainSample(str));
    }
    return trainSampleList;
  }
  
}
