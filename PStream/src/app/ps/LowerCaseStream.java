package app.ps;

import java.io.FileNotFoundException;

public class LowerCaseStream extends APrintStream {

	public LowerCaseStream(String logPath) throws FileNotFoundException {
		super(logPath);
	}
}
