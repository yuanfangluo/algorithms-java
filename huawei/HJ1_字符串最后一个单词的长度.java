package huawei;

public class HJ1_字符串最后一个单词的长度 {

    public static void main(String[] args) {
      solution("");
    }

    static void solution(String str){
        String[] strs = str.split(" ");
        int len = strs[strs.length - 1].length();
        System.out.println(len);
    }
}
