package huawei;

import java.util.Scanner;

public class 自动曝光 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String line = scanner.nextLine();
            int res = solution(line);
            System.out.println(res);
        }
    }

    private static int solution(String line) {
        int k = 0;
        String[] split = line.split(" ");
        int[] img = new int[split.length];
        for (int i = 0; i < img.length; i++) {
            img[i] = Integer.parseInt(split[i]);
        }
        int avg = avg(img);
        int diff = avg - 128;
        int[] newImg = new int[img.length];
        System.arraycopy(img, 0, newImg, 0, img.length);
        if (diff > 0) {
            while (avg > 127){
                k--;
                avg = updateAndGetAvg(newImg, -1);
            }
        }

        if (diff < 0) {
            while (avg < 128){
                k++;
                avg = updateAndGetAvg(newImg, 1);
            }
        }

        return k;
    }

    private static int updateAndGetAvg(int[] newImg, int lambda) {
        for (int i = 0; i < newImg.length; i++) {
            if (newImg[i] + lambda > 255) {
                newImg[i] = 255;
            } else if (newImg[i] + lambda < 0) {
                newImg[i] = 0;
            } else {
                newImg[i] += lambda;
            }
        }
        return avg(newImg);
    }

    private static int avg(int[] img) {
        int sum = 0;
        for (int i : img) {
            sum += i;
        }
        return sum / img.length;
    }
}
