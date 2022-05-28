package model;

public class ServerModel {
    private String notice;
    private String serveraddr;
    private int server_id;
    public ServerModel(int id,String notice,String server){
        this.server_id=id;
        this.notice=notice;
        this.serveraddr=server;
    }

    public String getNotice() {
        return notice;
    }

    public int getServer_id() {
        return server_id;
    }

    public String getServeraddr() {
        return serveraddr;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public void setServer_id(int server_id) {
        this.server_id = server_id;
    }

    public void setServeraddr(String serveraddr) {
        this.serveraddr = serveraddr;
    }
}
