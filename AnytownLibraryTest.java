import org.junit.*;
import static org.junit.Assert.*;
import java.util.GregorianCalendar;
import java.util.Calendar;

/**
 * The test class AnytownLibraryTest.
 *
 * @author Andrea Hemphill 
 * @version 6/14/15
 */
public class AnytownLibraryTest
{
    private static final String BOOK1 = "BOOK1";
    private static final String AUDIO1 = "AUDIO1";
    private static final String VIDEO1 = "VIDEO1";
    private static final String BOOK2 = "BOOK2";
    private static final String AUDIO2 = "AUDIO2";
    private static final String VIDEO2 = "VIDEO2";
    private static final int FIRST_COPY = 1;
    private static final int SECOND_COPY = 2;
    private static final int THIRD_COPY = 3;
    private static final int FOURTH_COPY = 4;
    private static final String BORROWER = "BORROWER 1";
    private static final String BORROWER2 = "BORROWER 2";
    private static final String BORROWER3 = "BORROWER 3";
    private static final GregorianCalendar DAY_1 = 
            new GregorianCalendar(2012, 9, 1, 0, 0);
    private static final GregorianCalendar DAY_31 =
            new GregorianCalendar(2012, 9, 31, 0, 0);
    private static final GregorianCalendar DAY_32 = 
            new GregorianCalendar(2012, 10, 1, 0, 0);
    private AnytownLibrary library;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        library = new AnytownLibrary();
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
     * Test constructor.
     */
    @Test
    public void testContructor()
    {
        assertNotNull("Hint: Could not create an AnytownLibrary object. ", 
                       library);
    }

    /**
     * Test adding single copies of items to the library.
     */
    @Test
    public void testAddSingleCopyOfItem()
    {
        // Test adding a null item to library
        assertFalse("Hint: addItem() should return false if item is null. ",
                    library.addItem(null));
                    
        // Test adding a single book to the library
        Book b = new Book();
        b.setCallNumber(BOOK1);
        assertTrue("Hint: addItem() should return true when a Book " +
                   "object is added. ",
                   library.addItem(b));
        assertEquals("Hint: getCopyNumber() should return 1 when first " +
                     "copy of a Book is added. ",
                     FIRST_COPY, b.getCopyNumber());
        
        // Test adding a single audio recording to the library
        AudioRecording a = new AudioRecording();
        a.setCallNumber(AUDIO1);
        assertTrue("Hint: addItem() should return true when an " +
                   "AudioRecording object is added. ",
                   library.addItem(a));
        assertEquals("Hint: getCopyNumber() should return 1 when first " +
                     "copy of an AudioRecording is added. ",
                     FIRST_COPY, a.getCopyNumber());
        
        // Test adding a single video recording to the library
        VideoRecording v = new VideoRecording();
        v.setCallNumber(VIDEO1);
        assertTrue("Hint: addItem() should return true when a " +
                   "VideoRecording object is added. ",
                   library.addItem(v));
        assertEquals("Hint: getCopyNumber() should return 1 when first " +
                     "copy of an VideoRecording is added. ",
                     FIRST_COPY, v.getCopyNumber());
                     
        // Test adding a second book to the library
        Book b2 = new Book();
        b2.setCallNumber(BOOK2);
        assertTrue("Hint: addItem() should return true when a Book " +
                   "object is added. ",
                   library.addItem(b2));
        assertEquals("Hint: getCopyNumber() should return 1 when first " +
                     "copy of a Book is added. ",
                     FIRST_COPY, b2.getCopyNumber());
        
        // Test adding a second audio recording to the library
        AudioRecording a2 = new AudioRecording();
        a2.setCallNumber(AUDIO2);
        assertTrue("Hint: addItem() should return true when an " +
                   "AudioRecording object is added. ",
                   library.addItem(a2));
        assertEquals("Hint: getCopyNumber() should return 1 when first " +
                     "copy of an AudioRecording is added. ",
                     FIRST_COPY, a2.getCopyNumber());
        
        // Test adding a second video recording to the library
        VideoRecording v2 = new VideoRecording();
        v2.setCallNumber(VIDEO2);
        assertTrue("Hint: addItem() should return true when a " +
                   "VideoRecording object is added. ",
                   library.addItem(v2));
        assertEquals("Hint: getCopyNumber() should return 1 when first " +
                     "copy of an VideoRecording is added. ",
                     FIRST_COPY, v2.getCopyNumber());      
    }
    
