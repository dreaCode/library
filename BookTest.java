import org.junit.*;
import static org.junit.Assert.*;
import java.util.GregorianCalendar;

/**
 * BookTest.
 *
 * @author Andrea Hemphill 
 * @version 6/14/15
 */
public class BookTest extends AbstractMediaItemTest
{   

    private static final GregorianCalendar DAY_1 = 
                                new GregorianCalendar(2012, 9, 1);
    private static final GregorianCalendar DAY_2 = 
                                new GregorianCalendar(2012, 9, 2);
    private static final GregorianCalendar DAY_15 =
                                new GregorianCalendar(2012, 9, 15);
    private static final Money NO_FEE = new Dollar(0.0);
    private static final Money ONE_DAY_FEE = new Dollar(0.25);
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        // Set up test fixture
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        // Tear down test fixture
    }

    /**
     * Creates a concrete item to test. DO NOT MODIFY THIS METHOD.
     * 
     * @see AbstractMediaItemTest#createItem()
     * @return the item
     */
    protected AbstractMediaItem createItem()
    {
        AbstractMediaItem book = new Book();
       
        return book;
    }
    
    /**
     * Test calculating the overdue fees.
     */
    @Test
    public void testCalculateFeesMethod()
    {
        AbstractMediaItem a = createItem();
        String feeString = "25";
        
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
     * Tests initial title. 
     *
     */
    @Test
    public void testGetAuthor()
    {

        Book b1 = new Book();
        b1.setAuthor("John");
        assertEquals("John", b1.getAuthor());
    }

    /**
     * Tests set title. 
     * 
     * 
     */
    @Test
    public void testSetAuthor()
    {
        Book b1 = new Book();
        b1.setAuthor("John");
        assertEquals("John", b1.getAuthor());

    }

}
