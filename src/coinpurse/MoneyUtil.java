package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *  A class that use to test compareTo mathod of Coin object with Valuable class. 
 *  @author Tanasorn Tritawisup
 */
public class MoneyUtil {
	
	private static long serialNumber = 1000000;

	public static void main(String[] args){
		List<Valuable> value = new ArrayList<Valuable>();
		value.add(new Coin(10,"Baht"));
		value.add(new Coin(5, "Rupie"));
		value.add(new Coin(15, "Baht"));
		value.add(new Coin(2, "Baht"));
		value.add(new BankNote(20, "Euro", serialNumber++));
		value.add(new BankNote(50, "Baht", serialNumber++));
	    filterByCurrency(value, "Baht");
		printValue(value);
		sortValue(value);
	}
	
	/**
	 * This method use to print every value in the list.
	 * @param value is the List of Valuable of the object.
	 */
	static void printValue(List<Valuable> value){
		for(int i = 0; i < value.size(); i++){
			System.out.println(value.get(i));
		}
	}
	
	/**
	 * Make the List that have only value with the same currency.
	 * @param value is the List of value of the object.
	 * @param currency of the object that you want to get in a List.
	 * @return a List of Valuable that have the same currency 
	 *     as the currency(parameter).
	 */
    static List<Valuable> filterByCurrency(List<Valuable> value, String currency){
    	List<Valuable> filter = new ArrayList<Valuable>();
    	for(Valuable v : value){
    		if(v.getCurrency().equals(currency)){
    			filter.add(v);
    		}
    	}
	return filter;		
	}
	
	/**
	 * Sort method to test compareTo method.
	 * @param value is the List of Valuable of the object.
	 */
	public static void sortValue(List<Valuable> value){
		Comparator<Valuable> comparator = new ValueComparator();
		Collections.sort((List<Valuable>) value, comparator);
	}
	
}
