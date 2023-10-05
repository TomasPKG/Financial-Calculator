/**
 * Time Value of Money:
 * TVM methods found of financial calculators 
 * @author Tomas
 * @version indev 0.1.1
 */
public class TVM
{
    double time;
    double interestRate;
    double presentValue;
    double payment;
    double futureValue;

    public TVM(double N, double IY, double PV, double PMT, double FV) {
        time = N ;
        interestRate = IY;
        presentValue = PV;
        payment = PMT;
        futureValue = FV;
    }

    public void ComputeN () {
        this.time = Math.log(-this.futureValue/this.presentValue)/Math.log(this.interestRate/100+1);
        System.out.println(this.time);
    }
    
    public void ComputeIY () {
        if (this.payment == 0) {
            double discountRate;
            discountRate = this.futureValue/this.presentValue;
            discountRate = Math.pow(-discountRate, 1/this.time);
            System.out.println((discountRate-1)*100);
        }
        else {
            this.interestRate=5;
            double rate = 1 + this.interestRate/100;
            double timeIteration=0;
            while (this.time-0.01<timeIteration && timeIteration<this.time+0.01) {
                if (this.time>timeIteration) {
                    rate/=1.00005;
                    timeIteration=Math.log(-this.futureValue/this.presentValue)/Math.log(rate/100+1);
                }
                else if (this.time<timeIteration) {
                    rate*=1.0001;
                    timeIteration=Math.log(-this.futureValue/this.presentValue)/Math.log(rate/100+1);
                }
            }    
            System.out.println((rate-1)*100);
        }
    }
    
    private double iterate (double FV, double PV, double rate) {
        double iterateTime = Math.log(-FV/PV)/Math.log(rate/100+1);
        return iterateTime;
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
        double paymentMultiple = 1/(this.interestRate/100)*(1-1/Math.pow((this.interestRate/100+1), this.time));
        this.payment=this.presentValue/paymentMultiple;
        System.out.println(this.payment);
    }
    
    public void ComputeFV () {
        double rate = 1 + this.interestRate/100;
        this.futureValue-=this.presentValue*rate;
        for (int i=1; i<this.time; i++) {
            this.futureValue-=this.payment;
            this.futureValue*=rate;
        }
        System.out.println(this.futureValue);
    }
}
