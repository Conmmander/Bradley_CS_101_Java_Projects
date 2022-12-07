/**
* @author Ryan Dodd
* <p> InsufficientFundsException.java
* <p> Project5
* <p> This class represents an error in which too many funds exist in an account.
*/

public class InsufficientFundsException extends Exception
{
	private static final long serialVersionUID = 1L;

	public InsufficientFundsException() {}

	public InsufficientFundsException(String arg0)
    {
		super(arg0);
	}

	public InsufficientFundsException(Throwable arg0)
    {
		super(arg0);
	}

	public InsufficientFundsException(String arg0, Throwable arg1)
    {
		super(arg0, arg1);
    }

	public InsufficientFundsException(String arg0, Throwable arg1, boolean arg2, boolean arg3)
    {
		super(arg0, arg1, arg2, arg3);
	}

}
