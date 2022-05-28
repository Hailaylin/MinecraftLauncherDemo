package model;

public class ServerModel {
    String notice;
    String serverAddr;

    public ServerModel(String notice, String serverAddr) {
        this.notice = notice;
        this.serverAddr = serverAddr;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }
}
