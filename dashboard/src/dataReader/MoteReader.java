package dataReader;

import app.AppContext;
import bizz.BizzFactory;
import constant.RssiType;
import model.RawModel;
import util.Log;

/**
 * Created by jvdur on 09/05/2016.
 */
public class MoteReader {

    private final RawModel rawModel;

    public MoteReader(RawModel rawModel) {

        // Init context variables
        this.rawModel = rawModel;
        int mode = Integer.parseInt(AppContext.INSTANCE.getProperty("mockupRSSI"));

        /*
         * IF MODE = 0 : Read from cmd line (LIVE)
         * IF MODE = 1 : Generate mockup RSSI from scratch
         * IF MODE = 2 : Read saved RSSI from file as system input
         */

        if (mode == 1) {
            // Generate RSSI values from scratch
            mockupRSSI();
        } else {
            Reader readerThread = new Reader(rawModel, mode);
            readerThread.start();
        }


    }

    private void mockupRSSI() {

        Thread t = new Thread()
        {
            public void run() {

                try {
                    this.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Log.logInfo("Mockup RSSI START 1");

                RawModel.INSTANCE.addRssi(BizzFactory.INSTANCE.createRssi(0,6,-14,1, RssiType.ANCHOR_TO_BLIND,1));
                RawModel.INSTANCE.addRssi(BizzFactory.INSTANCE.createRssi(1,6,-20,1, RssiType.ANCHOR_TO_BLIND,1));
                RawModel.INSTANCE.addRssi(BizzFactory.INSTANCE.createRssi(2,6,-14,1, RssiType.ANCHOR_TO_BLIND,1));

                try {
                    this.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Log.logInfo("Mockup RSSI START 2");

                RawModel.INSTANCE.addRssi(BizzFactory.INSTANCE.createRssi(3,6,-14,2, RssiType.ANCHOR_TO_BLIND,1));
                RawModel.INSTANCE.addRssi(BizzFactory.INSTANCE.createRssi(4,6,-20,2, RssiType.ANCHOR_TO_BLIND,1));
                RawModel.INSTANCE.addRssi(BizzFactory.INSTANCE.createRssi(2,6,-14,2, RssiType.ANCHOR_TO_BLIND,1));

                try {
                    this.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Log.logInfo("Mockup RSSI START 3");

                RawModel.INSTANCE.addRssi(BizzFactory.INSTANCE.createRssi(1,6,-14,3, RssiType.ANCHOR_TO_BLIND,1));
                RawModel.INSTANCE.addRssi(BizzFactory.INSTANCE.createRssi(3,6,-20,3, RssiType.ANCHOR_TO_BLIND,1));
                RawModel.INSTANCE.addRssi(BizzFactory.INSTANCE.createRssi(5,6,-14,3, RssiType.ANCHOR_TO_BLIND,1));


                try {
                    this.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Log.logInfo("Mockup RSSI START 3");

                RawModel.INSTANCE.addRssi(BizzFactory.INSTANCE.createRssi(0,6,-14,4, RssiType.ANCHOR_TO_BLIND,1));
                RawModel.INSTANCE.addRssi(BizzFactory.INSTANCE.createRssi(1,6,-20,4, RssiType.ANCHOR_TO_BLIND,1));
                RawModel.INSTANCE.addRssi(BizzFactory.INSTANCE.createRssi(2,6,-14,4, RssiType.ANCHOR_TO_BLIND,1));

            }
        };

        t.start();




    }

}
