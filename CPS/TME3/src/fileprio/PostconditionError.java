package fileprio;

public class PostconditionError extends Error{
	public PostconditionError(String message) {
		super("PostconditionError: "+message);
	}
}
