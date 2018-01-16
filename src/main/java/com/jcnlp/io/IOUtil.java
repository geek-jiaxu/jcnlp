package com.jcnlp.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.io.Files;

/**
 * 文件操作
 * @author c_jia
 */
public class IOUtil {
  
  /**
   * 文件读取为List<String>
   * @return 文件行列表
   */
  public static List<String> readLines(String path) throws IOException {
    if (Strings.isNullOrEmpty(path)) {
      throw new IllegalArgumentException("path can not be null.");
    }
    return Files.readLines(new File(path), Charsets.UTF_8);
  }
  
  /**
   * 文件读取为List<String>
   * @return 文件行列表
   */
  public static List<String> readLines(String path, Charset charSet) throws IOException {
    if (Strings.isNullOrEmpty(path)) {
      throw new IllegalArgumentException("path can not be null.");
    }
    charSet = (charSet == null) ? Charsets.UTF_8 : charSet;
    return Files.readLines(new File(path), charSet);
  }
  
  /**
   * 文件写入
   */
  @SuppressWarnings("deprecation")
  public static void writeLines(String fileName, List<String> contents) throws IOException {
    File newFile = new File(fileName);
    contents.forEach(content -> {
      try {
        Files.write((content + "\n"), newFile, Charset.forName("GBK"));
      } catch (IOException e) {
      }
    });
  }
  
}
