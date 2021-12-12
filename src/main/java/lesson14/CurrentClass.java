package lesson14;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CurrentClass {
    private static Logger logger = LogManager.getLogger(CurrentClass.class);

    public static void main(String[] args) {

        //Log levels

        //fatal > error > warn > info > debug > trace
        //6 > 5 > 4 > 3 > 2 > 1

        int logLevel = 3; //info

        int a = 50;
        if (logLevel <= 2) { //debug
            System.out.println(System.currentTimeMillis() + " our method: a = " + a);
        }
        logger.debug("a={}", a);
        int b = 10;
        if (logLevel <= 2) { //debug
            System.out.println(System.currentTimeMillis() + " our method: b = " + b);
        }
        logger.debug("b={}", b);
        int c = a + b;
        if (logLevel >= 3) { //debug
            System.out.println(System.currentTimeMillis() + " our method: c = " + c);
        }

        logger.info("c={}+{}+{}", a, b, c);
        //logger, appender, layont


        logger.trace("Trace");
        logger.debug("Debug");
        logger.info("Info");
        logger.warn("Warn");
        logger.error("Error");
        logger.fatal("Fatal");
    }
}
