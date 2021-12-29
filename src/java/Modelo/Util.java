package Modelo;

public class Util {

    boolean success;
    String data;
    String redirect;

    public Util() {
    }

    public Util(boolean success, String data, String redirect) {
        this.success = success;
        this.data = data;
        this.redirect = redirect;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }
    
    
    
    

}
