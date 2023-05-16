package app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import app.cmd.AllLowerCase;
import app.cmd.AllUpperCase;
import app.cmd.ICommand;
import app.cmd.Regular;
import app.ps.IPrintStream;
import app.ps.LowerCaseStream;
import app.ps.RegularPrintStream;
import app.ps.UpperCaseStream;

public class Main {
	
	private static IPrintStream upperCaseStream;
	private static IPrintStream lowerCaseStream;
	private static IPrintStream regularPrintStream;
	
	private static ICommand upperCaseCmd;
	private static ICommand lowerCaseCmd;
	private static ICommand regularCmd;
	
	private static BufferedReader reader;
	private static String input;

	public static void main(String[] args) {
		
		System.out.println("PRINT STREAM App : Begin");
		
		try {
			upperCaseStream = new UpperCaseStream("log/output_upper.txt");
			lowerCaseStream = new LowerCaseStream("log/output_lower.txt");
			regularPrintStream = new RegularPrintStream("log/output_regular.txt");
			
			upperCaseCmd = new AllUpperCase(upperCaseStream);
			lowerCaseCmd = new AllLowerCase(lowerCaseStream);
			regularCmd = new Regular(regularPrintStream);
			
			reader = new BufferedReader(new InputStreamReader(System.in));
			
			while (!"STOP".equals(input)) {
				try {
					System.out.print("> ");
					input = reader.readLine();
					
					System.out.printf("USER input : %s \n", input);
					
					if (Character.isUpperCase(input.charAt(0)))
						upperCaseCmd.execute(input);
					else if (Character.isLowerCase(input.charAt(0)))
						lowerCaseCmd.execute(input);
					else
						regularCmd.execute(input);
					
				} catch (IOException exc) {
					exc.printStackTrace();
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			regularPrintStream.close();
			lowerCaseStream.close();
			upperCaseStream.close();
		}
		
		System.out.println("PRINT STREAM App : End");
	}
}
