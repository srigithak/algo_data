package com.srigith.ds.bean;

import java.util.ArrayList;
import java.util.List;

class PartitionLabel {
	
    public List<Integer> partitionLabels(String S) {
        assert !(S==null || S.length()==0 || S.length()>500):"'S' must be string with length in range [1, 500]";
		assert S.toLowerCase().equals(S):"'S' can only contain lowercase letter";

		List<Integer> result = new ArrayList<Integer>();
		if(S.length()==1){
			result.add(1);
			return result;
		}

		int[] indexArray=getMaxIndex(S);

		int startIndex = 0;
		int endIndex = indexArray[getCharValue(S.charAt(0))];
		int n = S.length();

		while(startIndex<n && endIndex<n) {
			int curStartIndex = startIndex;
			for(;startIndex<=endIndex;startIndex++){

				if(indexArray[getCharValue(S.charAt(startIndex))]>endIndex){
					endIndex = indexArray[getCharValue(S.charAt(startIndex))];
				}
			}
			result.add(endIndex-curStartIndex+1);

			endIndex = startIndex<n?indexArray[getCharValue(S.charAt(startIndex))]:++endIndex;
		}

		return result;

	}


	private int[] getMaxIndex(String s){
		int[] indexArray=new int[26];
		for(int i=0;i<s.length();i++) {
			indexArray[getCharValue(s.charAt(i))] = i;
		}

		return indexArray;
	}

	private int getCharValue(char c){
		return c-'a';
	}
}
