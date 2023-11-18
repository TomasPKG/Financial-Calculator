
import java.util.ArrayList;
public class investmentCriteria {
	double initialInvestment;
	ArrayList<Double> cashFlows;
	double discountRate;
	investmentCriteria() {
		cashFlows=new ArrayList<Double>();
	}
	void addCashFlow(double CF_n) {
		cashFlows.add(CF_n);
	}
	void computeNetPresentValue( ) {
		
	}
	void computeInternalRateReturn() {
		
	}
}
