package File;

public class Main{    
	 /* public static void main(String args[]){    
		  int [] arr= {4,9,3,2,5,2,6};
		  int[] sumarr = null ;
		  for(int i=0 ;i<arr.length;i++) {
			  int sum = 0;
			  for( int j=i+1; j<arr.length;j++) {
				  sum=sum +arr[i]+arr[j];
				  if(sum ==11) {
					  System.out.println("sum is 11");
					  sumarr[0]= arr[i];
					  sumarr[1] = arr[j];
					  break;
				  }else if(sum>11){
					  sum=0;
				  }
			  }
		  }
	  }  */ 
	public static void main(String args[]) {
		int [] arr ={2,3,1,6,9,9};
		 for(int i=0 ;i<arr.length;i++) {
			  for( int j=i+1; j<arr.length;j++) {
				  if(arr[i]>arr[j]) {
					  int x = arr[i];
					  arr[i] = arr[j];
					  arr[j] = x;
				  }
				  }
			  }
		 System.out.print(arr.length);
		 if(arr.length-2==arr.length-1) {
		 }
		 System.out.println("Second largest value is : "+arr[arr.length-1]);
		}
	
	}  