    /**
     * Test adding multiple copies of items to the library.
     */
    @Test
    public void testAddMultipleCopiesOfItem()
    {
                    
        // Test adding two copies of a book to the library
        Book b = new Book();
        Book b2 = new Book();
        b.setCallNumber(BOOK1);
        b2.setCallNumber(BOOK1);
        library.addItem(b);
        library.addItem(b2);       
        assertEquals("Hint: getCopyNumber() should return 1 for the first " +
                     "copy of a Book added to library. ",
                     FIRST_COPY, b.getCopyNumber());
        assertEquals("Hint: getCopyNumber() should return 2 for the second " +
                     "copy of a Book added to library. ",
                     SECOND_COPY, b2.getCopyNumber());
        
        // Test adding two copies of an audio recording to the library
        AudioRecording a = new AudioRecording();
        AudioRecording a2 = new AudioRecording();
        a.setCallNumber(AUDIO1);
        a2.setCallNumber(AUDIO1);
        library.addItem(a);
        library.addItem(a2);       
        assertEquals("Hint: getCopyNumber() should return 1 for the first " +
                     "copy of an AudioRecording added to library. ",
                     FIRST_COPY, a.getCopyNumber());
        assertEquals("Hint: getCopyNumber() should return 2 for the second " +
                     "copy of an AudioRecording added to library. ",
                     SECOND_COPY, a2.getCopyNumber());
        
        // Test adding two copies of a video recording to the library
        VideoRecording v = new VideoRecording();
        VideoRecording v2 = new VideoRecording();
        v.setCallNumber(VIDEO1);
        v2.setCallNumber(VIDEO1);
        library.addItem(v);
        library.addItem(v2);       
        assertEquals("Hint: getCopyNumber() should return 1 for the first " +
                     "copy of a VideoRecording added to library. ",
                     FIRST_COPY, v.getCopyNumber());
        assertEquals("Hint: getCopyNumber() should return 2 for the second " +
                     "copy of a VideoRecording added to library. ",
                     SECOND_COPY, v2.getCopyNumber());
    }

    /**
     * Test the library limit.
     */
    @Test
    public void testLibraryLimit()
    {
        // Test adding an item over the limit to the library
        Book b;
        for (int i = 0; i < AnytownLibrary.MAX_ITEMS; i++)
        {
            b = new Book();
            b.setCallNumber(BOOK1);
            assertTrue("Hint: addItem() should add up to 500 items " +
                       "to library. ", 
                       library.addItem(b));
        }
        b = new Book();
        b.setCallNumber(BOOK1);
        assertFalse("Hint: addItem() should return false if library " +
                    "limit is reached. ", library.addItem(b));
    }
        
    /**
     * Test finding single copies of items in the library.
     */
    @Test
    public void testFindSingleCopyOfItem()
    {
        // Test finding single copies of a book in the library
        Book b = new Book();
        Book b2 = new Book();
        b.setCallNumber(BOOK1);
        b2.setCallNumber(BOOK2);
        library.addItem(b);
        library.addItem(b2);
        MediaItem [] items = library.findItems(BOOK1);
        assertEquals("Hint: findItems() should return smallest possible " +
                     "array with matching items", 1, items.length);
        assertEquals("Hint: findItems() returned array with incorrect " +
                     "contents. ",
                     b, items[0]);
        items = library.findItems(BOOK2);
        assertEquals("Hint: findItems() should return smallest possible " +
                     "array with matching items", 1, items.length);
        assertEquals("Hint: findItems() returned array with incorrect " +
                     "contents. ",
                     b2, items[0]);                
    }
    
    /**
     * Test finding multiple copies of an item in the library.
     */
    @Test
    public void testFindMultipleCopiesOfItem()
    {
        // Test finding multiple copies of an audio recording in the library
        AudioRecording a = new AudioRecording();
        AudioRecording a2 = new AudioRecording();
        AudioRecording a3 = new AudioRecording();
        a.setCallNumber(AUDIO1);
        a2.setCallNumber(AUDIO2);
        a3.setCallNumber(AUDIO1);
        library.addItem(a);
        library.addItem(a2);
        library.addItem(a3);
        MediaItem [] items = library.findItems(AUDIO1);
        assertEquals("Hint: findItems() should return smallest possible " +
                     "array with matching items", 2, items.length);
        assertEquals("Hint: findItems() returned array with incorrect " +
                     "contents. ",
                     a, items[0]);
        assertEquals("Hint: findItems() returned array with incorrect " +
                     "contents. ",
                     a3, items[1]);
        items = library.findItems(AUDIO2);
        assertEquals("Hint: findItems() should return smallest possible " +
                     "array with matching items", 1, items.length);
        assertEquals("Hint: findItems() returned array with incorrect " +
                     "contents. ",
                     a2, items[0]);                
    }
    
