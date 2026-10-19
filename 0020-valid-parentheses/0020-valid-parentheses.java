import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // If it's a closing bracket, check the stack
            if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return false;
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') return false;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') return false;
            } else {
                // If it's an opening bracket, push it to the stack
                stack.push(c);
            }
        }
        // If stack is empty, all opening brackets were matched
        return stack.isEmpty();
    }
}