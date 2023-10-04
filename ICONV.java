/**
 * Interest Conversion:
 * convert between Annual Percent Rate (APR) & Effective Interest Rate (EFF) 
 * @author Tomas
 * @version indev 0.1
 */
public class ICONV {
    double annualPercentRate;
    double effectiveInterestRate;
    int compoundingPeriods;
    public ICONV(double APR, double EFF, int P) {
        annualPercentRate=APR;
        effectiveInterestRate=EFF;
        compoundingPeriods=P;
    }
    public double getAPR() {
        // Place holder
        return 4.2;
    }
    
    public double getEFF() {
        // place holder
        return 4.2;
    }
}
