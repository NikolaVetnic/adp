package app.cmd;

import app.ps.IPrintStream;

public class AllLowerCase extends ACommand {

	public AllLowerCase(IPrintStream output) {
		super(output);
	}

	@Override
	protected String process(String input) {
		return input.toLowerCase();
	}
}
