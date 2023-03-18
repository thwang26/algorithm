class Solution {
    public String solution(String s) {
        char[] ch = s.toCharArray();

        for(int i = 0 ; i < s.length() ; i++){
            if(ch[i]>='A'&&ch[i]<='Z') ch[i] -= 'A'-'a'; 
            if(i==0&&ch[i]>='a'&&ch[i]<='z') ch[i] += 'A'-'a';
            if(i!=0&&ch[i-1]==' '&&ch[i]>='a'&&ch[i]<='z') ch[i] += 'A'-'a';
        }
        String answer = new String(ch);
        return answer;
    }
}