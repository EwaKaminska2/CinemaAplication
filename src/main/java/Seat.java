public class Seat {

    private boolean isVIP = false;
    private boolean isFree = true;

    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public boolean isFree() {
        return isFree;
    }



}
