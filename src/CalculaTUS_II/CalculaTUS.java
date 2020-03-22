package CalculaTUS_II;
import Connector.Connector;

public class CalculaTUS {
	
	private static Connector c = new Connector();
	public CalculaTUS() {
		c.Start();
	}
	
	public static void main(String[] args) {
		CalculaTUS ct = new CalculaTUS();
	}
}
