package net.okjsp.common.model;

/**
 * User: langerhans
 * Date: 2013. 12. 22.
 * Time: 오전 2:21
 * Description : Result Message Model
 */
public class Result {

    private boolean success;
    private String message;

    public Result() {}

    public Result(String message) {
        this.message = message;
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
