package com.srigith.array;
//780. Reaching Points
public class ReachingPoints {

	public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        isValidPoint(sx);
        isValidPoint(sy);
        isValidPoint(tx);
        isValidPoint(ty);
        return reachingPointsUtil(sx,sy,tx,ty);
    }
    
    public void isValidPoint(int c) {
        assert c>0 && c<=1000000000:"'tx' must be in range [1, 1000000000]";
    }

    private boolean reachingPointsUtil(int x, int y, int tx, int ty) {
        if(tx<x || ty<y)
            return false;
        
        if(tx==x && ty==y)
            return true;
        
        boolean left = reachingPointsUtil(x,x+y,tx,ty);
        boolean right = reachingPointsUtil(x+y,y,tx,ty);
        
        return left || right;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*# Every parent point (x, y) has two children, (x, x+y) and (x+y, y).
	# Time:  O(\max(tx, ty))O(max(tx,ty)) e.g. (1,10**9)
	# Space: O(1)
	class Solution1(object):
	    def reachingPoints(self, sx, sy, tx, ty):
	        while tx >= sx and ty >= sy:
	            if sx == tx and sy == ty: return True
	            if tx > ty:
	                tx -= ty
	            else:
	                ty -= tx
	        return False
	       
	# GCD: https://upload.wikimedia.org/wikipedia/commons/e/e2/Euclidean_algorithm_252_105_animation_flipped.gif
	# Time: O(log(max(tx,ty)))
	# Space: O(1) 
	class Solution2(object):
	    def reachingPoints(self, sx, sy, tx, ty):
	        while tx >= sx and ty >= sy:
	            if tx == ty:
	                break
	            elif tx > ty:
	                if ty > sy:
	                    tx %= ty
	                else:
	                    return (tx - sx) % ty == 0
	            else:
	                if tx > sx:
	                    ty %= tx
	                else:
	                    return (ty - sy) % tx == 0
	 
	        return tx == sx and ty == sy*/

}
