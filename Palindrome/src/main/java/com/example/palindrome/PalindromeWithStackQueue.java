package com.example.palindrome;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class PalindromeWithStackQueue {

    /**
     * Implement a method that uses a Stack and a Queue
     * to determine whether the input string is a palindrome.
     * Palindromes read the same forwards and backwards,
     * ignoring case and non-alphanumeric characters.
     * Use Stack and Queue provided by Java's standard library.
     */
    public static boolean isPalindrome(String s)
    {
        // Validate input
        if (s == null) {
            throw new IllegalArgumentException("Input string must not be null");
        }

        // Normalize: remove non-alphanumeric and lowercase
        String normalized = normalize(s);

        // Use stack (LIFO) and queue (FIFO) to compare order
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Fill both structures with the normalized characters
        for (char c : normalized.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        // Pop from stack and remove from queue and compare
        while (!queue.isEmpty()) {
            Character fromStack = stack.pop();
            Character fromQueue = queue.remove();
            if (!fromStack.equals(fromQueue)) {
                return false; // mismatch -> not a palindrome
            }
        }
        return true; // all matched -> palindrome
    }

    // Optional helper method for normalization
    public static String normalize(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}