    /**
     * Test finding no copies of an item in the library.
     */
    @Test
    public void testFindNoCopiesOfItem()
    {
        // Test finding no copies of a video recording in the library
        VideoRecording v = new VideoRecording();
        VideoRecording v2 = new VideoRecording();
        v.setCallNumber(VIDEO1);
        v2.setCallNumber(VIDEO1);
        library.addItem(v);
        library.addItem(v2);
        MediaItem [] items = library.findItems(VIDEO2);
        assertEquals("Hint: findItems() should return array with length 0 " +
                     "when no matches found. ", 0, items.length);
    }

    /**
     * Test deleting the only item from the library.
     */
    @Test
    public void testDeleteOnlyItem()
    {
        // Test if item or copy does not exist
        VideoRecording v = new VideoRecording();
        v.setCallNumber(VIDEO1);
        library.addItem(v);
        assertFalse("Hint: deleteItem() should return false when item not " +
                    "in library. ", 
                    library.deleteItem(VIDEO2, FIRST_COPY));
        assertFalse("Hint: deleteItem() should return false when correct " +
                    "copy not in library. ", 
                    library.deleteItem(VIDEO1, SECOND_COPY));
        assertEquals("Hint: deleteItem() should not delete anything if " +
                     "item not in library. ", 1,
                     library.findItems(VIDEO1).length);

        // Test deleting only copy in library
        assertTrue("Hint: deleteItem() should return true when item " +
                   "deleted. ", 
                   library.deleteItem(VIDEO1, FIRST_COPY));
        assertEquals("Hint: deleteItem() did not remove copy of item " +
                     "from library. ", 0,
                     library.findItems(VIDEO1).length);                   
    }

    /**
     * Test adding and deleting items from the library.
     */
    @Test
    public void testDeleteAndAddItems()
    {
        Book b = new Book();
        b.setCallNumber(BOOK1);
        library.addItem(b);
        b = new Book();
        b.setCallNumber(BOOK1);
        library.addItem(b);
        b = new Book();
        b.setCallNumber(BOOK1);
        library.addItem(b);

        // Test deleting the second copy in library
        assertTrue("Hint: deleteItem() should return true when deleting " +
                   "2nd copy of item. ", 
                   library.deleteItem(BOOK1, SECOND_COPY));
        MediaItem [] items = library.findItems(BOOK1);
        assertEquals("Hint: deleteItem() did not remove second copy of " +
                     "item from library. ", 2,
                     items.length);                   
        assertEquals("Hint: deleteItem() removed wrong copy of item " +
                     "from library. ", FIRST_COPY, items[0].getCopyNumber());
        assertEquals("Hint: deleteItem() removed wrong copy of item " +
                     "from library. ", THIRD_COPY, items[1].getCopyNumber());

        // Test adding a new copy
        b = new Book();
        b.setCallNumber(BOOK1);
        library.addItem(b);
        assertEquals("Hint: addItem() should assign highest copy number " +
                     "+ 1 to item added to library after deletes. ",
                     FOURTH_COPY, b.getCopyNumber());
        assertEquals("Hint: findItems() returned wrong number of copies " +
                     "after copy deleted and then added to library. ",
                     3, library.findItems(BOOK1).length);
    }

    /**
     * Tests checking out an item.
     */
    @Test
    public void testCheckOut()
    {
        // Test checking out an item
        Book b = new Book();
        b.setCallNumber(BOOK1);
        library.addItem(b);
        GregorianCalendar dueDate =
                          library.checkOut(BOOK1, FIRST_COPY, BORROWER,
                          DAY_1);
        assertEquals("Hint: checkOut() should return a date 30 days after " +
                     "date passed in. ", DAY_31,
                     dueDate);
        assertEquals("Hint: checkOut() should set the due date in the item " +
                     "to 30 days after the date passed in. ",
                     DAY_31,
                     b.getDueDate());

        // Test that a checked out item cannot be checked out again
        dueDate = library.checkOut(BOOK1, FIRST_COPY, BORROWER,
                                   DAY_31);
        assertNull("Hint: checkOut() should return null if item already " +
                     "checked out. ", dueDate);
        assertEquals("Hint: checkOut() should not reset the due date if " +
                     "item was already checked out. ",
                     DAY_31,
                     b.getDueDate());

        // Test that an item not in library cannot be checked out
        dueDate = library.checkOut(BOOK2, FIRST_COPY, BORROWER,
                                   DAY_1);
        assertNull("Hint: checkOut() should return null if item not in " +
                     "library. ", dueDate);

        // Test that a copy of an item not in library cannot be checked out
        dueDate = library.checkOut(BOOK1, SECOND_COPY, BORROWER,
                                   DAY_1);
        assertNull("Hint: checkOut() should return null if copy of item " +
                     "not in library. ", dueDate);

        // Test that the second copy of an item can be checked out
        b = new Book();
        b.setCallNumber(BOOK1);
        library.addItem(b);
        dueDate = library.checkOut(BOOK1, SECOND_COPY, BORROWER,
                                   DAY_1);
        assertNotNull("Hint: checkOut() should be able to check out the " +
                     "second copy of an item. ", dueDate);
        assertEquals("Hint: checkOut() should set the due date in the item " +
                     "to 30 days after the date passed in. ",
                     DAY_31,
                     b.getDueDate());
    }

