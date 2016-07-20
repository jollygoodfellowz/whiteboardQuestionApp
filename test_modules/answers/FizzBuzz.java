public class FizzBuzz {
    public String multiplesof3and5(int x) {
        int three = x % 3;
        int five = x % 5;

        if(three == 0 && five == 0) return "FizzBuzz";
        if(three == 1) return "Fizz";
        if(five == 0) return "Buzz";
        return "";
    }
}
