package app.ps;

import java.io.FileNotFoundException;

public class RegularPrintStream extends APrintStream {

	public RegularPrintStream(String logPath) throws FileNotFoundException {
		super(logPath);
	}
}
