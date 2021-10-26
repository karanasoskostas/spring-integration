package pydra.integration;



import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;


@SpringBootApplication
//@Import(GlobalExceptionHandler.class)
public class IntegrationApplication {

//	@Test
//	public static void readTextFile(){
//		FileInputStream fstream = null;
//		try {
//			fstream = new FileInputStream("textfile.txt");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
//
//		String strLine = "";
//
////Read File Line By Line
//		while (true)   {
//			try {
//				if (!((strLine = br.readLine()) != null)) break;
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			// Print the content on the console
//
//			System.out.println (strLine);
//		}
//
////Close the input stream
//		try {
//			fstream.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}




	public static void main(String[] args) {
//		readTextFile();
		SpringApplication.run(IntegrationApplication.class, args);
	}

}
