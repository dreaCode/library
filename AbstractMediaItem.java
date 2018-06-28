import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Defines an abstract media item in a library system.
 * 
 * 
 * @author Andrea Hemphill 
 * @version 6/14/15
 */
public abstract class AbstractMediaItem implements MediaItem
{
    // instance variables
    private String callNum;
    private int copyNo;
    private String title;
    private String borrower;
    private GregorianCalendar dueDate;
    private static long millisPerDay = 86400000;


    /**
     * Returns the call number of the item.
     * 
     * @return      the call number. 
     */
    public String getCallNumber()
    {

        return callNum;
    }

    /**
     * Sets the call number. 
     * 
     * @param   callNo the call number for the item
     */
    public void setCallNumber(String callNo)
    {
        if (callNo != null && checkString(callNo))
        {
           
            callNum = callNo;
        }
        else
        {
            throw new IllegalArgumentException("cannot be null"); 
        }
        
    }

    /**
     * Returns the copy number of the item.
     * 
     * @return  the copy number.
     */
    public int getCopyNumber()
    {

        return copyNo;
    }

    /**
     * Sets copy number of the item.
     * 
     * @param   copy    the copy number.
     */
    public void setCopyNumber(int copy)
    {
        if (0 <= copy)
        {
            copyNo = copy;
        }
        else
        {
            throw new IllegalArgumentException("Copy must be positive");
        }
    }

    /**
     * Returns the title of the item.
     * 
     * @return  the title of the item.
     */
    public String getTitle()
    {

        return title;
    }

    /**
     * Sets the title of the item.
     * 
     * @param   itemTitle  the title.
     */
    public void setTitle(String itemTitle)
    {
        if (itemTitle != null && checkString(itemTitle))
        {
            title = itemTitle;
        }
        else
        {
            throw new IllegalArgumentException("Cannot be null");  
        }
        
    }

    /**
     * Returns the due date.
     * 
     * @return  the due date.
     */
    public GregorianCalendar getDueDate()
    {

        return dueDate;
    }

    /**
     * Sets the due date.
     * 
     * @param   date    the due date.
     */
    public void setDueDate(GregorianCalendar date)
    {
        
        
        if (date == null)
        {
            dueDate = null;
        }
        else 
        {
            dueDate = (GregorianCalendar)date.clone(); 
                
        }
        
     
        
    }

    /**
     * Returns the id of the person who borrowed the item.
     * 
     * @return  the borrower id. 
     */
    public String getBorrower()
    {

        return borrower;
    }

    /**
     * Set the borrower. 
     * 
     * @param   borrowerId    the id of the borrower.
     */
    public void setBorrower(String borrowerId)
    {
        if (borrowerId == null)
        {
            borrower = null;
        }
        
        else if (checkString(borrowerId))
        {
            borrower = borrowerId;
        }
       
    }

    /**
     * Calculates the fees owed by the borrower if the item is overdue.
     *
     * @param currentDate the date to be used in the calculation
     * @return the amount of overdue fees.
     */
    public Money calculateFees(GregorianCalendar currentDate)
    {
        Dollar noFee = new Dollar(0, 0);
        Dollar fee;
        if (0 <= dueDate.compareTo(currentDate))
        {
            return noFee;
        }
        else
        {
            GregorianCalendar nowDate = currentDate;
            int days = (int)((nowDate.getTimeInMillis() - 
                        dueDate.getTimeInMillis()) / millisPerDay);
            double amount = days * .5;
            fee = new Dollar(amount);
            return fee;

        }

    }
    
    /**
     * Checks String for special characters. 
     * 
     * @param   input String to be checked.
     * @return  boolean true if input is usuable.
     */
    public boolean checkString(String input)
    {
        String iae = "Input cannot contain special characters" +
                    "\n Input cannot be null or blank";
        
        Pattern p = Pattern.compile("[^.a-z0-9\\s]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        boolean sc = m.find();
        
        if (input != null && !sc && !input.equals(""))
        {
            return true;
           
        }
        else 
        {
            throw new IllegalArgumentException(iae); 
        }
        
    }
}
