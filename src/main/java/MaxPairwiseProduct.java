import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MaxPairwiseProduct {

    private static String inputFromConsole(InputStream in) {
        String n = "";
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            n = bufferedReader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return n;
    }

    private static long maxPairWise(int[] numbers) {
        int len = numbers.length;
        int max_index1 = 0;
        int max_index2 = 0;

        for (int i = 0; i < len; ++i) {
            if (numbers[i] >= numbers[max_index1]) max_index1 = i;
        }

        for (int i = 0; i < len; i++) {
            if (max_index1 == i)
                continue;
            if (numbers[i] >= numbers[max_index2]) max_index2 = i;
        }

        return (long) numbers[max_index1] * numbers[max_index2];
    }

    private static long pairWiseByStream(int[] n) {
        int[] nums = Arrays.stream(n).sorted().toArray();
        return (long) nums[nums.length-1] * nums[nums.length - 2];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(inputFromConsole(System.in));
        int[] numbers = new int[n];

        String[] input = inputFromConsole(System.in).split(" ");

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        System.out.println(pairWiseByStream(numbers));
    }


}
