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
	
    /**
     * @param Coin that you want to compare with another coin.
     * @return -1 if first coin has much value than second.
     *          1 if first coin has less value than second.
     *          0 if first coin has the same value as second.
     */
    public int compareTo(Coin Coin)	{
		if(this.getValue() < Coin.getValue()) {
			return -1;
		} else if(this.getValue() > Coin.getValue()) {
			return 1;
		} else return 0;
	}
	
    @Override
	public String toString(){
		return value + "-" + currency;		
	}
	
}
