
/**
 * Write a description of class DebitCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DebitCard extends BankCard
{
   //four attributes
   private int PINnumber;
   private int withdrawalAmount;
   private String dateOfWithdrawal;
   private boolean hasWithdrawn;
   
   //constructor 
   public DebitCard(double balanceAmount, int cardId, String bankAccount, String issuerBank, String clientName, int PINnumber){
       //calling superclass construtor
       super( cardId, bankAccount, issuerBank, balanceAmount);
       // calling setclientname from superclass
       super.setclientName(clientName);
       //assigning attributes with correspondnig parameter values
       this.PINnumber = PINnumber;
       hasWithdrawn = false;
   }
   
   //corresponding Accessor method for each Attribute 
   public int getPINnumber(){
       return PINnumber;
   }
   
   public int getwithdrawalAmount(){
       return withdrawalAmount;
   }
   
   public boolean gethasWithdrawn(){
       return hasWithdrawn;
   }
   
   public String getdateOfWithdrawal(){
       return dateOfWithdrawal;
   }
   
   //mutator method
   public void setwithdrawalAmount(int withdrawalAmount){
       this.withdrawalAmount = withdrawalAmount;
   }
   
   //withdraw method
   public void Withdraw(int withdrawalAmount, String dateOfWithdrawal, int PINnumber){
       //checking PINnumber valid or not 
       if(PINnumber == this.PINnumber){
           if(withdrawalAmount <= super.getbalanceAmount()){
               this.hasWithdrawn = true;
               
               super.setbalanceAmount(super.getbalanceAmount() - (withdrawalAmount));
               this.withdrawalAmount = withdrawalAmount;
               this.dateOfWithdrawal = dateOfWithdrawal;

               System.out.println("Your Transaction has been Sucessful.");
               System.out.println("Your Current Balance Amount is " + super.getbalanceAmount());
           }else{
               System.out.println("Insufficient Balance!!!");
           }
       }else{
           System.out.println("Invalid PIN Number!!!");
       }
   }
   
   //display method
   public void display(){
       //display method from bank card
       super.display();
       
       //displaying pin number,withdrawal amount, date of withdrawal if there is a withdrawal
       if(hasWithdrawn = true){
           System.out.println("PIN number: " + PINnumber);
           System.out.println("Withdrawal Amount: " + withdrawalAmount);
           System.out.println("Date Of Withdrawal: " + dateOfWithdrawal);
       }else{
          System.out.println("There has been No Transaction! Your Current Balance Amount is " + super.getbalanceAmount()); 
       }
   }
}
