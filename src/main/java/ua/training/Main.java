package ua.training;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.model.util.CryptoUtil;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);
        logger.info("INIT");
        System.out.println(CryptoUtil.hashPassword("1"));
        System.out.println(CryptoUtil.hashPassword("111"));
        System.out.println(CryptoUtil.hashPassword("3"));
        System.out.println(CryptoUtil.hashPassword("2"));
        System.out.println(CryptoUtil.hashPassword("lfdkj234"));
        System.out.println(CryptoUtil.hashPassword("fdkl23"));
        System.out.println(CryptoUtil.hashPassword("polko"));
        System.out.println(CryptoUtil.hashPassword("omadr"));
        System.out.println(CryptoUtil.hashPassword("fds123vdsv"));
        System.out.println(CryptoUtil.hashPassword("sdfasdfljk"));
        System.out.println(CryptoUtil.hashPassword("tucfdj"));
        System.out.println(CryptoUtil.hashPassword("dfsdf"));
        System.out.println(CryptoUtil.hashPassword("ellen"));
        System.out.println(CryptoUtil.hashPassword("fdslkm231"));
        System.out.println(CryptoUtil.hashPassword("sing111"));
        System.out.println(CryptoUtil.hashPassword("pasko"));
        System.out.println(CryptoUtil.hashPassword("sten123"));
        System.out.println(CryptoUtil.hashPassword("pet128"));
        System.out.println(CryptoUtil.hashPassword("ewre221"));
        System.out.println(CryptoUtil.hashPassword("fletpad12"));
    }
}
