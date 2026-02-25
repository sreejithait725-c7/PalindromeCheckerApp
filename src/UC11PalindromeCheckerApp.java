public class UC11PalindromeCheckerApp
{
    static class PalindromeChecker
    {
        public boolean checkPalindrome(String s)
        {
            s = s.replaceAll("\\s+", "").toLowerCase();
            int start = 0, end = s.length() - 1;
            while (start < end)
            {
                if (s.charAt(start) != s.charAt(end)) return false;
                start++;
                end--;
            }
            return true;
        }
    }
    public static void main(String[] args)
    {
        String input = "Level";
        PalindromeChecker checker = new PalindromeChecker();
        if (checker.checkPalindrome(input))
        {
            System.out.println("\"" + input + "\" is a palindrome");
        }
        else
        {
            System.out.println("\"" + input + "\" is not a palindrome");
        }
    }
}

