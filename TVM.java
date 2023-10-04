/**
 * Time Value of Money:
 * TVM methods found of financial calculators 
 * @author Tomas
 * @version indev 0.1
 */
public class TVM
{
    int time;
    double interestRate;
    double presentValue;
    double payment;
    double futureValue;

    public TVM(int N, double IY, double PV, double PMT, double FV) {
        time = N ;
        interestRate = IY;
        presentValue = PV;
        payment = PMT;
        futureValue = FV;
    }

    public void ComputeN () {
        double rate = 1 + this.interestRate/100;
        while (-this.presentValue<this.futureValue) {
            this.futureValue+=this.payment;
            this.futureValue/=rate;
            this.time++;
        }
        double decimalTime = this.time;
        double additionYearDifference = -this.presentValue+((this.presentValue-this.payment)/rate);
        double calculatorError = this.presentValue+this.futureValue;
        decimalTime=calculatorError/additionYearDifference;
        System.out.println(this.time);
        System.out.println(decimalTime);
    }
    
    public void ComputeIY () {
        this.interestRate=5;
        double rate = 1 + this.interestRate/100;
        int timeIteration=0;
        int sideEffect = 0;
        timeIteration = iterate (rate, timeIteration, this.futureValue, this.payment);
        while (timeIteration!=this.time) {
            if (this.time>timeIteration) {
                rate/=1.0000125;
                System.out.println(timeIteration);
                if (sideEffect == 0) {
                    this.time++;
                    sideEffect++;
                }
                timeIteration = iterate (rate, 0, this.futureValue, this.payment);
            }
        
            else if (this.time<timeIteration) {
                rate*=1.00025;
                System.out.println(timeIteration);
                timeIteration = iterate (rate, 0, this.futureValue, this.payment);
            }
        }    
        System.out.println((rate-1)*100);
        }
    
    private int iterate (double rate, int timeIteration, double FV, double PMT) {
        while (-this.presentValue<FV) {
             FV+=PMT;
             FV/=rate;
             timeIteration++;
        }
        return timeIteration;
     }
    
    public void ComputePV () {
        double rate = 1 + this.interestRate/100;
        this.presentValue-=this.futureValue/rate;
        for (int i=0; i<this.time; i++) {
            this.presentValue+=this.payment;
            this.presentValue/=rate;
        }
        System.out.println(this.presentValue);
    }
    
    public void ComputePMT () {
        System.out.println("incomplete method");
        
    }
    
    public void ComputeFV () {
        double rate = 1 + this.interestRate/100;
        this.futureValue-=this.presentValue*rate;
        for (int i=1; i<this.time; i++) 
        {
            this.futureValue-=this.payment;
            this.futureValue*=rate;
        }
        System.out.println(this.futureValue);
    }
}
