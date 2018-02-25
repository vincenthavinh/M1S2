package fileprio;

public class InvariantError extends Error{

	public InvariantError(String message) {
		super("InvariantError: "+message);
	}

}
