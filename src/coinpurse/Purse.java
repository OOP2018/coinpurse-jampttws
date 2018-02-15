package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 *  A purse contains coins and banknote.
 *  You can insert money, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Tanasorn Tritawisup
 */

public class Purse {
    /** Collection of objects in the purse. */
    private static List<Valuable> money;
	
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    private Comparator<Valuable> comparator = new ValueComparator();
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of money you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	money = new ArrayList<Valuable>(capacity);
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     * @return the number of coins in the purse.
     */
    public int count() { 
    	return money.size(); 
    }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public static double getBalance() {
    	double totalValue = 0.0;
    	for(Valuable v : money) totalValue += v.getValue();
    	return totalValue;
	}

    
    /**
     * Return the capacity of the purse.
     * @return the capacity.
     */
    public int getCapacity() { 
		return capacity; 
	}
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
        return count() >= capacity;
    }

    /** 
     * Insert a value into the purse.
     * The value is only inserted if the purse has space for it
     * and the value is positive.
     * @param value is a Valuable interface to insert into purse
     * @return true if value inserted, false if can't insert
     */
    public boolean insert( Valuable value ) {
        if(isFull() || value.getValue() <= 0) return false;  
        else {
        	money.add(value);
        	return true;
        }	
    }
    
    /**
     * Withdraw the amount, using only items that have 
     * the same currency as the parameter(amount). 
     * amount must not be null and amount.getValue() > 0.
     * @param amount
     * @return array of Valuable class for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw(Valuable amount ) {
    	
       	List<Valuable> withdraw = new ArrayList<Valuable>();
    	
    	double value = amount.getValue();
    	
    	if(amount == null) return null;
		if(value <= 0 || value > getBalance()) return null;
    	    
       	Collections.sort((List<Valuable>) money, comparator);

       	List<Valuable> temp = new ArrayList<Valuable>();
       	
       	for(Valuable v : money){
       		if(v.getCurrency().equals(amount.getCurrency())){
       			temp.add(v);
       		}
       	}
       	
		for (int i = temp.size()-1; i >= 0; i--) {
			if (value >= temp.get(i).getValue()) {
				value -= temp.get(i).getValue();
				withdraw.add(temp.get(i));
			} 
		}
		
		if ( value != 0 ) return null;

		for(Valuable v : withdraw) money.remove(v);
		
		Valuable[] withdrawArray = new Valuable[withdraw.size()];
        return withdraw.toArray(withdrawArray);
	}
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Valuable withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Valuable class for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {
    	Money amountM = new Money(amount, "BTC");
    	return withdraw(amountM);       
	}

    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    @Override 
    public String toString() {
    	    return money.toString();
    }

}
