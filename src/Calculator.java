public class Calculator {
    //取平均值方法
    public static double getAverage(double[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        double sum = 0;
        for (double v : arr) {
            sum += v;
        }

        return sum/arr.length;
    }

    //计算总分
    public static double getSum(double arr[]){
        if (arr == null || arr.length == 0){
            return 0;
        }
        double sum = 0;
        for (double v : arr){
            sum += v;
        }

        return  sum;
    }

    //GPA计算(需要成绩转绩点)
    //GPA = ∑ (课程绩点 × 课程学分) ÷ ∑ 课程总学分
    public static double calculateGPA(double[] grades, double[] credits){
        if (grades == null || credits == null || grades.length != credits.length){
            return 0;
        }

        double totalPoints = 0;
        double totalCredits = 0;

        for (int i = 0; i < grades.length; i++) {
            double gpaPoints = convertGP(grades[i]);
            totalPoints += gpaPoints * credits[i];
            totalCredits += credits[i];
        }
        if (totalCredits == 0){
            return 0;
        }
        return totalPoints / totalCredits;
    }

    private static double convertGP(double grade){
            if (grade >= 90 && grade <= 100){
                return 4.0;//A
            } else if (grade >= 85 && grade <= 89) {
                return 3.7;//A-
            }else if (grade >= 82 && grade <= 84){
                return 3.3;//B+
            }else if (grade >= 78 && grade <= 81){
                return 3.0;//B
            }else if (grade >= 75 && grade <= 77){
                return 2.7;//B-
            }else if (grade >= 72 && grade <= 74){
                return 2.3;//C+
            }else if (grade >= 68 && grade <= 71){
                return 2.0;//C
            }else if (grade >= 60 && grade <= 67){
                return 1.0;//D
            }else                                {
                return 0;//F
            }
    }

    //成绩排名
    public static double[] scoreRanking(double[] arr) {
        double[] copy = arr.clone();

        for (int i = 0; i < copy.length - 1; i++) {
            for (int j = 0; j < copy.length - 1 - i; j++) {

                if (copy[j] < copy[j + 1]) {
                    double temp = copy[j];
                    copy[j] = copy[j + 1];
                    copy[j + 1] = temp;
                }
            }
        }
        return copy;
    }
}
