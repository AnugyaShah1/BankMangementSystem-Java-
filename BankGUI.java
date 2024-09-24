
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Graphics;
import java.util.*;

/**
 * Write a description of class BankGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BankGUI implements ActionListener {
    private JFrame frame;

    private JLabel 
    dcLabel, dcCardIdL, dcNameL, dcIssuerBankL, dcBankAccountL, dcBalanceAmountL, dcPinNumL, 
    ccLabel, ccCardIdL, ccNameL, ccIssuerBankL, ccBankAccountL, ccBalanceAmountL, ccCVCNumL, ccInterestRateL,
    wLabel, wCardIdL, wWithdrawalAmountL, wPinNumL,
    sLabel, sCardIdL, sCreditLimitL, sGracePeriodL,
    wDateL, expiDateL;

    private JTextField 
    dcCardIdTF, dcNameTF, dcIssuerBankTF, dcBankAccountTF, dcBalanceAmountTF, dcPinNumTF, 
    ccCardIdTF, ccNameTF, ccIssuerBankTF, ccBankAccountTF, ccBalanceAmountTF, ccCVCNumTF, ccInterestRateTF,
    wCardIdTF, wWithdrawalAmountTF, wPinNumTF,
    sCardIdLTF, sCreditLimitTF, sGracePeriodTF;

    private JButton 
    dcAddDC, ccAddCC, wWithdraw, sSetCredit, sCancelCredit, ccDisplayButton, dcDisplayButton, clearButton;

    private JComboBox dayCombo, monthCombo, yearCombo, eDayCombo, eMonthCombo, eYearCombo;

    private JSeparator seperator1, seperator2, seperator3;
    // Creating a ArrayList 
    ArrayList<BankCard> CardList = new ArrayList<BankCard>();

    // Object for Debit Card
    DebitCard debitOBJ;
    // Object for Credit Card 
    CreditCard creditOBJ;

    public BankGUI(){
        Font font = new Font("Monospaced", Font.PLAIN, 13);

        //adding a FRAME
        frame = new JFrame("bankGUI");

        //ADDING OTHER COMPONENTS
        JLabel header = new JLabel("Bank");

        //Debit Card label
        dcLabel = new JLabel("TO ADD DEBIT CARD");
        dcCardIdL = new JLabel("CARD ID");
        dcNameL = new JLabel("NAME");
        dcIssuerBankL = new JLabel("ISSUER BANK");
        dcBankAccountL = new JLabel("BANK ACCOUNT");
        dcBalanceAmountL = new JLabel("BALANCE AMOUNT");
        dcPinNumL = new JLabel("PIN NUMBER");

        //Debit Card text field
        dcCardIdTF = new JTextField();
        dcNameTF = new JTextField();
        dcIssuerBankTF = new JTextField();
        dcBankAccountTF = new JTextField();
        dcBalanceAmountTF = new JTextField();
        dcPinNumTF = new JTextField();

        //Credit Card label
        ccLabel = new JLabel("TO ADD CREDIT CARD");
        ccCardIdL = new JLabel("CARD ID");
        ccNameL = new JLabel("NAME");
        ccIssuerBankL = new JLabel("ISSUER BANK");
        ccBankAccountL = new JLabel("BANK ACCOUNT");
        ccBalanceAmountL = new JLabel("BALANCE AMOUNT");
        ccCVCNumL = new JLabel("CVC NUMBER");
        ccInterestRateL = new JLabel("INTEREST RATE");

        //Credit Card text field
        ccCardIdTF = new JTextField();
        ccNameTF = new JTextField();
        ccIssuerBankTF = new JTextField();
        ccBankAccountTF = new JTextField();
        ccBalanceAmountTF = new JTextField();
        ccCVCNumTF = new JTextField();
        ccInterestRateTF = new JTextField();

        //Withdraw Label
        wLabel = new JLabel("TO  WITHDRAW");
        wCardIdL = new JLabel("CARD ID");
        wWithdrawalAmountL = new JLabel("WITHDRAWAL AMOUNT");
        wPinNumL = new JLabel("PIN NUMBER");

        //Withdraw Text Field
        wCardIdTF = new JTextField();
        wWithdrawalAmountTF = new JTextField();
        wPinNumTF = new JTextField();

        // Set Credit Label
        sLabel = new JLabel("TO SET CREDIT LIMIT");
        sCardIdL = new JLabel("CARD ID");
        sCreditLimitL = new JLabel("NEW CREDIT LIMIT");
        sGracePeriodL = new JLabel("NEW GRACE PERIOD");

        // Set Credit Text Field
        sCardIdLTF = new JTextField();
        sCreditLimitTF = new JTextField();
        sGracePeriodTF = new JTextField();

        //Buttons
        dcAddDC = new JButton("ADD DEBIT CARD");
        ccAddCC = new JButton("ADD CREDIT CARD"); 
        wWithdraw = new JButton("WITHDRAW");
        sSetCredit = new JButton("SET CREDIT");
        sCancelCredit = new JButton("CANCEL CREDIT");
        dcDisplayButton = new JButton("DISPLAY DEBIT CARD");
        ccDisplayButton = new JButton("DISPLAY CREDIT CARD");
        clearButton = new JButton("CLEAR");

        //Expiration Date ComboBox 
        expiDateL = new JLabel("EXPIRATION DATE");
        Integer[] eDay = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
        eDayCombo = new JComboBox(eDay);
        String[] eMonth = {"Jan","Feb","Mar","Apr","May","June","July","Aug","Sept","Oct","Nov","Dec"};
        eMonthCombo = new JComboBox(eMonth);
        Integer[] eYear = {2022,2023,2024,2025,2026,2027,2028,2029,2030};
        eYearCombo = new JComboBox(eYear);

        // Withdrawal Date ComboBox
        wDateL = new JLabel("WITHDRAWAL DATE");
        Integer[] day = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
        dayCombo = new JComboBox(day);
        String[] month = {"Jan","Feb","Mar","Apr","May","June","July","Aug","Sept","Oct","Nov","Dec"};
        monthCombo = new JComboBox(month);
        Integer[] year = {2022,2023,2024,2025,2026,2027,2028,2029,2030};
        yearCombo = new JComboBox(year);

        // using Seperators 
        seperator1 = new JSeparator();
        seperator2 = new JSeparator();
        seperator3 = new JSeparator();

        //SETTING BOUNDS
        header.setBounds(500, 3, 169, 67);

        //Debit Card Label
        dcLabel.setBounds(30, 44, 266, 50);

        dcCardIdL.setBounds(75, 90, 65, 15);
        dcNameL.setBounds(320, 90, 45, 15);
        dcIssuerBankL.setBounds(570, 90, 100, 15);
        dcBankAccountL.setBounds(815, 90, 100, 15);
        dcBalanceAmountL.setBounds(75, 142, 115, 15);
        dcPinNumL.setBounds(320, 142, 80, 15);

        //Debit Card text field
        dcCardIdTF.setBounds(75, 105, 186, 26);
        dcNameTF.setBounds(320, 105, 186, 26);
        dcIssuerBankTF.setBounds(570, 105, 186, 26);
        dcBankAccountTF.setBounds(815, 105, 186, 26);
        dcBalanceAmountTF.setBounds(75, 157, 186, 26);
        dcPinNumTF.setBounds(320, 157, 186, 26);

        //Credit Card label
        ccLabel.setBounds(30, 185, 266, 50);

        ccCardIdL.setBounds(75, 230, 65, 15);
        ccNameL.setBounds(320, 230, 45, 15);
        ccIssuerBankL.setBounds(570, 230, 95, 15);
        ccBankAccountL.setBounds(815, 230, 100, 15);
        ccBalanceAmountL.setBounds(75, 282, 115, 15);
        ccCVCNumL.setBounds(320, 282, 90, 15);
        ccInterestRateL.setBounds(570, 282, 105, 15);

        //Credit Card Text Field
        ccCardIdTF.setBounds(75, 245, 186, 26);
        ccNameTF.setBounds(320, 245, 186, 26);
        ccIssuerBankTF.setBounds(570, 245, 186, 26);
        ccBankAccountTF.setBounds(815, 245, 186, 26);
        ccBalanceAmountTF.setBounds(75, 297, 186, 26);
        ccCVCNumTF.setBounds(320, 297, 186, 26);
        ccInterestRateTF.setBounds(570, 297, 186, 26);

        //Withdraw Label
        wLabel.setBounds(90, 365, 266, 50);

        wCardIdL.setBounds(105, 408, 60, 15);
        wWithdrawalAmountL.setBounds(105, 460, 140, 15);
        wPinNumL.setBounds(105, 512, 80, 15);

        //Withdraw Text Field
        wCardIdTF.setBounds(105, 423, 186, 26);
        wWithdrawalAmountTF.setBounds(105, 475, 186, 26);
        wPinNumTF.setBounds(105, 527, 186, 26);

        //Set Credit Label
        sLabel.setBounds(585, 365, 266, 50);

        sCardIdL.setBounds(605, 408, 60, 15);
        sCreditLimitL.setBounds(605, 460, 150, 15);
        sGracePeriodL.setBounds(605, 512, 150, 15);

        //Set Credit Text Field
        sCardIdLTF.setBounds(605, 423, 186, 26);
        sCreditLimitTF.setBounds(605, 475, 186, 26);
        sGracePeriodTF.setBounds(605, 527, 186, 26);

        //Buttons
        dcAddDC.setBounds(820, 146, 150, 32);
        ccAddCC.setBounds(820, 335, 150, 32);
        wWithdraw.setBounds(315, 463, 150, 32);
        sSetCredit.setBounds(810, 443, 150, 32);
        sCancelCredit.setBounds(810, 488, 150, 32);
        dcDisplayButton.setBounds(600, 580, 165, 45);
        ccDisplayButton.setBounds(795, 580, 165, 45);
        clearButton.setBounds(200, 580, 120, 45);

        // Expiration Date Combo Box
        expiDateL.setBounds(815, 282, 120, 15);
        eDayCombo.setBounds(815, 297, 48, 26);
        eMonthCombo.setBounds(866, 297, 62, 26);
        eYearCombo.setBounds(931, 297, 71, 26);

        // Withdrawal date Combo Box
        wDateL.setBounds(315, 408, 120, 15);
        dayCombo.setBounds(315, 423, 48, 26); 
        monthCombo.setBounds(366, 423, 62, 26);
        yearCombo.setBounds(431, 423, 71, 26);

        // setting Bounds for the Separators
        seperator1.setBounds(20, 192, 1040, 1);
        seperator2.setBounds(20, 374, 1040, 1);
        seperator3.setBounds(20, 565, 1040, 1);

        // CHANGING TEXT STYLE
        // Changing Text of Main Headers 
        header.setFont(new Font("Times New Roman",Font.BOLD,35));
        dcLabel.setFont(new Font("Times New Roman",Font.BOLD,18));
        ccLabel.setFont(new Font("Times New Roman",Font.BOLD,18));
        sLabel.setFont(new Font("Times New Roman",Font.BOLD,18));
        wLabel.setFont(new Font("Times New Roman",Font.BOLD,18));

        //Changing Text of other Labels
        // Debit Card Labels
        dcCardIdL.setFont(font);
        dcNameL.setFont(font);
        dcIssuerBankL.setFont(font);
        dcBankAccountL.setFont(font);
        dcBalanceAmountL.setFont(font);
        dcPinNumL.setFont(font);

        //Credit Card Labels
        ccCardIdL.setFont(font);
        ccNameL.setFont(font);
        ccIssuerBankL.setFont(font);
        ccBankAccountL.setFont(font);
        ccBalanceAmountL.setFont(font);
        ccCVCNumL.setFont(font);
        ccInterestRateL.setFont(font);

        // Withdrawal Labels
        wCardIdL.setFont(font);
        wWithdrawalAmountL.setFont(font);
        wPinNumL.setFont(font);

        // Set Credit Labels
        sCardIdL.setFont(font);
        sCreditLimitL.setFont(font);
        sGracePeriodL.setFont(font);

        //Buttons
        dcAddDC.setFont(font);
        ccAddCC.setFont(new Font("Monospaced", Font.PLAIN, 12));
        wWithdraw.setFont(font);
        sSetCredit.setFont(font);
        sCancelCredit.setFont(font);

        dcDisplayButton.setFont(new Font("Times New Roman",Font.BOLD,11));
        ccDisplayButton.setFont(new Font("Times New Roman",Font.BOLD,11));
        clearButton.setFont(new Font("Times New Roman",Font.BOLD,15));

        //Expiration date combobox
        expiDateL.setFont(font);
        eDayCombo.setFont(font);
        eMonthCombo.setFont(font);
        eYearCombo.setFont(font);

        //Withdrawal date combobox
        wDateL.setFont(font);
        dayCombo.setFont(font);
        monthCombo.setFont(font);
        yearCombo.setFont(font);

        //ADDING COLORS TO THE GUI
        header.setForeground(Color.decode("#1c1caa"));

        // Main Headers 
        dcLabel.setForeground(Color.decode("#edac2b"));
        ccLabel.setForeground(Color.decode("#edac2b"));
        wLabel.setForeground(Color.decode("#edac2b"));
        sLabel.setForeground(Color.decode("#edac2b"));

        //Buttons
        dcAddDC.setBackground(Color.decode("#fade91"));
        ccAddCC.setBackground(Color.decode("#fade91"));
        wWithdraw.setBackground(Color.decode("#fade91"));
        sSetCredit.setBackground(Color.decode("#fade91"));
        sCancelCredit.setBackground(Color.decode("#fade91"));
        dcDisplayButton.setForeground(Color.decode("#1c1caa"));
        dcDisplayButton.setBackground(Color.decode("#fade91"));
        ccDisplayButton.setForeground(Color.decode("#1c1caa"));
        ccDisplayButton.setBackground(Color.decode("#fade91"));
        clearButton.setBackground(Color.decode("#fade91"));
        clearButton.setForeground(Color.decode("#1c1caa"));
        
        //adding buttons to addActionListener
        dcAddDC.addActionListener(this);
        ccAddCC.addActionListener(this);
        wWithdraw.addActionListener(this);
        sSetCredit.addActionListener(this);
        sCancelCredit.addActionListener(this);
        dcDisplayButton.addActionListener(this);
        ccDisplayButton.addActionListener(this);
        clearButton.addActionListener(this);
        
        //adding combo boxes to addActionListener
        dayCombo.addActionListener(this);
        monthCombo.addActionListener(this);
        yearCombo.addActionListener(this);
        eDayCombo.addActionListener(this);
        eMonthCombo.addActionListener(this);
        eYearCombo.addActionListener(this);

        //ADDING IT TO THE FRAME
        //header
        frame.add(header);
        
        //dc label
        frame.add(dcLabel);
        frame.add(dcCardIdL);
        frame.add(dcNameL);
        frame.add(dcIssuerBankL);
        frame.add(dcBankAccountL);
        frame.add(dcBalanceAmountL);
        frame.add(dcPinNumL);
        
        //dc Text fields
        frame.add(dcCardIdTF);
        frame.add(dcNameTF);
        frame.add(dcIssuerBankTF);
        frame.add(dcBankAccountTF);
        frame.add(dcBalanceAmountTF);
        frame.add(dcPinNumTF);
        
        // cc label
        frame.add(ccLabel);
        frame.add(ccCardIdL);
        frame.add(ccNameL);
        frame.add(ccIssuerBankL);
        frame.add(ccBankAccountL);
        frame.add(ccBalanceAmountL);
        frame.add(ccCVCNumL);
        frame.add(ccInterestRateL);
        
        // cc text fields
        frame.add(ccCardIdTF);
        frame.add(ccNameTF);
        frame.add(ccIssuerBankTF);
        frame.add(ccBankAccountTF);
        frame.add(ccBalanceAmountTF);
        frame.add(ccCVCNumTF);
        frame.add(ccInterestRateTF);
        
        // w label
        frame.add(wLabel);
        frame.add(wCardIdL);
        frame.add(wWithdrawalAmountL);
        frame.add(wPinNumL);
        
        // w text field
        frame.add(wCardIdTF);
        frame.add(wWithdrawalAmountTF);
        frame.add(wPinNumTF);
        
        // s label
        frame.add(sLabel);
        frame.add(sCardIdL);
        frame.add(sCreditLimitL);
        frame.add(sGracePeriodL);
        
        // s text fields
        frame.add(sCardIdLTF);
        frame.add(sCreditLimitTF);
        frame.add(sGracePeriodTF);
        
        //Buttons
        frame.add(dcAddDC);
        frame.add(ccAddCC);
        frame.add(wWithdraw);
        frame.add(sSetCredit);
        frame.add(sCancelCredit);
        frame.add(dcDisplayButton);
        frame.add(ccDisplayButton);
        frame.add(clearButton);

        //Combo box
        // expiration date
        frame.add(expiDateL);
        frame.add(eDayCombo);
        frame.add(eMonthCombo);
        frame.add(eYearCombo);

        //withdrawal date
        frame.add(wDateL);
        frame.add(dayCombo);
        frame.add(monthCombo);
        frame.add(yearCombo);

        //seperators
        frame.add(seperator1);
        frame.add(seperator2);
        frame.add(seperator3);

        frame.setSize(1100, 685);
        //frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Main Method
    public static void main (String[] args){
        // create obj of bankGUI
        BankGUI obj = new BankGUI();
    }

    // ActionListener
    public void actionPerformed(ActionEvent e){
        // ADD DEBIT CARD BUTTON
        if(e.getSource() == dcAddDC){
            // check all the values: 
            // checking if the text fields are empty
            if(dcCardIdTF.getText().isEmpty() || dcNameTF.getText().isEmpty() || dcIssuerBankTF.getText().isEmpty() || dcBankAccountTF.getText().isEmpty() || dcBalanceAmountTF.getText().isEmpty() ||  dcPinNumTF.getText().isEmpty()){
                // if values are not correct:
                // show message
                JOptionPane.showMessageDialog(frame,"Please Enter all the Details of the Debit Card ","ERROR DETECTED",JOptionPane.ERROR_MESSAGE);
            }else{
                try{
                    //get all the parameters
                    double balanceAmount = Integer.parseInt(dcBalanceAmountTF.getText());
                    int cardId = Integer.parseInt(dcCardIdTF.getText());
                    String bankAccount = dcBankAccountTF.getText();
                    String issuerBank = dcIssuerBankTF.getText();
                    String clientName = dcNameTF.getText();
                    int PINnumber = Integer.parseInt(dcPinNumTF.getText());
                    
                    //format checking for variables that are string
                    if(!(bankAccount.matches("[a-zA-Z]+"))){
                        JOptionPane.showMessageDialog(frame, "Please enter your Bank Account in alphabets only.", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(!(issuerBank.matches("[a-zA-Z]+"))){
                        JOptionPane.showMessageDialog(frame, "Please enter Issuer Bank Name in alphabets only.", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(!(clientName.matches("[a-zA-Z]+"))){
                        JOptionPane.showMessageDialog(frame, "Please enter your Name in alphabets only.", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    // checking if array list empty
                    if(CardList.isEmpty()){
                        //call the constructor / create the object
                        debitOBJ = new DebitCard(balanceAmount, cardId, bankAccount, issuerBank, clientName, PINnumber);
                        // adding the object to arraylist
                        CardList.add(debitOBJ);

                        //show message:
                        JOptionPane.showMessageDialog(frame,"Debit Card has been added successfully","DEBIT CARD ADDED",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        boolean UniqueDcCardId = true;
                        for(BankCard debitOBJ : CardList){
                            if(debitOBJ instanceof DebitCard){
                                if(debitOBJ.getcardId() == cardId){
                                    UniqueDcCardId = false;
                                    JOptionPane.showMessageDialog(frame,"Debit Card already exits.","CARD EXITS",JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                }
                            }
                        }
                        if(UniqueDcCardId){
                            //call the constructor / create the object
                            debitOBJ = new DebitCard(balanceAmount, cardId, bankAccount, issuerBank, clientName, PINnumber);
                            // adding the object to arraylist
                            CardList.add(debitOBJ);

                            //show message:
                            JOptionPane.showMessageDialog(frame,"Debit Card has been added successfully","DEBIT CARD ADDED",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Invalid Input!, Please enter numbers only", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // WITHDRAW BUTTON 
        if(e.getSource() == wWithdraw){
            if(wCardIdTF.getText().isEmpty() || wWithdrawalAmountTF.getText().isEmpty() || wPinNumTF.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame,"Please Enter all details for withdrawing. ","ERROR DETECTED",JOptionPane.ERROR_MESSAGE);
            }else{
                try{
                    int cardId = Integer.parseInt(wCardIdTF.getText());
                    int withdrawalAmount = Integer.parseInt(wWithdrawalAmountTF.getText());
                    String dateOfWithdrawal = dayCombo.getSelectedItem().toString() +"/"+ monthCombo.getSelectedItem().toString() +"/"+ yearCombo.getSelectedItem().toString();
                    int PINnumber = Integer.parseInt(wPinNumTF.getText());
                    double balanceAmount = Integer.parseInt(dcBalanceAmountTF.getText());
                    String wPopUP ="Card ID: " + cardId +"\n" + "Balance Amount: " + balanceAmount +"\n" + " Withdrawal Amount: " + withdrawalAmount +"\n" + "Date Of Withdrawal: " + dateOfWithdrawal +"\n"  + "PIN Number: " + PINnumber;
                    boolean sameCard = false;
                    for(BankCard debitOBJ : CardList){
                        if(debitOBJ instanceof DebitCard && debitOBJ.getcardId() == cardId){
                            DebitCard withdraw = (DebitCard) debitOBJ;
                            sameCard = true;
                            if (withdraw.getPINnumber() == PINnumber){
                                if(withdrawalAmount <= withdraw.getbalanceAmount()){
                                    withdraw.Withdraw(withdrawalAmount, dateOfWithdrawal, PINnumber);
                                    JOptionPane.showMessageDialog(frame, wPopUP, "WITHDRAWAL SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                                }else{
                                    JOptionPane.showMessageDialog(frame, "Insufficient Balance Amount.", "WITHDRAWAL UNSUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }else{
                                JOptionPane.showMessageDialog(frame, "The pin number you've entered is not CORRECT", "INVALID PIN NUMBER", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(frame, "The Card ID you've entered is not CORRECT", "INVALID CARD ID", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Please ensure all input values are in Number format.", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // ADD CREDIT CARD BUTTON
        if(e.getSource() == ccAddCC){
            if(ccCardIdTF.getText().isEmpty() || ccNameTF.getText().isEmpty() || ccIssuerBankTF.getText().isEmpty() || ccBankAccountTF.getText().isEmpty() || ccBalanceAmountTF.getText().isEmpty() || ccCVCNumTF.getText().isEmpty() || ccInterestRateTF.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame,"Please Enter all the required values for Credit Card.","ERROR DETECTED",JOptionPane.ERROR_MESSAGE);
            }else{
                try{
                    int cardId = Integer.parseInt(ccCardIdTF.getText());
                    String clientName = ccNameTF.getText();
                    String issuerBank = ccIssuerBankTF.getText();
                    String bankAccount = ccBankAccountTF.getText();
                    double balanceAmount = Integer.parseInt(ccBalanceAmountTF.getText());
                    int CVCnumber = Integer.parseInt(ccCVCNumTF.getText());
                    double interestRate = Integer.parseInt(ccInterestRateTF.getText());
                    String expirationDate = eDayCombo.getSelectedItem().toString() + "/" + eMonthCombo.getSelectedItem().toString() + "/" + eYearCombo.getSelectedItem().toString();

                    if(!(clientName.matches("[a-zA-Z]+"))){
                        JOptionPane.showMessageDialog(frame, "Please enter your Name in alphabets only.", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(!(issuerBank.matches("[a-zA-Z]+"))){
                        JOptionPane.showMessageDialog(frame, "Please enter Issuer Bank Name in alphabets only.", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(!(bankAccount.matches("[a-zA-Z]+"))){
                        JOptionPane.showMessageDialog(frame, "Please enter your Bank Account in alphabets only.", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if(CardList.isEmpty()){
                        //call the constructor / create the object
                        creditOBJ = new CreditCard(cardId, clientName, issuerBank, bankAccount, balanceAmount, CVCnumber, interestRate, expirationDate);
                        // adding the object to arraylist
                        CardList.add(creditOBJ);

                        //show message:
                        JOptionPane.showMessageDialog(frame,"Credit Card has been added successfully","CREDIT CARD ADDED",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        boolean UniqueCcCardId = true;
                        for(BankCard creditOBJ : CardList){
                            if(creditOBJ instanceof CreditCard){
                                if(creditOBJ.getcardId() == cardId){
                                    UniqueCcCardId = false;
                                    JOptionPane.showMessageDialog(frame,"Credit Card already exits.","CARD EXITS",JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                }
                            }
                        }
                        if(UniqueCcCardId){
                            //call the constructor / create the object
                            creditOBJ = new CreditCard(cardId, clientName, issuerBank, bankAccount, balanceAmount, CVCnumber, interestRate, expirationDate);
                            CardList.add(creditOBJ);

                            //show message:
                            JOptionPane.showMessageDialog(frame,"Credit Card has been added successfully","CREDIT CARD ADDED",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Invalid Input!, Please enter numbers only", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        //  SET CREDIT LIMIT
        if (e.getSource() == sSetCredit){
            if(sCardIdLTF.getText().isEmpty() || sCreditLimitTF.getText().isEmpty() || sGracePeriodTF.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please Enter all the required values for Setting Credit Limit!", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);    
            }else{
                try{
                    int cardId = Integer.parseInt(sCardIdLTF.getText());
                    double newCreditLimit = Double.parseDouble(sCreditLimitTF.getText());
                    int newgracePeriod = Integer.parseInt(sGracePeriodTF.getText());
                    String setCCpopup = "Card Id: " + cardId + "\n" + "Credit Limit: " + newCreditLimit + "\n" + "Grace Period: " + newgracePeriod;
                    boolean sameCard = false;
                    for(BankCard creditOBJ : CardList){
                        if(creditOBJ instanceof CreditCard && creditOBJ.getcardId() == cardId){
                            CreditCard newCard = (CreditCard) creditOBJ;
                            newCard.setcreditLimit(newCreditLimit, newgracePeriod);
                            sameCard = true;
                            JOptionPane.showMessageDialog(frame,setCCpopup ,"CREDIT CARD UPDATED",JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }
                    if(!sameCard){
                        JOptionPane.showMessageDialog(frame,"The credit card you've entered does not EXIST.","CREDIT CARD NOT FOUND",JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Please ensure all input values are in Number format.", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);

                }
            }
        }
        //CANCEL CREDIT CARD
        if(e.getSource() == sCancelCredit){
            if(sCardIdLTF.getText().isEmpty() || sCreditLimitTF.getText().isEmpty() || sGracePeriodTF.getText().isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please Enter all the required values to Cancel Credit Limit!", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);    
            }else{
                try{
                    int CardIdCancel =  Integer.parseInt(sCardIdLTF.getText());
                    boolean sameCard = false;
                    for(BankCard card : CardList){
                        if(card instanceof CreditCard && card.getcardId() == CardIdCancel){
                            ((CreditCard) card).cancelCreditCard();
                            JOptionPane.showMessageDialog(frame, "Credit card with ID " + CardIdCancel + " has been canceled.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                            sameCard = true;
                            break;
                        }
                    }

                    if(!sameCard){
                        JOptionPane.showMessageDialog(frame, "Credit card with ID " + CardIdCancel + " does not EXIST.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                    }//Credit card with ID " + CardIdCancel + " does not EXIST.", "SUCCESS"
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Please enter correct format for Card ID.", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        //DISPLAY BUTTON
        //DEBIT CARD display button
        if(e.getSource() == dcDisplayButton){
            if(CardList.isEmpty()){
                JOptionPane.showMessageDialog(frame, "There is no card to be displayed.", "NOTHING TO DISPLAY", JOptionPane.INFORMATION_MESSAGE);
            }else{
                try{
                    double balanceAmount = Integer.parseInt(dcBalanceAmountTF.getText());
                    int cardId = Integer.parseInt(dcCardIdTF.getText());
                    String bankAccount = dcBankAccountTF.getText();
                    String issuerBank = dcIssuerBankTF.getText();
                    String clientName = dcNameTF.getText();
                    int PINnumber = Integer.parseInt(dcPinNumTF.getText());

                    boolean cardPresent = false;
                    for(BankCard debitOBJ : CardList){
                        if(debitOBJ instanceof DebitCard && debitOBJ.getcardId() == cardId){
                            DebitCard dcDisplay = (DebitCard) debitOBJ;
                            dcDisplay.display();
                            cardPresent = true;
                        }
                    }
                    if(!cardPresent){
                        JOptionPane.showMessageDialog(frame, "The Debit Card does not Exist.", "CARD NOT FOUND", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Please ensure all the values are written.", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        //CREDIT CARD display button
        if(e.getSource() == ccDisplayButton){
            if(CardList.isEmpty()){
                JOptionPane.showMessageDialog(frame, "There is no card to be displayed.", "NOTHING TO DISPLAY", JOptionPane.INFORMATION_MESSAGE);
            }else{
                try{
                    int cardId = Integer.parseInt(ccCardIdTF.getText());
                    String clientName = ccNameTF.getText();
                    String issuerBank = ccIssuerBankTF.getText();
                    String bankAccount = ccBankAccountTF.getText();
                    double balanceAmount = Integer.parseInt(ccBalanceAmountTF.getText());
                    int CVCnumber = Integer.parseInt(ccCVCNumTF.getText());
                    double interestRate = Integer.parseInt(ccInterestRateTF.getText());
                    String expirationDate = eDayCombo.getSelectedItem().toString() + "/" + eMonthCombo.getSelectedItem().toString() + "/" + eYearCombo.getSelectedItem().toString();

                    boolean cardPresent = false;
                    for(BankCard creditOBJ : CardList){
                        if(creditOBJ instanceof CreditCard && creditOBJ.getcardId() == cardId){
                            CreditCard ccDisplay = (CreditCard) creditOBJ;
                            ccDisplay.display();
                            cardPresent = true;
                        }
                    }
                    if(!cardPresent){
                        JOptionPane.showMessageDialog(frame, "The Credit Card does not Exist.", "CARD NOT FOUND", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Please ensure all the values are written.", "ERROR DETECTED", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        //CLEAR BUTTON
        if(e.getSource() == clearButton){
            // set All the text fields to empty

            // setting Debit Card's text fields to empty
            dcCardIdTF.setText("");
            dcNameTF.setText("");
            dcIssuerBankTF.setText("");
            dcBankAccountTF.setText("");
            dcBalanceAmountTF.setText("");
            dcPinNumTF.setText("");

            // setting Credit Card's text fields to empty
            ccCardIdTF.setText("");
            ccNameTF.setText("");
            ccIssuerBankTF.setText("");
            ccBankAccountTF.setText("");
            ccBalanceAmountTF.setText("");
            ccCVCNumTF.setText("");
            ccInterestRateTF.setText("");

            // setting to Withdraw text fields to empty
            wCardIdTF.setText("");
            wWithdrawalAmountTF.setText("");
            wPinNumTF.setText("");

            // setting set Credit text fields to empty
            sCardIdLTF.setText("");
            sCreditLimitTF.setText("");
            sGracePeriodTF.setText("");
            
            
        }
    }
}

