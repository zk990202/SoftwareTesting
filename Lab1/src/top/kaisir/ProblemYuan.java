package top.kaisir;

import java.util.ArrayList;
import java.util.List;

public class ProblemYuan {
			
	List<Integer> list = new ArrayList<Integer>();
	
	public boolean caculateYuan(int x) {
		 
		 int[] arr = {50, 20, 5, 5, 1, 1, 1};
	     int n = arr.length;
	     list.add(0);
	     for(int i = 0; i < n; i++) {
	    	int l = list.size();
	        for(int j = 0; j < l; j++) {
	        	int newNumber = arr[i] + list.get(j);
	        	if(!list.contains(newNumber)) {
	        		list.add(newNumber);
	        	}
	        }
	     }
	     if(list.contains(x))
	    	 return true; 
	     return false;
	}
}
