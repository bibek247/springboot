package com.example.demo;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Sqldbsetting {
	
static void savesetting(String user,String pswd) {
		// TODO Auto-generated method stub
try {
	
	//Sqldb sqldb = new Sqldb("sa", "Aa");
	Sqldb sqldb = new Sqldb(user, pswd);
	
	FileOutputStream fout=new FileOutputStream(".dblib");    
	ObjectOutputStream out=new ObjectOutputStream(fout);    
	out.writeObject(sqldb);    
	out.flush();    
	//closing the stream    
	out.close();    
	
}catch(Exception e) {}
	}
	
	public String getsetting() {
		// TODO Auto-generated method stub
		String r="";
		
		try {
			
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(".dblib"));    
			Sqldb sqldb=(Sqldb)in.readObject();  
			in.close();
			r = sqldb.toString();
			
			 			
		}catch(Exception e) {}
			
		return r;
	}

}
