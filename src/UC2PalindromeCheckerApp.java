public class UC2PalindromeCheckerApp
{
    public static void main(String[] args)
    {
        String word = "madam";
        System.out.println("Checking word: " + word);
        String reversed = new StringBuilder(word).reverse().toString();
        if (word.equals(reversed))
        {
            System.out.println("Result: \"" + word + "\" is a palindrome.");
        }
        else
        {
            System.out.println("Result: \"" + word + "\" is NOT a palindrome.");
        }
        System.out.println("Program finished.");
    }
}