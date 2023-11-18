
public class interestConversion {
    double annualPercentRate;
    double effectiveInterestRate;
    double compoundingPeriods;
    interestConversion(double NOM, double EFF, int CY) {
        annualPercentRate=NOM;
        effectiveInterestRate=EFF;
        compoundingPeriods=CY;
    }
    double ComputeAnnualRate() {
        annualPercentRate=100*compoundingPeriods*(Math.pow(1+(effectiveInterestRate/100), 1/compoundingPeriods)-1);
        System.out.println(annualPercentRate);
        return annualPercentRate;
    }
    double ComputeEffectiveRate() {
        effectiveInterestRate=100*(Math.pow(1+(annualPercentRate/100)/compoundingPeriods, compoundingPeriods)-1);
        System.out.println(effectiveInterestRate);
        return effectiveInterestRate;
    }   
}
