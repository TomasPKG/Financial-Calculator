
import java.util.ArrayList;
public class investmentCriteria {
	double initialInvestment;
	ArrayList<Double> cashFlows;
	double discountRate;
	investmentCriteria(double II, double DR) {
		initialInvestment=II;
		cashFlows=new ArrayList<Double>();
		discountRate=DR;
	}
	void addCashFlow(double CF_n) {
		cashFlows.add(CF_n);
	}
	double computeNetPresentValue() {
		double discountedCashFlows=0;
		int i=1;
		for(double CashFlow: cashFlows) {
			discountedCashFlows+=CashFlow/Math.pow(1+discountRate/100,i);
			i++;
		}
		return initialInvestment+discountedCashFlows;
	}
	double computeInternalRateReturn() {
		double currentNPV=this.computeNetPresentValue();
		double discountRateMemory=discountRate;
		while(currentNPV>1 || currentNPV<-1) {
			if (currentNPV<0) {
                discountRate/=1.00005;
                currentNPV=this.computeNetPresentValue();
            }
            else if (currentNPV>0) {
                discountRate*=1.0001;
                currentNPV=this.computeNetPresentValue();
            }
		}
		double IRR=discountRate;
		discountRate=discountRateMemory;
		return IRR;
	}
}
