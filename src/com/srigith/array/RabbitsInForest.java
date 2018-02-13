package com.srigith.array;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {

	public int numRabbits(int[] answers) {
        if(answers==null || answers.length==0)
            return 0;
        
        int min = 0;
        Map<Integer,Integer> rabbitCount = new HashMap<Integer,Integer>();
        
        for(int i=0;i<answers.length;i++){
            min++;
            if(rabbitCount.containsKey(answers[i])) {
                int count = rabbitCount.get(answers[i]);
                if(count==1) {
                   rabbitCount.remove(answers[i]); 
                } else {
                    rabbitCount.put(answers[i],--count);
                }
            } else if(answers[i]>0) {
               rabbitCount.put(answers[i],answers[i]); 
            }  
        }
        
        for(Integer r : rabbitCount.keySet()) {
            min += rabbitCount.get(r);
        }
        
        return min;
    }
	
	public static void main(String[] args) {
		assert new RabbitsInForest().numRabbits(new int[]{1, 1, 2})==5:"Wrong output";

	}

}
