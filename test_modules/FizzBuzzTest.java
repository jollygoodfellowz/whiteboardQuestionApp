public class FizzBuzzTest {

    public static void main(String[] args) {

        FizzBuzz test = new FizzBuzz();

        for(int i = 1; i < 101; i++) {
            System.out.print(test.multiplesof3and5(i) + ",");
        }
    }
}

