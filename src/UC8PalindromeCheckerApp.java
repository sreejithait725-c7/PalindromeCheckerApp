public class UC8PalindromeCheckerApp {
    static class Node
    {
        char data;
        Node next;
        Node(char data)
        {
            this.data = data;
            this.next = null;
        }
    }
    static class LinkedList
    {
        Node head;
        void add(char c)
        {
            Node newNode = new Node(c);
            if (head == null)
            {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        boolean isPalindrome()
        {
            if (head == null || head.next == null) return true;
            Node slow = head, fast = head;
            while (fast != null && fast.next != null)
            {
                slow = slow.next;
                fast = fast.next.next;
            }
            Node secondHalf = reverse(slow);
            Node firstHalf = head;
            while (secondHalf != null)
            {
                if (firstHalf.data != secondHalf.data) return false;
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }
            return true;
        }
        Node reverse(Node node)
        {
            Node prev = null, curr = node, next;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }
    public static void main(String[] args)
    {
        String input = "madam";
        LinkedList list = new LinkedList();
        for (char c : input.toCharArray())
        {
            list.add(c);
        }
        if (list.isPalindrome())
        {
            System.out.println(input + " is a palindrome");
        }
        else
        {
            System.out.println(input + " is not a palindrome");
        }
    }
}