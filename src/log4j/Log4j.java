package log4j;

import org.apache.log4j.Logger;

/**
 * Created by Malbac on 07.10.2015.
 */
public class Log4j {

    private static final Logger log = Logger.getLogger(Log4j.class);

    public static void main(String[] args) {
        log.debug("Test Message");
    }
}
