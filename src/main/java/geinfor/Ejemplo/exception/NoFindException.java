package geinfor.Ejemplo.exception;

import java.net.HttpURLConnection;

/**
 * @author Geinfor S.L.
 * @created 06/04/2020 - 10:27
 * @project Ejemplo
 * @programmer Stanimir Dobrev
 */
public class NoFindException  extends Exception{

    private static final long serialVersionUID = 1L;
    private final int errorCode;
    private final String errorMessage;

    public NoFindException(String msg) {
        super(msg);
        this.errorCode = HttpURLConnection.HTTP_NOT_FOUND;
        this.errorMessage = msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
