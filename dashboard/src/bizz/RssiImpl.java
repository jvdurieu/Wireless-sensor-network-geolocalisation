package bizz;


import constant.RssiType;
import ucc.RssiUCC;

/**
 *
 */
public class RssiImpl extends BizzObjectImpl implements Rssi {

	private int from;
	private int to;
	private int rssi;
	private int sequenceNo;
	private RssiType type;
	private double distanceMeters;

	/**
	 *
	 * @param from which mote was the transmitter
	 * @param to which mote received it
     * @param rssi at what strength did the receiver mote get the message
     */
	public RssiImpl(final int from, final int to, final int rssi, final int sequenceNo, RssiType type) {
		super();
		this.from = from;
		this.to = to;
		this.rssi = rssi;
		this.type = type;
		this.distanceMeters = RssiUCC.getDistanceFromRssi(this.rssi);
		this.sequenceNo = sequenceNo;
	}

	/**
	 * Constructeur vide
	 */
	public RssiImpl() {
		super();
		this.rssi = 1;
		this.distanceMeters = -1;
		this.type = RssiType.UNDEFINED;
	}

	@Override
	public int getFrom() {
		return from;
	}

	@Override
	public void setFrom(int from) {
		increaseVersion();
		this.from = from;
	}

	@Override
	public int getTo() {
		return to;
	}

	@Override
	public void setTo(int to) {
		increaseVersion();
		this.to = to;
	}

	@Override
	public int getRssi() {
		return rssi;
	}

	@Override
	public void setRssi(int rssi) {
		increaseVersion();
		this.rssi = rssi;
		this.distanceMeters = RssiUCC.getDistanceFromRssi(rssi);
	}

	@Override
	public void increaseVersion() {
		this.version++;
	}

	public int getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(int sequenceNo) {
		increaseVersion();
		this.sequenceNo = sequenceNo;
	}

	public RssiType getType() {
		return type;
	}

	public void setType(RssiType type) {
		increaseVersion();
		this.type = type;
	}

	public double getDistanceMeters() {
		return distanceMeters;
	}

	public int getVersion() {
		return version;
	}

}
