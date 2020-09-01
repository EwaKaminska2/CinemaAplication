public class Seat {

    private boolean isVIP = false;
    private boolean isFree = true;

    public void setVIP(boolean isVIP) {
        this.isVIP = isVIP;
    }

    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public boolean isFree() {
        return isFree;
    }



}
