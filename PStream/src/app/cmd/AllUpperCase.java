package app.cmd;

import app.ps.IPrintStream;

public class AllUpperCase extends ACommand {

	public AllUpperCase(IPrintStream output) {
		super(output);
	}

	@Override
	protected String process(String input) {
		return input.toUpperCase();
	}
}
