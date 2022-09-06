package ch04.ex01.model;

import java.io.*;
import java.util.*;

public class RegisterService {
	static private List<String> memberIDList = new ArrayList<String>() ;
	public RegisterService() throws IOException {
		if  (memberIDList.isEmpty() ) {
			 populateIDList();
		}
	}
	private void populateIDList() throws IOException {
		File f = new File("c:\\data") ; 
		if ( !f.exists() ) {
		   f.mkdirs();   
		}
		File mem = new File(f, "memberData.txt") ;
		if (!mem.exists()) {
			mem.createNewFile();
		}
		BufferedReader br = new BufferedReader(new FileReader(mem));
		String line = "";
		while ( ( line = br.readLine() ) != null ) {
			 String[] dataArray = line.split("\\|"); 
			 String id = dataArray[0].trim();
			 memberIDList.add(id);
		}
		br.close();
	}
	public boolean idExists(String id) throws IOException {
		boolean exist = false ; 
	     for ( String s : memberIDList) {
	    	 if ( s.equals(id.trim())) {
	    		 exist = true ; 
	    		 break;
	    	 }
	     }
	     return exist; 
	}

	public int saveMember(Member mem) throws IOException {
			File f = new File("c:\\data", "memberData.txt");		
			PrintWriter pw = new PrintWriter(new FileWriter(f , true )); 
	        pw.println(mem.userId + "|"  + mem.getPassword() + "|" + mem.getName() + "|" + mem.getEmail()  + "|" + mem.getTel() + "|" + mem.getExpericnce() );    		
			pw.close();
			memberIDList.add(mem.getUserId());
			return 1;
	}
}