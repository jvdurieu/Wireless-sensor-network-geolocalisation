package bizz;

/**
 * Interface that got data from all BIZZ OBJECTS
 * @author Jean-Vital Durieu
 * @version 0.01
 */
public interface BizzObject {

	/**
	 * Get object version
	 * @return the version number
	 */
	int getVersion();

	void increaseVersion();

}