package com.tips.java15;

public class TextBlock {
    public static void main(String[] args) {
        var html = "<html>\n" +
            "    <body>\n" +
            "        <p>Hello, world</p>\n" +
            "    </body>\n" +
            "</html>";

        var html1 = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
              """;

        System.out.println(html);
        System.out.println(html1);
    }
}
