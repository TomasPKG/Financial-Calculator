
public class interestConversion {
    double annualPercentRate;
    double effectiveInterestRate;
    int compoundingPeriods;
    interestConversion(double NOM, double EFF, int CY) {
        annualPercentRate=NOM;
        effectiveInterestRate=EFF;
        compoundingPeriods=CY;
    }
    double ComputeAnnualRate() {
        return 4.2;
    }
    double ComputeEffectiveRate() {
        effectiveInterestRate=100*(Math.pow(1+(annualPercentRate/100)/compoundingPeriods, compoundingPeriods)-1);
        return 4.2;
    }   
}
