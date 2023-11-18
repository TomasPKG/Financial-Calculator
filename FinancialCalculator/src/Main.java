
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
		interestConversion EffectiveRate = new interestConversion(5, 0, 12);
		EffectiveRate.ComputeEffectiveRate();
		interestConversion NominalRate = new interestConversion(0, 5.5, 12);
		NominalRate.ComputeAnnualRate();
		System.out.println("Investment Criteria Test:");
		investmentCriteria InvestmentDecision = new investmentCriteria(-50000, 12);
		InvestmentDecision.addCashFlow(30000);
		InvestmentDecision.addCashFlow(20000);
		InvestmentDecision.addCashFlow(10000);
		InvestmentDecision.addCashFlow(10000);
		InvestmentDecision.addCashFlow(10000);
		System.out.println(InvestmentDecision.computeNetPresentValue());
		System.out.println(InvestmentDecision.computeInternalRateReturn());
		System.out.println("Mortages Test:");
		
		System.out.println("Bonds Test:");
	}
}
