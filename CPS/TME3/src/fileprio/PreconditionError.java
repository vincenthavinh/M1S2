package fileprio;

public class PreconditionError extends Error{
	public PreconditionError(String message) {
		super("PreconditionError: "+message);
	}
}
