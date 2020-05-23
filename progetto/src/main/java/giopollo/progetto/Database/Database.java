package giopollo.progetto.Database;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import giopollo.progetto.Model.Follower;
import giopollo.progetto.Model.Parsing;
import giopollo.progetto.Service.Service;



public class Database {
	
	public static Parsing apiDownload(String url){
		
		Parsing p = new Parsing();
		
		try {
			
			URLConnection openConnection = new URL(url).openConnection();
			openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			InputStream in = openConnection.getInputStream();
			
			String data = "";
			String line = "";
			
			try {
				InputStreamReader inR = new InputStreamReader( in );
				BufferedReader buf = new BufferedReader( inR );
				  
				while ( ( line = buf.readLine() ) != null ) {
					data+= line;
				}
				} catch (IOException e) {
					System.out.println(e.getClass().getCanonicalName() + "Errore -> Operazione di I/O interrotte");	
				} finally {
					in.close();
				}
				
				ObjectMapper obj = new ObjectMapper();
				
				p = obj.readValue(data, Parsing.class);
				}
				catch (IOException e) {
						e.printStackTrace();
					}
				
				return p;		
	}
	
	
	
	

	

	
	
	
}