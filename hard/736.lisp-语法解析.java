/*
 * @lc app=leetcode.cn id=736 lang=java
 *
 * [736] Lisp 语法解析
 */

// @lc code=start
class Solution {
    public int evaluate(String expression) {
        return eval(expression, new HashMap<>());
    }
    
    public int eval(String expression, Map<String, Integer> map){
        //check for Number - positive or negative
        if (isNumber(expression)) return Integer.valueOf(expression);
        //check if this is a variable
        if (isVariable(expression)) return map.get(expression);
        
        //result
        int res = 0;
        //tokens list
        List<String> list = parse(expression);
        //if the operation is add, then add by recursive call to first operand and second operand
        if (list.get(0).equals("add")) res = eval(list.get(1), map) + eval(list.get(2), map);
        //if the operation is mult, then add by recursive call to first operand and second operand
        else if(list.get(0).equals("mult")) res = eval(list.get(1), map) * eval(list.get(2), map);
        //let operation
        else{
            //we need new set of map to store the variables in this scope
            //extend on top of existing map
            Map<String, Integer> newMap = new HashMap<>();
            newMap.putAll(map);
            //loop thorugh 1 and length-1 skipping paranthesis
            // step 2 skipping spaces
            for (int i = 1;i<list.size()-1;i+=2)
                //add the tokens and its value will be given by a recursive call
                newMap.put(list.get(i), eval(list.get(i+1), newMap));
            //the last expession recursive call
            res = eval(list.get(list.size()-1), newMap);
        }
        return res;
    }
    
    //check if first character is a digit or -
    public boolean isNumber(String expr){
        char c = expr.charAt(0);
        return Character.isDigit(c) || c == '-';
    }
    //if character is lower case
    public boolean isVariable(String expr){
        char c = expr.charAt(0);
        return Character.isLowerCase(c);
    }
    
    public List<String> parse(String expr){
        //list to hold all the tokens
        List<String> res = new ArrayList<>();
        //skip the first and last character for '(' and  ')''
        expr = expr.substring(1, expr.length() - 1);
        
        int i = 0;
        // strip off the tokens by iteration
        while (i < expr.length()){
            int j = find(expr, i);
            //add to the list
            res.add(expr.substring(i, j));
            i = j + 1;
        }
        return res;
    }
    
    public int find(String expr, int i){
        int index = i;
        //if the expression contains parantheses
        if (expr.charAt(index) == '('){
            int count = 1;
            index++;
            // loop further and check if any more expressions
            while (index < expr.length() && count > 0){
                //increment and decrement based on the parantheses
				if (expr.charAt(index) == '(') count++;
                else if (expr.charAt(index) == ')') count--;
                index++;
            }
        }
        else 
            // increment the index until space
			while (index < expr.length() && expr.charAt(index) != ' ') index++;
        return index;
    }
}
// @lc code=end

