package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Tanasorn Tritawisup
 */

public class Purse {
    /** Collection of objects in the purse. */
    private List<Valuable> money;
	
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
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
    public double getBalance() {
    	double totalValue = 0.0;
    	for(Valuable v : money) totalValue += v.getValue();
    	return totalValue;
	}

    
    /**
     * Return the capacity of the coin purse.
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
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     * @param coin is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert( Valuable value ) {
        if(isFull() || value.getValue() <= 0) return false;  
        else {
        	money.add(value);
        	return true;
        }	
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Coins withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Coin objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {
    	
       	List<Valuable> withdraw = new ArrayList<Valuable>();
    	
    	if(amount <= 0 || amount > getBalance()) return null;
    	
    	Comparator<Valuable> comparator = new ValueComparator();
    	    
       	Collections.sort((List<Valuable>) money, comparator);
    	
		for (int i = money.size()-1; i >= 0; i--) {
			if (amount >= money.get(i).getValue()) {
				amount -= money.get(i).getValue();
				withdraw.add(money.get(i));
			} 
		}
		
		if ( amount != 0 ){	
			return null;
		}

		for(Valuable v : withdraw) money.remove(v);
		
		Valuable[] withdrawArray = new Valuable[withdraw.size()];
        return withdraw.toArray(withdrawArray);
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    @Override 
    public String toString() {
    	    return String.format("%d coins with value %.1f", this.count(), this.getBalance());
    }

}
