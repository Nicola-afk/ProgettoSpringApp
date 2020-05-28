package giopollo.progetto.Request.Filter;

import java.util.List;

import giopollo.progetto.Model.Follower;


public class F_Between{

	public static List<Follower> apply(List<Follower> lista, List<Integer> b, List<Follower> lf) {
		for(Follower f : lf) 
		{
			String s = f.getLocation();
			if(s.length()>b.get(0) && s.length()<b.get(1)) 
			{
				Follower nf = new Follower(f.getName(), s);
				lista.add(nf);
			}			
		}
		return lista;
	}

	
	}
