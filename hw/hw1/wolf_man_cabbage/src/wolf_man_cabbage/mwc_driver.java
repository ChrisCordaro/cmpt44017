package wolf_man_cabbage;

public class mwc_driver {
	
	public static void main(String[] args){
		mwc myMwc = new mwc();
		String myInput = args[0];
		mwc.process(args[0]);
		while(myInput != null){
			myMwc.reset();
			myMwc.process(myInput);
			if(myMwc.accepted()){
				System.out.println("YOU ENTERED A VALID SOLUTION");
			}else{
				System.out.println("YOU DID NOT ENTER A VALID SOLUTION");
			}
		
		}
	}
}
