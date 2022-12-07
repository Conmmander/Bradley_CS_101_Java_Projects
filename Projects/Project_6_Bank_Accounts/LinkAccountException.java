/**
* @author Ryan Dodd
* <p> LinkedAccountException.java
* <p> Project5
* <p> This class represents a linked account exception, which is thrown if improper accounts are linked together.
*/

public class LinkAccountException extends Exception
{
	private static final long serialVersionUID = 1L;

	public LinkAccountException() {}

	public LinkAccountException(String arg0)
    {
		super(arg0);
	}

	public LinkAccountException(Throwable arg0)
    {
		super(arg0);
	}

	public LinkAccountException(String arg0, Throwable arg1)
    {
		super(arg0, arg1);
    }

	public LinkAccountException(String arg0, Throwable arg1, boolean arg2, boolean arg3)
    {
		super(arg0, arg1, arg2, arg3);
	}

}
