package com.ctrip.search.jcnlp.cn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * 中文简体、繁体转换
 * @author jc
 */
public class JianFan {
  
  private static final String ZH2HANS_FILE = "zh2Hans.properties";
  private static Properties charMap = new Properties();
  private static Set<String> conflictingSets  = Sets.newHashSet();

  private JianFan() {}
  
  /**
   * 加载简繁体映射关系
   */
  private void loadJianFanMappers(String file) {
    InputStream is = getClass().getResourceAsStream(file);
    
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    try {
      charMap.load(reader);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (reader != null) { reader.close(); }
        if (is != null)     { is.close();     }
      } catch (IOException e) {}
    }
  }
  
  private void initializeHelper() {
    Map<String, Integer> stringPossibilities = Maps.newHashMap();
    Iterator<Object> iter = charMap.keySet().iterator();
  }

}
