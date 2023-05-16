package app.ps;

import java.io.FileNotFoundException;

public class UpperCaseStream extends APrintStream {

	public UpperCaseStream(String logPath) throws FileNotFoundException {
		super(logPath);
	}
}
