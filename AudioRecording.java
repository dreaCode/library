/**
 * AudioRecording Item in library.
 * 
 * @author Andrea Hemphill
 * @version 6/13/15
 */
public class AudioRecording extends AbstractMediaItem
{
    private String artist; 
    
    /**
     * Returns the name of the recording artist.
     * 
     * @return  the name of the recording artist.
     */
    public String getArtist()
    {
        
        return artist;
    }    
    
    /**
     * Sets the name of the recording artist.
     * 
     * @param   name    the name of the recording artist.
     */
    public void setArtist(String name)
    {
        if (name != null && checkString(name))
        {
            artist = name;
        }
        else
        {
            throw new IllegalArgumentException("Cannot be null"); 
        }
        
    }    
}
