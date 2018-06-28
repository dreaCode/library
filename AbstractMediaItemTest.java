import org.junit.*;
import static org.junit.Assert.*;
import java.util.GregorianCalendar;

/**
 * The test class AbstractMediaItemTest.
 *
 * @author Andrea Hemphill 
 * @version 6/14/15
 */
public abstract class AbstractMediaItemTest 
{
    private static final String CALL_NUMBER = "CALL NUMBER";
    private static final int FIRST_COPY = 1;
    private static final String TITLE = "TITLE 1";
    private static final GregorianCalendar DAY_1 = 
                                new GregorianCalendar(2012, 9, 1);
    private static final GregorianCalendar DAY_2 = 
                                new GregorianCalendar(2012, 9, 2);
    private static final GregorianCalendar DAY_15 =
                                new GregorianCalendar(2012, 9, 15);
    private static final String BORROWER = "BORROWER 1";
    private static final Money NO_FEE = new Dollar(0.0);
    private static final Money ONE_DAY_FEE = new Dollar(0.50);
    private static final String UPPER_CASE = "AAAAAA";
    private static final String LOWER_CASE = "zzzzzz";
    private static final String NUMBERS = "121212";
    private static final String DECIMAL_CALL = "BOOK12.34";
    private static final String SPACE_CALL = "BOOK1 1234";
    
    
    private static final int COPY_ZERO = 0;
    private static final int COPY_MINUS_ONE = -1;
    private static final String SPECIAL_CHARS = "!@#$%,/;";
    
    private AbstractMediaItem ami;
    
    /**
     * Use the constructor to instantiate the object in the abstract test.
     */
    public AbstractMediaItemTest()
    {
        //create the test item on constructor.
        //this has to be done or tests won't
        //execute
        ami = createItem(); 
    }
    
    /**
     * Test media item mutator and accessor methods.
     */
    @Test
    public void testItemGetSetMethods()
    {
        AbstractMediaItem a = createItem();
        
        // copy number tests             
        a.setCopyNumber(FIRST_COPY);
        assertEquals("Hint: getCopyNumber() return value does not match " +
                     "set value. ",
                     FIRST_COPY, a.getCopyNumber());
                     
        a.setCopyNumber(COPY_ZERO);
        assertEquals("Hint: getCopyNumber() return value does not match " +
                     "set value. ",
                     COPY_ZERO, a.getCopyNumber());
                     
                     
                     
         // call number tests            
        a.setCallNumber(CALL_NUMBER);
        assertEquals("Hint: getCallNumber() return value does not match " +
                     "set value. ",
                     CALL_NUMBER, a.getCallNumber());
                     
                     
        a.setCallNumber(UPPER_CASE);
        assertEquals("Hint: getCopyNumber() return value does not match " +
                     "set value. ",
                     UPPER_CASE, a.getCallNumber());  
                     
        a.setCallNumber(LOWER_CASE);
        assertEquals("Hint: getCopyNumber() return value does not match " +
                     "set value. ",
                     LOWER_CASE, a.getCallNumber());
        
        a.setCallNumber(NUMBERS);
        assertEquals("Hint: getCopyNumber() return value does not match " +
                     "set value. ",
                     NUMBERS, a.getCallNumber());
                     
        a.setCallNumber(DECIMAL_CALL);
        assertEquals("Hint: getCopyNumber() return value does not match " +
                     "set value. ",
                     DECIMAL_CALL, a.getCallNumber());
                    
        a.setCallNumber(SPACE_CALL);
        assertEquals("Hint: getCopyNumber() return value does not match " +
                     "set value. ",
                     SPACE_CALL, a.getCallNumber());
        
        //Title tests
                     
        a.setTitle(TITLE);
        assertEquals("Hint: getTitle() return value does not match " +
                     "set value. ",
                     TITLE, a.getTitle());
                     
        // Due Date tests
        a.setDueDate(DAY_1);
        assertEquals("Hint: getDueDate() return value does not match " +
                     "set value. ",
                     DAY_1, a.getDueDate());
                     
        a.setDueDate(DAY_2);
        assertEquals("Hint: getDueDate() return value does not match " +
                     "set value. ",
                     DAY_2, a.getDueDate());
                     
        a.setDueDate(DAY_15);
        assertEquals("Hint: getDueDate() return value does not match " +
                     "set value. ",
                     DAY_15, a.getDueDate());
                     
        // Borrower tests
        a.setBorrower(BORROWER);
        assertEquals("Hint: getBorrower() return value does not match " +
                     "set value. ",
                      BORROWER, a.getBorrower());
    }
    
    /**
     * Test calculating the overdue fees.
     */
    @Test
    public void testCalculateFeesMethod()
    {
        AbstractMediaItem a = createItem();
        String feeString = "50";
        
        // Test when the current date is before the due date
        a.setDueDate(DAY_15);
        assertEquals("Hint: calculateFees() should return 0.0 " +
                     "if current date is before due date. ",
                     NO_FEE, a.calculateFees(DAY_1));

        // Test when the current date equals the due date
        assertEquals("Hint: calculateFees() should return 0.0 " +
                     "if current date equals due date. ",
                     NO_FEE, a.calculateFees(DAY_15));

        // Test when the current date is one day after the due date
        a.setDueDate(DAY_1);
        assertEquals("Hint: calculateFees() should return a fee " +
                     "equal to " + feeString +
                     " cents for every day overdue. ",
                     ONE_DAY_FEE, a.calculateFees(DAY_2));

        // Test when the current date is two weeks after the due date
        assertEquals("Hint: calculateFees() should return a fee " +
                     "equal to " + feeString + 
                     " cents for every day overdue. ",
                     ONE_DAY_FEE.mul(14),
                     a.calculateFees(DAY_15));                
    }

    
    /**
     * Retrieves a concrete item object for testing.
     * 
     * @return the item object for testing.
     */
    protected abstract AbstractMediaItem createItem();
    
    /**
     * Test to make sure IllegalArgumentException is thrown.
     * The following two test cases demonstrate how to 
     * catch exceptions with JUnit 3 & Junit 4 syntax.
     
    
    public void testCallNumberNullVersion1()
    {
        boolean passed = false;
        try
        {
            ami.setCallNumber(null);
        }
        catch (IllegalArgumentException iaex)
        {
            passed = true;
        }
        assertTrue("Hint: Exception not thrown as expected "
            + "for null argument to call number mutator."
            , passed);
    }
    */

    /**
     * Test to make sure CallNumber cannot be null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCallNumberNullVersion2()
    {
        assertNotNull("Could not create AbstractMediaItem "
            + "from factory pattern"
            , ami);
        ami.setCallNumber(null);
    }
    /**
     * Test to make sure CopyNumber cannot be negative.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCopyNumberNegative()
    {
        ami.setCopyNumber(COPY_MINUS_ONE);
        assertEquals("Hint: getCopyNumber() return value does not match " +
                     "set value. ",
                     COPY_MINUS_ONE, ami.getCopyNumber());
                     
    }
    
    /**
     * Test to make sure input Strings are correct.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckString()
    {
        ami.checkString(SPECIAL_CHARS);
        assertNotNull("Could not create AbstractMediaItem "
            + "from factory pattern"
            , ami);
        ami.checkString(null);
    }
}
