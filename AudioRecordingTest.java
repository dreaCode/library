import org.junit.*;
import static org.junit.Assert.*;
/**
 * The test class AudioRecordingTest.
 *
 * @author Andrea Hemphill 
 * @version 6/14/15
 */
public class AudioRecordingTest extends AbstractMediaItemTest
{   
    
        
        
/**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     
    @Before
    public void setUp()
    {
        
    }

    
     * Tears down the test fixture.
     *
     * Called after every test case method.
     
    @After
    public void tearDown()
    {
       
    }
    */

    /**
     * Creates a concrete item to test. DO NOT MODIFY THIS METHOD.
     * 
     * @see AbstractMediaItemTest#createItem()
     * @return the item
     */
    protected AbstractMediaItem createItem()
    {
        AbstractMediaItem audio = new AudioRecording();

        return audio;
    }
    
     /**
     * Test for getting Borrower information.
     */
    @Test
    public void testGetArtist()
    {
        AudioRecording mp3 = new AudioRecording();
        mp3.setArtist("Someone");
        assertEquals("Someone", mp3.getArtist());

    }

    /**
     * Tests set borrower.
     */
    @Test
    public void testSetArtist()
    {
        AudioRecording audio = new AudioRecording();
        audio.setArtist("Shawn");
        assertEquals("Shawn", audio.getArtist());
    }

}
