package com.ctrip.search.jcnlp.viterbi;

/**
 * 乡村诊所示例
 * @author c_jia
 */
public class ViterbiDemo {

  /**
   * 村民有着非常理想化的特性，要么健康要么发烧。他们只有问诊所的医生的才能知道是否发烧。 
   */
  public enum Status { healthy, fever} 
  
  /**
   * 聪明的医生通过询问病人的感觉诊断他们是否发烧。村民只回答他们感觉正常、头晕或冷。
   */
  public enum Feel { normal, cold, dizzy }
  
  static int[] states = new int[] { Status.healthy.ordinal(), Status.fever.ordinal() };
  static int[] observations = new int[] { Feel.normal.ordinal(), Feel.cold.ordinal(), Feel.dizzy.ordinal() };
  
  /**
   * 起始概率start_probability 表示病人第一次到访时医生认为其所处的HMM状态，他唯一知道的是病人倾向于是健康的。
   */
  static double[] start_probability = new double[] {0.6, 0.4};
  
  /**
   * 转移概率transition_probability表示潜在的马尔可夫链中健康状态的变化。
   */
  static double[][] transititon_probability = new double[][]{
    {0.7, 0.3},
    {0.4, 0.6},
  };
  
  /**
   * 放射概率emission_probability表示每天病人感觉的可能性。假如他是健康的，50%会感觉正常。如果他发烧了，有60%的可能感觉到头晕。
   */
  static double[][] emission_probability = new double[][]{
    {0.5, 0.4, 0.1},
    {0.1, 0.3, 0.6},
  };
  
  public static void main(String[] args) {
    int[] result = Viterbi.compute(observations, states, start_probability, transititon_probability, emission_probability);
    for (int r : result) {
      System.out.print(Status.values()[r] + " ");
    }
    System.out.println();
  }
  
}
