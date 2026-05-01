class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();

        for(String ele : tokens){

            if(ele.equals("+") || ele.equals("-") || ele.equals("/") || ele.equals("*")){

                int b=stack.pop();
                int a = stack.pop();

                int result = 0;

                switch (ele){
                    case "+":
                    result = a+b;
                    break;

                    case "-":
                    result = a-b;
                    break;

                    case "/":
                    result = a/b;
                    break;

                    case "*":
                    result = a*b;
                    break;
                

                }
                stack.push(result);
            }
            else{
                stack.push(Integer.parseInt(ele));
            }
        }
        return stack.pop();
        
    }
}