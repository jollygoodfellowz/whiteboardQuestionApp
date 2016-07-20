public class Palindrome {

    public boolean isPalindrome(String pali) {
        if(pali == null) return false;
        if(pali.length() < 2) return false;


        String lowerPali = pali.toLowerCase();
        for(int i = 0, j = lowerPali.length()-1; i < j; i++, j--) {
            if(lowerPali.charAt(i) == ' ') i++;
            if(lowerPali.charAt(j) == ' ') j--;
            if(lowerPali.charAt(i) != lowerPali.charAt(j)) return false;
        }

        return true;
    }
}
