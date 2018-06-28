import org.junit.*;
import static org.junit.Assert.*;
/**
 * VideoRecordingTest.
 *
 * @author Andrea Hemphill 
 * @version 6/14/15
 */
public class VideoRecordingTest extends AbstractMediaItemTest
{   
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
        VideoRecording video = new VideoRecording();
        return video;
    }
    
    
}
