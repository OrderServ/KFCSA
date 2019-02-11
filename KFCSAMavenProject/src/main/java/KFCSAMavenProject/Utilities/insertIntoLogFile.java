package KFCSAMavenProject.Utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import KFCSAMavenProject.Properties.properties;

public class insertIntoLogFile  {
	
	public static void insertToLog(String message,boolean flag)throws Exception
	{
		properties pr = new properties();
		String logFile = pr.getDataFromProperty("LogFilePath");
		Date objDate = new Date();
		SimpleDateFormat objformat = new SimpleDateFormat();
		String newDate = objformat.format(objDate);
		
		
		try
		{
			File fso = new File(logFile);
			if(!(fso.exists()))
			{
				fso.createNewFile();
			}
			FileWriter FW = new FileWriter(fso,true);
			BufferedWriter BW = new BufferedWriter(FW);
			try
			{
				BW.newLine();
				BW.write(newDate+" : "+message);
				BW.newLine();
				if(flag == false)
				{
					BW.write("---------------------------------------------------------------------------------------");
				}
				BW.close();
	
			}
			catch(Exception e)
			{
				
			}
		
		}
		catch(Exception e)
		{
			System.out.println("error on writing to the logFile"+"\n"+e.toString());
		}
		
	}
	public static void main (String [] args) throws Exception
	{
		insertToLog("Hello World",true);
	}
}
