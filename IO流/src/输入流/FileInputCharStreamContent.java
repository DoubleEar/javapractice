package 输入流;

import java.io.*;
import java.util.Scanner;

//读取有中文的内容
public class FileInputCharStreamContent {
  public static void main(String[] args) throws IOException {
      try (InputStream is = new FileInputStream("有中文的文件.txt")) {
          try (Reader reader = new InputStreamReader(is, "UTF-8")) {
              /*
              StringBuilder sb = new StringBuilder();
              while (true) {
                  int c = reader.read();
                  if (c == -1) {
                      break;
                  }

                  sb.append((char)c);
              }

              System.out.println(sb.toString());
              */

              char[] buffer = new char[1024];
              while (true) {
                  int len = reader.read(buffer);
                  if (len == -1) {
                      break;
                  }

                  for (int i = 0; i < len; i++) {
                      System.out.println(buffer[i]);
                  }
              }
          }
      }
  }

    /*
    public static void main(String[] args) throws IOException {
        try (InputStream is = new FileInputStream("有中文的文件.txt")) {
            try (Reader reader = new InputStreamReader(is, "UTF-8")) {
                try (Scanner scanner = new Scanner(reader)) {
                    while (scanner.hasNext()) {
                        System.out.println(scanner.next());
                    }
                }
            }
        }
    }
    */
}
