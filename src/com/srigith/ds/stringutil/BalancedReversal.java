package com.srigith.ds.stringutil;

import java.util.Stack;

public class BalancedReversal {
	public static int countReversals(String expr){
		if(expr==null || expr.length()%2!=0){
			return -1;
		}
		int reversalCount = 0;
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<expr.length();i++){
			if(expr.charAt(i)=='}'){				
				if(!stack.isEmpty()){
					stack.pop();
				}else{
					stack.push('{');
					reversalCount++;
				}				
			}else{
				stack.push('{');
			}
		}
		reversalCount += stack.size()/2;
		
		
		return reversalCount;
	}
	
	public static int countReversalsWithoutStack(String expr){
		if(expr==null || expr.length()%2!=0){
			return -1;
		}
		int reversalCount = 0;
		int inStackCount = 0;
		
		for(int i=0;i<expr.length();i++){
			if(expr.charAt(i)=='}'){				
				if(inStackCount>0){
					inStackCount--;
				}else{
					inStackCount++;
					reversalCount++;
				}				
			}else{
				inStackCount++;
			}
		}
		reversalCount += inStackCount/2;
		
		
		return reversalCount;
	}
	
	public static void main(String[] args) {
		System.out.println(countReversals("}{{{}}"));
		System.out.println(countReversalsWithoutStack("}{{{}}"));
	}
}
