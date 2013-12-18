import java.util.Stack;
public class EvaluateReversePolishNotation{
    public static void main(String args[]){
        String[] tokens = {"0","3","/"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens){
        if(tokens == null || tokens.length == 0){
            return 0;
        }
       
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0 ; i < tokens.length; i++){
            int indicator = isOperator(tokens[i]);
            if(indicator > 0){
                // Be careful here: 
                // stack is LIFO, so the turns of the two integers are inversed here
                int a = stack.pop();
                int b = stack.pop();
                int back = 0;
                switch(indicator) {
                    // instead of a-b, it's b-a
                    case 1: back = b+a; break;
                    case 2: back = b-a; break;
                    case 3: back = b*a; break;
                    case 4: back = b/a; break;
                    default: break;
                }
                stack.push(back);
            } else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static int isOperator(String s){
        if(s.equals("+")){
            return 1;
        } else if(s.equals("-")){
            return 2;
        } else if(s.equals("*")){
            return 3;
        } else if(s.equals("/")){
            return 4;
        } else{
            return 0;
        }
    }


}
