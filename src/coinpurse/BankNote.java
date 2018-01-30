package coinpurse;

/**
 * Banknote represents banknote (money) with a fixed value ,currency and serial number. 
 * @author Tanasorn Tritawisup
 *
 */

public class BankNote implements Valuable{

	private double value;
	private String currency;
	private static long nextSerialNumber = 1000000;
	private long serialNumber;
	
	/**
	 * Initialize a new BankNote.
	 * @param value of the banknote.
	 * @param currency of the banknote.
	 */
	public BankNote(double value, String currency){
		this.value = value;
		this.currency = currency;
		this.serialNumber = serialNumber++;
	}
	
	/**
	 * Get the value of the Banknote.
	 * @return value.
	 */
	public double getValue(){
		return value;
	}
	
	/**
	 * Get the currency of the Banknote.
	 * @return currency.
	 */
	public String getCurrency(){
		return currency;
	}
	
	/**
	 * Get a serial number of the Banknote.
	 * @return serialNumber.
	 */
	public long getSerial(){
		return serialNumber;	
	}
	

	/**
	 * @param arg is the Object that you want to compare.
	 * @return true if two banknote have the same value and currency.
	 */
    @Override
	public boolean equals(Object obj){
		if (obj == null) return false;
	    if (obj.getClass() != this.getClass()) return false;
	    BankNote other = (BankNote)obj;
		return this.getValue() == other.getValue() && this.getCurrency().equals(other.getCurrency());
	}
	
    @Override
	public String toString(){
		return String.format("%.0f-&s note [%d]", value, currency, serialNumber);
	}
}
