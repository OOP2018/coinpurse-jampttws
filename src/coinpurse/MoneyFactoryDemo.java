package coinpurse;

/**
 * This class is 
 * @author Tanasorn Tritawisup
 *
 */
public class MoneyFactoryDemo {
	
	public static void main(String[] args){
		MoneyFactory tm = new ThaiMoneyFactory();
		System.out.println(tm.createMoney(1));
		System.out.println(tm.createMoney(20));
		System.out.println(tm.createMoney(50));
		MoneyFactory tm2 = new ThaiMoneyFactory();
		if(tm == tm2); System.out.println("singleton");
		
		MoneyFactory mm = new MalayMoneyFactory();
		System.out.println(mm.createMoney(0.05));
		System.out.println(mm.createMoney(2));
		System.out.println(mm.createMoney(100));
		
		MoneyFactory mf1 = MoneyFactory.getInstance();
		System.out.println(mf1.createMoney(2));
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory mf2 = MoneyFactory.getInstance();
		System.out.println(mf2.createMoney(0.10));
		
	}

}
