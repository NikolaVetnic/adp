package app.cmd;

import app.ps.IPrintStream;

public class Regular extends ACommand {

	public Regular(IPrintStream output) {
		super(output);
	}

	@Override
	protected String process(String input) {
		return input;
	}
}
