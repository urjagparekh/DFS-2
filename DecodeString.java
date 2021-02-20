class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        
        Stack<Integer> StackInt = new Stack<>();
        Stack<String> StackStr = new Stack<>();
        
        String currStr = "";
        int currNum = 0;
        
        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                currNum = currNum*10 + (ch - '0') ;
            }else if(ch == '[') {
                StackInt.add(currNum);
                StackStr.add(currStr);
                
                currNum = 0;  //resetting it 
                currStr = "";
            }else if(ch == ']') {
                int popped = StackInt.pop();   
                
                String Temp = "";
                
                for(int x=0; x<popped; x++) {
                    Temp+= currStr;
                }
                
                currStr = StackStr.pop();
                currStr = currStr+Temp;
            } else { //just an alphabet
                currStr += ch;
            }
        }
        
        return currStr;
    }
}
