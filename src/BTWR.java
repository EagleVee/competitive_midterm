import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Stack {
    private int a;
    private int b;

    public Stack(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }

    @Override
    public String toString() {
        return a + " " + b;
    }
}

class NumberComparator implements Comparator<Stack> {
    @Override
    public int compare(Stack current, Stack other) {
        return other.getA() - current.getA();
    }
}

public class BTWR {

    static int getMaxHeight(int num, int[] a, int[] b) {
        int maxHeight = 1;
        ArrayList<Stack> stack = new ArrayList<Stack>();

        for (int i = 0; i < num; i++) {
            stack.add(new Stack(a[i], b[i]));
        }

        stack.sort(new NumberComparator());

        for (int i = 0; i < num; i++) {
            int height = 0;
            int currentB = stack.get(i).getB();
            for (int j = i + 1; j < num; j++) {
                if (stack.get(j).getB() < currentB) {
                    currentB = stack.get(j).getB();
                    height += 1;
                }
            }

            if (height > maxHeight) {
                maxHeight = height;
            }

        }

        return maxHeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] stackA = new int[num];
        int[] stackB = new int[num];

        for (int i = 0; i < num; i++) {
            stackA[i] = sc.nextInt();
            stackB[i] = sc.nextInt();
        }

        int maxHeight = getMaxHeight(num, stackA, stackB);
        System.out.println(maxHeight);
    }
}
