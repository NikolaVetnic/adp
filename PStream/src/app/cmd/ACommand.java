package app.cmd;

import app.ps.IPrintStream;

public abstract class ACommand implements ICommand {
	private final IPrintStream output;
	
	public ACommand(IPrintStream output) {
		this.output = output;
	}

	@Override
	public void execute(String input) {
		output.println(String.format("%s", process(input)));
	}

	protected abstract String process(String input);
}
