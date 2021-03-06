package bizz;

/**
 */
public class AnchorsImpl extends BizzObjectImpl implements Anchors {

	private int id;
	private int posx;
	private int posy;
	private double offset;
	private int batteryLvl;
	private double alpha;


	public AnchorsImpl(final int id, final int posx, final int posy, final double offset, final double alpha) {
		super();
		this.id = id;
		this.posx = posx;
		this.posy = posy;
		this.offset = offset;
		this.alpha = alpha;
		this.batteryLvl = -1;
	}

	/**
	 * Constructeur vide
	 */
	public AnchorsImpl() {
	}

	@Override
	public int getVersion() {
		return version;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		increaseVersion();
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		increaseVersion();
		this.posy = posy;
	}

	public int getBatteryLvl() {
		return batteryLvl;
	}

	public void setBatteryLvl(int batteryLvl) {
		increaseVersion();
		this.batteryLvl = batteryLvl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getOffset() {
		return offset;
	}

	@Override
	public double getAlpha() {
		return alpha;
	}
}
