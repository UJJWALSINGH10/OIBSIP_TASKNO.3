import java.util.Scanner;


class ATMinterface
{
    float balance=0.0f;
    int pin=0;
    int c=0;
    int id;
    int trans=0;
    String transhis="";
    Scanner sc= new Scanner(System.in);
    public void usermenu()
    {
        System.out.println("1.CREATE NEW PIN");
        System.out.println("2. LOGIN");
        System.out.println("3. EXIT");
        System.out.println("ENTER YOUR CHOICE ");
        int ch=sc.nextInt();
        switch(ch)
        {
            case 1: setPIN(); break;
            case 2: check(); break;
            case 3: quit(); break;
            default:
                System.out.println("INVALID CHOICE");
                usermenu();
        }
    }
    public void setPIN()
    {
        System.out.println("ENTER USER ID");
        id=sc.nextInt();
        System.out.println("SET PIN");
        pin=sc.nextInt();
        System.out.println("CONFIRM PIN");
        int conpin=sc.nextInt();
        if(conpin!=pin)
        {
            System.out.println("PIN DOES NOT MATCH");
            setPIN();
        }
        else {
            System.out.println("PIN HAS BEEN SET");
            c++;
        usermenu();}

    }

    public void check()
    {

        if(c!=0)
        {
            System.out.println("Enter your PIN ");
            int  userPIN = sc.nextInt();
            if (userPIN == pin)
                menu();
            else {
                System.out.println("Invalid PIN");
            }
        }
        else {
            System.out.println("NO PIN IS SET......PLEASE SET PIN FIRST");
            usermenu();
        }
    }
    public void menu()
    {
        System.out.println("Enter your choice ");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw ");
        System.out.println("3. Deposit ");
        System.out.println("4. Transfer ");
        System.out.println("5. Check balance");
        System.out.println("6. Quit");
        int choice= sc.nextInt();
        switch(choice)
        {
            case 1: transactionHistory();
            break;
            case 2: withdraw();
            break;
            case 3: deposit();
            break;
            case 4:transfer();
            break;
            case 5:checkbalance();
            break;
            case 6: quit();
            break;
            default:
                System.out.println("Invalid choice ");
                break;
        }
    }
    public void transactionHistory()
    {
        if(trans==0) {
            System.out.println("No history");
        menu();}
        else {
            System.out.println("" +transhis);
        menu();}
    }
    public void withdraw()
    {
        System.out.println(" Enter amount to withdraw");
        int withamu=sc.nextInt();
        if(withamu>balance) {
            System.out.println("Insufficient Balance ");
            menu();
        }
        else {
            System.out.println(withamu+" Rupees withdraw");
            balance=balance-withamu;
            trans++;
            transhis=transhis+withamu+" Rupees withdraw"+"\n";
            menu();
        }
    }
    public void deposit()
    {
        System.out.println("Enter amount to deposit ");
        int dep=sc.nextInt();

            balance=balance+dep;
            System.out.println(dep+" Rupees deposited");
            transhis=transhis+dep+" Rupees deposited"+"\n";
            trans++;
            menu();



    }
    public void transfer()
    {
        System.out.println("Enter recipient Account number  ");
        int rec=sc.nextInt();
        System.out.println("Enter transfer amount ");
        int trans=sc.nextInt();
        if(trans>balance) {
            System.out.println("Insufficient Balance");
        menu();}
        else {
            balance=balance-trans;
            System.out.println(trans+" is transferred to "+rec);
            transhis=transhis+trans+" Rupees transferred to "+rec+"\n";
            trans++;
            menu();

        }

    }
    public void checkbalance()
    {
        System.out.println(" Current balance :"+balance);
        menu();
    }
    public void quit()
    {
        System.exit(0);
    }

    public static void main(String[] args) {
        ATMinterface obj=new ATMinterface();
        obj.usermenu();
    }
}