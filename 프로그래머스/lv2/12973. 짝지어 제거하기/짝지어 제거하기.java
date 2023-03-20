import java.util.Stack;
 
class Solution
{
    public int solution(String s)
    {
        Stack<Character> st = new Stack<Character>();
        char c;

        int i = 0;
        while(i < s.length()){
            c = s.charAt(i);
            i++;
            if(!st.isEmpty()&&st.peek()==c) st.pop();
            else st.push(c);    
        }

        return st.isEmpty() ? 1 : 0;
    }
}