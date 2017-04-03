package wolf_man_cabbage;

public class mwc {
	private static final int q0 = 0;
	private static final int q1 = 1;
	private static final int q2 = 2;
	private static final int q3 = 3;
	private static final int q4 = 4;
	private static final int q5 = 5;
	private static final int q6 = 6;
	private static final int q7 = 7;
	private static final int q8 = 8;
	private static final int q9 = 9;
	private static final int q10 = 10;
	
	private static int state=0;
	static private int[][] delta = 
		
			  /*W  G  C  N */		
		{     {q10, q1, q10, q10},
		      {q10, q0, q10, q2},
		      {q3, q10, q4, q1},
		      {q2, q5, q10, q10},
		      {q10, q6, q2, q10},
		      {q10, q3, q7, q10},
		      {q7, q4, q10, q10},
		      {q6, q10, q5, q8},
		      {q10, q9, q10, q7},
		      {q10, q8, q10, q10}
				
		};
	
	static void process(String in){
		int index;
		for(int i=0; i < in.length(); i++){
			char c = in.charAt(i);	
			try{
				if(c=='w'){
					index = 0; 
				}else if(c=='g'){
					index = 1;
				}else if(c=='c'){
					index = 2;
				}else if(c=='n'){
					index = 3;
				}else{
					index = -1;
				}
				
			
				state = delta[state][index];
			}catch(ArrayIndexOutOfBoundsException ex){
				System.out.println("ERROR");
				state = q10;
			}
		}
	}
	
	public void reset(){
		state = q10;
	}
	public boolean accepted(){
		return state==q9;
	}
}