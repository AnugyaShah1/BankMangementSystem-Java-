
/**
 * Write a description of class BankCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BankCard
{
    //attributes
    private int cardId ;
    private String clientName;
    private String issuerBank;
    private String bankAccount;
    private double balanceAmount;
    
    // a constructor that has 4 parameters 
    public BankCard(int cardId, String bankAccount, String issuerBank, double balanceAmount){
        //client name which is intilize to an empty string
        clientName = "";
        this.cardId = cardId;
        this.bankAccount = bankAccount;
        this.issuerBank = issuerBank;
        this.balanceAmount = balanceAmount;
    }
    
    //Accessor method
    public String getclientName(){
        return clientName;
    }
    
    public String getissuerBank(){
        return issuerBank;
    }
    
    public String getbankAccount(){
        return bankAccount;
    }
    
    public int getcardId(){
        return cardId;
    }
    
    public double getbalanceAmount(){
        return balanceAmount;
    }
    
    //new mehtods
    public void setclientName(String clientName){
        this.clientName = clientName;
    }
    
    public void setbalanceAmount(double balanceAmount){
        this.balanceAmount = balanceAmount;
    }
    
    //display method
    public void display(){
        if (clientName.isEmpty()){
            System.out.println("Please Enter The Client Name!");
        }else{
            System.out.println("Client Name:" + clientName);
            System.out.println("Card Id:" + cardId);
            System.out.println("Bank Account :" + bankAccount);
            System.out.println("Issuer Bank:" + issuerBank);
            System.out.println("Balance Amount:" + balanceAmount);
        }
    }
}
