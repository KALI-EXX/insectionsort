package insertionSort;
import java.io.*;
import java.util.*;

public class FileSorter {

    public static int leng(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        int count = 0;
        while (br.readLine() != null) {
            count++;
        }
        br.close();
        return count;
    }

    public static List<Integer> number(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<Integer> numbers = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.trim().split("\\s+");
        for (String part : parts) {
        numbers.add(Integer.parseInt(part));
    }
        }

        br.close();
        return numbers;
    }

    public static List<Integer> sort(List<Integer> numbers) {
        List<Integer> numbersort = new ArrayList<>();

        for (int n : numbers) {
            boolean inserted = false;

            for (int i = 0; i < numbersort.size(); i++) {
                if (n < numbersort.get(i)) {
                    numbersort.add(i, n);
                    inserted = true;
                    break;
                }
            }

            if (!inserted) {
                numbersort.add(n);
            }
        }

        return numbersort;
    }

    public static void filegen(List<Integer> array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"));

        for (int value : array) {
            bw.write(value + "\n");
        }

        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("File name: ");
        String file = scanner.nextLine();

        int length = leng(file);
        List<Integer> numbers = number(file);

        long startTime = System.nanoTime();
        List<Integer> array = sort(numbers);
        long endTime = System.nanoTime();

        filegen(array);

        System.out.println("File sorted successfully.");
        System.out.printf("The sorting lasted %.5f seconds.\n",
                (endTime - startTime) / 1_000_000_000.0);

        scanner.close();
    }
}