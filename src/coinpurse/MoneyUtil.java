package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 *  A class that use to test compareTo mathod of Coin object. 
 *  @author Tanasorn Tritawisup
 */
public class MoneyUtil {

	public static void main(String[] args){
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(10,"Baht"));
		coins.add(new Coin(5, "Rupie"));
		coins.add(new Coin(35, "Baht"));
		coins.add(new Coin(20, "Dollas"));
		coins.add(new Coin(2, "Baht"));
	    filterByCurrency(coins, "Baht");
		printCoin(coins);
		sortCoins(coins);
		printCoin(coins);
	}
	
	/**
	 * This method is use to print every coin in the list.
	 * @param coins is the List of Coin object.
	 */
	static void printCoin(List<Coin> coins){
		for(int i = 0; i < coins.size(); i++){
			System.out.println(coins.get(i));
		}
	}
	
    static List<Coin> filterByCurrency(List<Coin> coins, String currency){
    	List<Coin> filter = new ArrayList<Coin>();
    	String checkCurrency;
    	for(Coin c : coins){
    		if(!c.getCurrency().equals(currency)){
    			filter.add(c);
    		}
    	}
    	for(Coin c : filter) coins.remove(c);
	return coins;		
	}
	
	/**
	 * Sort method to test compareTo method.
	 * @param coins is the List of Coin object.
	 */
	public static void sortCoins(List<Coin> coins){
		java.util.Collections.sort(coins);
	}
	
}
