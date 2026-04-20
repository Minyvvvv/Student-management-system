public class test {
    public static void main(String[] args) {
        // 准备一个乱序的成绩数组
        double[] scores = {85.5, 92.0, 78.5, 88.0, 70.0};

        System.out.println("排序前：");
        printArray(scores);

        // 调用排序方法（直接修改原数组）
        Calculator.scoreRanking(scores);

        System.out.println("排序后（降序）：");
        printArray(scores);
    }

    // 辅助方法：打印数组
    public static void printArray(double[] arr) {
        for (double v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}