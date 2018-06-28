import java.util.GregorianCalendar;
/**
 * Book an item found at the library.
 * 
 * @author Andrea Hemphill  
 * @version 6/14/15
 */
public class Book extends AbstractMediaItem
{
    private String author;

    /**
     * Returns the name of the author.
     * 
     * @return  the name of the author.
     */
    public String getAuthor()
    {

        return author;
    }    

    /**
     * Sets the name of the author.
     * 
     * @param   name    the name of the author.
     */
    public void setAuthor(String name)
    {
        if (name != null && checkString(name))
        {
            author = name;
        } 
        else
        {
            throw new IllegalArgumentException("Cannot be null"); 
        }
    } 

    /**
     * Calculates the fees owed by the borrower if the item is overdue.
     * 
     * @param currentDate the date to use for the calculation
     * @return the amount of overdue fees.
     */
    @Override
    public Money calculateFees(GregorianCalendar currentDate)
    {
       
        return  super.calculateFees(currentDate).mul(.5);

    }
}
