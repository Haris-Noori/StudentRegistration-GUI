package pkg;

public class main {
	
	public static model m;
	public static controller c;

	public static void main(String[] args)
	{
		m = new model();
		regFrame f = new regFrame();
		
		c = new controller(m,f);
		
		tableFrame t = new tableFrame();
		
		c.createTableFrame(t);
	}
}
