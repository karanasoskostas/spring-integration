package pydra.integration.exception;

public class ErrorObject {

    private int errorCode;

    private String errorMesage;

    private long timestamp;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMesage() {
        return errorMesage;
    }

    public void setErrorMesage(String errorMesage) {
        this.errorMesage = errorMesage;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public ErrorObject() {
    }

    public ErrorObject(int errorCode, String errorMesage, long timestamp) {
        super();
        this.errorCode = errorCode;
        this.errorMesage = errorMesage;
        this.timestamp = timestamp;
    }
}
