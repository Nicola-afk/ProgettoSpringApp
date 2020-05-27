package giopollo.progetto.Request.Filter;

import java.util.HashMap;
import java.util.List;

import giopollo.progetto.Database.Parsing;
import giopollo.progetto.Model.Follower;

public class F_Word {

	public static List<Follower> apply(List<Follower> lista, String a, Parsing p) {
		for(HashMap<String,String> hm : p.users) 
		{
			String s = hm.get("location");
			if(s.indexOf(a)>0) 
			{
				Follower f = new Follower(hm.get("name"), s);
				lista.add(f);
			}	
		}
		return lista;		
	}

}