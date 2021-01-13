package item;

public class BuyItemFailedException  extends Exception{
	
	private static final long serialVersionUID = 1L;
	String message;

	public BuyItemFailedException(String message){
		
		super(message);
		
	}
/*	public String getMessage() {
		return message;
	}
		*/
}
