package me.coverdh.exception;

/**
 * Created by dhcover on 14/11/12.
 */
public class GameServerStartupException  extends Exception {

    private static final long serialVersionUID = 4014405030116170329L;

    public GameServerStartupException() {
        super();

    }


    public GameServerStartupException(String message, Throwable cause) {
        super(message, cause);

    }


    public GameServerStartupException(String message) {
        super(message);

    }


    public GameServerStartupException(Throwable cause) {
        super(cause);

    }
}