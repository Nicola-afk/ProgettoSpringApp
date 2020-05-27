package giopollo.progetto.Request.Stats;

import java.util.HashMap;
import java.util.List;

import giopollo.progetto.Model.Follower;

public class Function {
	public static float media(List<Follower> u)
	{
		float media=0;
		int sum41=0;
		for(Follower f : u) 
		{
			String blink182 = f.getLocation();
			sum41+= blink182.length();
		}
		media = (float)sum41/u.size();
		return media;
	}

	public static HashMap<String,Float> allOccurrences(List<Follower> lf)
	{
		HashMap<String,Float> map = new HashMap<String,Float>();
		if(lf.size()>0)
		{
			for(int i=0;i<lf.size();i++)
			{
				String s = lf.get(i).getLocation().toUpperCase();
				if (map.containsKey(s))	
				{
					float occ = map.get(s);
					map.put(s, occ+1);
				}
				else 
				{
					float a = 1;
					map.put(s, a);
				}
			}
			return map;
		}
		return null;
	}
}