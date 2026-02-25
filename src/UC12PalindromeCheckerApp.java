import java.util.*;
interface PalindromeStrategy
{
    boolean checkPalindrome(String s);
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
class DequeStrategy implements PalindromeStrategy
{
    public boolean checkPalindrome(String s)
    {
        s = s.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) deque.addLast(c);
        while (deque.size() > 1)
        {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}
public class UC12PalindromeCheckerApp
{
    public static void main(String[] args)
    {
        String input = "A man a plan a canal Panama";
        PalindromeStrategy strategy;
        if (args.length > 0 && args[0].equalsIgnoreCase("deque")) {
            strategy = new DequeStrategy();
        }
        else
        {
            strategy = new StackStrategy();
        }
        if (strategy.checkPalindrome(input)) {
            System.out.println("\"" + input + "\" is a palindrome");
        }
        else
        {
            System.out.println("\"" + input + "\" is not a palindrome");
        }
    }
}
