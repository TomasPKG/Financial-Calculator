
public class Main {
	public static void main(String[] args) {
		System.out.println("Time Value of Money Test:");
		timeValueMoney Time = new timeValueMoney(0, 10, -10000, 0, 25000);
		Time.ComputeTime();
		timeValueMoney InterestRate = new timeValueMoney(10, 0, -10000, 0, 25000);
		InterestRate.ComputeInterest();
		timeValueMoney InterestCashFlow = new timeValueMoney(10, 0, -10000, -500, 25000);
		InterestCashFlow.ComputeInterest();
		timeValueMoney PresentValue = new timeValueMoney(10, 10, 0, 0, 25000);
		PresentValue.ComputePresentValue();
		System.out.println("Interest Conversion Test:");
		
		System.out.println("Investment Criteria Test:");
		
		System.out.println("Mortages Test:");
		
		System.out.println("Bonds Test:");
	}
}
