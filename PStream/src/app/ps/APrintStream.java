package app.ps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class APrintStream implements IPrintStream {
	private final File log;
	private PrintWriter pw;
	
	public APrintStream(String logPath) throws FileNotFoundException {
		this.log = new File(logPath);
		this.pw = new PrintWriter(log);
	}

	@Override
	public void println(String input) {
		pw.print(input);
		pw.flush();
	}

	@Override
	public void close() {
		pw.close();
	}
}
