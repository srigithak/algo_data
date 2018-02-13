package com.truepair;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TruePair {
    
    private Map<Pair,Integer> truePairMap = new HashMap<Pair,Integer>();
    private int truePairsCount = 0;
    
    public int getTruePairCount(){
        return truePairsCount;
    }
    
    public void evaluateTruePair(Pair trueCell) {
        if(trueCell==null)
            return;
        
        Pair diag1=null,diag2=null;
        
        diag1 = new Pair(Math.max(0,trueCell.x-trueCell.y),Math.max(0, trueCell.y-trueCell.x));
        diag2 = new Pair(trueCell.y+trueCell.x,Math.max(0,trueCell.x-trueCell.y));
        
        truePairsCount+=truePairMap.getOrDefault(diag1,0);
        truePairsCount+=truePairMap.getOrDefault(diag2,0);
        
        truePairMap.put(diag1,truePairMap.getOrDefault(diag1, 0)+1);
        truePairMap.put(diag2,truePairMap.getOrDefault(diag2, 0)+1);
    }
    
    static class Pair {
        int x;
        int y;
        
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y +"]";
		} 
        
    }
    
    public static void main(String args[] ) throws Exception {
        Scanner inputScanner = new Scanner(System.in);
        int testCases = inputScanner.nextInt();
        
        if(testCases>0){
            for(int t=0;t<testCases;t++) {
                TruePair sol = new TruePair();
                int n = inputScanner.nextInt();
                if(n<=0){
                   System.out.println("Invalid input");
                    continue;
                }
                for(int i=0;i<n;i++) {       
                    int r = inputScanner.nextInt();
                    int c = inputScanner.nextInt();
                    TruePair.Pair trueCell = new TruePair.Pair(r,c);
                    sol.evaluateTruePair(trueCell);
                }
                System.out.println(sol.getTruePairCount());
            }
        }
        
        inputScanner.close();
    }
}
