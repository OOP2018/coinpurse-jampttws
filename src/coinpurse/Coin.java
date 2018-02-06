package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currecy. 
 * @author Tanasorn Tritawisup
 *
 */
public class Coin implements Valuable {
	
	private double value;
	private String currency;
	
	/** 
	 * Initialize a new Coin.
	 * @param value is value of coin.
	 * @param currency is type of coin.
	 */
	public Coin(double value, String currency){
		if(value >= 0) this.value = value;
		this.currency = currency;
	}
	
	/**
	 * Get the value of the coin.
	 * @return value.
	 */
	public double getValue(){
		return value;
	}
	
	/**
	 * Get the currency of the coin.
	 * @return currency
	 */
	public String getCurrency(){
		return currency;
	}
	
	/**
	 * @param arg is the Object that you want to compare.
	 * @return true if two coins have the same value and currency.
	 */
    @Override
	public boolean equals(Object arg){
		if (arg == null) return false;
	    if (arg.getClass() != this.getClass()) return false;
	    Coin other = (Coin)arg;
		return this.getValue() == other.getValue() && this.getCurrency().equals(other.getCurrency());
	}
	
    @Override
	public String toString(){
		return value + "-" + currency;		
	}
	
}
