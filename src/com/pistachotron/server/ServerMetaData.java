package com.pistachotron.server;

public class ServerMetaData {
    public int port;
    public String name;
    private ServerMetaData(int port,String name){
        this.port=port;
        this.name=name;
    }
    public static ServerMetaData getServer(int port, String name){
        return new ServerMetaData(port,name);

    }
}
