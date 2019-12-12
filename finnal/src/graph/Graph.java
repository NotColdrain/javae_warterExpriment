package graph;

import java.io.IOException;
//方法可以调用graph程序生成 "班级-借阅图书" 图表
class Graph{
    public static void run() throws IOException{
        try{
            Runtime.getRuntime().exec("graph.exe");
        }
        finally{
            System.out.println("生成图表成功!");
        }
    }
}

/**
 *
class Main{
    public static void main(String[] args) throws IOException{
        Graph.run();
    }
}
*/
