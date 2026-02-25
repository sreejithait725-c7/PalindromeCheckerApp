import java.util.*;
interface PalindromeStrategy1
{
    boolean checkPalindrome(String s);
}
class IterativeStrategy implements PalindromeStrategy
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
class RecursiveStrategy implements PalindromeStrategy
{
    public boolean checkPalindrome(String s)
    {
        s = s.replaceAll("\\s+", "").toLowerCase();
        return check(s, 0, s.length() - 1);
    }
    private boolean check(String s, int start, int end)
    {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return check(s, start + 1, end - 1);
    }
}
class StackStrategy implements PalindromeStrategy
{
    public boolean checkPalindrome(String s)
    {
        s = s.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) stack.push(c);
        for (char c : s.toCharArray())
        {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}
public class UC13PalindromeCheckerApp
{
    public static void main(String[] args)
    {
        String input = "A man a plan a canal Panama";
        PalindromeStrategy[] strategies =
                {
                new IterativeStrategy(),
                new RecursiveStrategy(),
                new StackStrategy()
        };
        String[] names = {"IterativeStrategy", "RecursiveStrategy", "StackStrategy"};
        for (int i = 0; i < strategies.length; i++)
        {
            long start = System.nanoTime();
            boolean result = strategies[i].checkPalindrome(input);
            long end = System.nanoTime();
            System.out.println(names[i] + ": " + result + " (Time: " + (end - start) + " ns)");
        }
    }
}
