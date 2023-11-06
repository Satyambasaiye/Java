package custome_exception;

public class CustomeException extends Exception{
	String msg;
	
	public CustomeException(String msg){
		super(msg);
		this.msg=msg;
	}
	

}
