
public class timeValueMoney {
    double time;
    double interestRate;
    double presentValue;
    double payment;
    double futureValue;
    timeValueMoney(double N, double IY, double PV, double PMT, double FV) {
        time = N ;
        interestRate = IY;
        presentValue = PV;
        payment = PMT;
        futureValue = FV;
    }
    double ComputeTime () {
        time = Math.log(-futureValue/presentValue)/Math.log(interestRate/100+1);
        System.out.println(time);
        return time;
    }
    double ComputeInterest () {
        if (payment == 0) {
            double discountRate;
            discountRate = futureValue/presentValue;
            discountRate = Math.pow(-discountRate, 1/time);
            System.out.println((discountRate-1)*100);
            return discountRate;
        }
        else {
            interestRate=5;
            double rate = 1 + interestRate/100;
            double timeIteration=0;
            while (time-0.01<timeIteration && timeIteration<time+0.01) {
                if (time>timeIteration) {
                    rate/=1.00005;
                    timeIteration=Math.log(-futureValue/presentValue)/Math.log(rate/100+1);
                }
                else if (time<timeIteration) {
                    rate*=1.0001;
                    timeIteration=Math.log(-futureValue/presentValue)/Math.log(rate/100+1);
                }
            }    
            System.out.println((rate-1)*100);
            return interestRate;
        }
    } 
    double ComputePresentValue () {
        double rate = 1 + interestRate/100;
        presentValue-=futureValue/rate;
        for (int i=0; i<time; i++) {
            presentValue+=payment;
            presentValue/=rate;
        }
        System.out.println(presentValue);
        return presentValue;
    }    
    double ComputePayment () {
        double paymentMultiple = 1/(interestRate/100)*(1-1/Math.pow((interestRate/100+1), time));
        payment=presentValue/paymentMultiple;
        System.out.println(payment);
        return payment;
    }   
    double ComputeFutureValue () {
        double rate = 1 + interestRate/100;
        futureValue-=presentValue*rate;
        for (int i=1; i<time; i++) {
            futureValue-=payment;
            futureValue*=rate;
        }
        System.out.println(futureValue);
        return futureValue;
    }
}
