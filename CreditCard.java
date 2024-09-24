
/**
 * Write a description of class CreditCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CreditCard extends BankCard
{
    //six Attributes
    private int CVCnumber;
    private double creditLimit;
    private double interestRate;
    private String expirationDate;
    private int gracePeriod;
    private boolean isGranted;
    
    public CreditCard(int cardId, String clientName, String issuerBank, String bankAccount, double balanceAmount, int CVCnumber, double interestRate, String expirationDate){
        //calling super class conductor
        super(cardId, bankAccount, issuerBank, balanceAmount);
        //calling setclientname from superclass
        super.setclientName(clientName);
        //assigning attributes with correspondnig parameter values
        this.CVCnumber = CVCnumber;
        this.interestRate = interestRate;
        this.expirationDate = expirationDate;
        this.isGranted = false;
    }
    
    //accessor method for each corresponding Attribute
    public int getCVCnumber(){
        return CVCnumber;
    }
    
    public double getcreditLimit(){
        return creditLimit;
    }
    
    public double interestRate(){
        return interestRate;
    }
    
    public String expirationDate(){
        return expirationDate;
    }
    
    public int gracePeriod(){
        return gracePeriod;
    }
    
    public boolean isGranted(){
        return isGranted;
    }
    
    public void setcreditLimit(double newCreditLimit, int newgracePeriod){
        this.creditLimit = creditLimit;
        this.gracePeriod = gracePeriod;
        this.expirationDate = expirationDate;
        if(newCreditLimit <= (2.5) * getbalanceAmount()){
            this.creditLimit = newCreditLimit;
            this.gracePeriod = newgracePeriod;
            this.isGranted = true;
        }else{
            System.out.println("Credit limit is Exceeded. The Credit cannot be Granted!");
        }
    }

    //m
    public void cancelCreditCard(){
        this.CVCnumber = 0;
        this.creditLimit = 0;
        this.gracePeriod = 0;
        this.isGranted = false;
    }

    //display method
    public void display()
    {
        super.display();
        if(isGranted == true){
            System.out.println("Credit limit is granted");
            System.out.println("Credit Limit: " + this.creditLimit);
            System.out.println("Grace Period: " + this.gracePeriod);
        }else{
            System.out.println("Credit is not granted.");
        }
        System.out.println("Expiration Date:" + this.expirationDate);
    }
}
