package me.coverdh;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 游戏主线程
 * Created by dhcover on 14/11/12.
 */
public class Manager {
    private static final Log Logger = LogFactory.getLog(Manager.class);


    /**
     * Manager
     */
    private static Manager manager = new Manager();

    private Manager() {}

    /**
     * @return
     */
    public static Manager instance() {
        return manager;
    }

    /**
     * 启动内部线程
     *
     */
    public void startupThread() {
    }
}