    /**
     * Tests checking in an item.
     */
    @Test
    public void testCheckIn()
    {
        // Test checking in an item
        VideoRecording v = new VideoRecording();
        v.setCallNumber(VIDEO1);
        library.addItem(v);
        library.checkOut(VIDEO1, FIRST_COPY, BORROWER,
                         DAY_1);
        assertTrue("Hint: checkIn() should return true when item checked " +
                   "back in. ", library.checkIn(VIDEO1, FIRST_COPY));
        assertNull("Hint: checkIn() should set due date in item to null. ",
                   v.getDueDate());
        assertNull("Hint: checkIn() should set borrower in item to null. ",
                   v.getBorrower());

        // Test that a checked in item cannot be checked in again
        assertFalse("Hint: checkIn() should fail if item is already " +
                    "checked in. ",
                    library.checkIn(VIDEO1, FIRST_COPY));

        // Test that an item not in library cannot be checked in
        assertFalse("Hint: checkIn() should fail if item not in library. ",
                    library.checkIn(VIDEO2, FIRST_COPY));

        // Test that a copy of an item not in library cannot be checked
        library.checkOut(VIDEO1, FIRST_COPY, BORROWER,
                         DAY_1);
        assertFalse("Hint: checkIn() should fail if copy of item not " +
                    "in library. ",
                    library.checkIn(VIDEO1, SECOND_COPY));

        // Test that the second copy of an item can be checked out
        v = new VideoRecording();
        v.setCallNumber(VIDEO1);
        library.addItem(v);
        library.checkOut(VIDEO1, SECOND_COPY, BORROWER,
                         DAY_1);
        assertTrue("Hint: checkIn() should return true when second copy " +
                   "checked back in. ",
                   library.checkIn(VIDEO1, SECOND_COPY));
        assertNull("Hint: checkIn() should set due date in item to null " +
                   "when second copy checked in. ", v.getDueDate());
        assertNull("Hint: checkIn() should set borrower in item to null " +
                   "when second copy checked in. ", v.getBorrower());
    }

    /**
     * Tests calculateDateDiff().
     */
    @Test
    public void testDateDiff()
    {
        int diff = AnytownLibrary.calculateDateDiff(DAY_1, DAY_31);
        assertEquals("Wrong date diff", 30, diff);

        diff = AnytownLibrary.calculateDateDiff(DAY_1, DAY_32);
        assertEquals("Wrong date diff", 31, diff);
    }
    
    /**
     * Tests renew1().
     */
    @Test
    public void testRenew()
    {
        
        Book c = new Book();
        c.setCallNumber(BOOK2);
        c.setBorrower(BORROWER2);
        library.addItem(c);
        int copy = c.getCopyNumber();
        
        
        
        GregorianCalendar date = new GregorianCalendar();
        library.checkOut(BOOK2, copy, BORROWER2, date); 
        GregorianCalendar d = new GregorianCalendar();
        
        date.add(Calendar.DAY_OF_MONTH, 44);
        //test renew1 
        assertEquals( date, library.renew(BOOK2, copy, BORROWER2, d));
        
        
        
        
    
    }
    
    /**
     * Tests renew2().
     */
    @Test
    public void testRenew2()
    {
        GregorianCalendar date = new GregorianCalendar();
        
        Book c = new Book();
        c.setCallNumber(BOOK1);
        c.setBorrower(BORROWER3);
        library.addItem(c);
        int copy = c.getCopyNumber();
        library.checkOut(BOOK1, copy, BORROWER3, date); 
        
        Book r = new Book();
        r.setCallNumber("Book");
        r.setBorrower(BORROWER3);
        library.addItem(r);
        int copy2 = c.getCopyNumber();
        library.checkOut("Book", copy2, BORROWER3, date); 
        
        AudioRecording a = new AudioRecording();
        a.setCallNumber("audio");
        a.setBorrower(BORROWER3);
        library.addItem(a);
        int copy3 = c.getCopyNumber();
        library.checkOut("audio", copy3, BORROWER3, date); 
        
        
        
        Book[] books = {c, r};
        
        library.checkOut(BOOK1, copy, BORROWER3, date); 
        GregorianCalendar d = new GregorianCalendar();
        
        date.add(Calendar.DAY_OF_MONTH, 44);
        //test renew2 
        assertEquals( books, library.renew(BORROWER3, d));
        
        
    }
    
}
