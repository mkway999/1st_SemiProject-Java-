import java.util.HashMap;
import java.util.Map;

class Sub
{
	public static Map<Integer, SubProducts> sub = new HashMap<Integer, SubProducts>();
	public static void set()
	{
		sub.put(1,new SubProducts("����",0,10500));
		sub.put(2,new SubProducts("��ġ",0,350));
	}
}