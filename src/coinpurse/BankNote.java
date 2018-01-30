package coinpurse;

public class BankNote implements Valuable{

	private double value;
	private String currency;
	private static long nextSerialNumber = 1000000;
	private long serialNumber;
	
	public BankNote(double value, String currency){
		this.value = value;
		this.currency = currency;
		this.serialNumber = serialNumber++;
	}
	
	public double getValue(){
		return value;
	}
	
	public String getCurrency(){
		return currency;
	}
	
	public long getSerial(){
		return serialNumber;	
	}
	
	public boolean equals(Object obj){
		if (obj == null) return false;
	    if (obj.getClass() != this.getClass()) return false;
	    BankNote other = (BankNote)obj;
		return this.getValue() == other.getValue() && this.getCurrency().equals(other.getCurrency());
	}
	
	public String toString(){
		return String.format("%.0f-&s note [%d]", value, currency, serialNumber);
	}
}
