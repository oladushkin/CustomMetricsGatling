package config;

public class ConfigInfluxConnect {

    public String serverURL;
    public String username;
    public String password;
    public String databaseName = null;

    public ConfigInfluxConnect(String url, String username, String password, String databaseName){

        this.serverURL = url;
        this.username = username;
        this.password = password;
        this.databaseName = databaseName;

    }

    public ConfigInfluxConnect(String url, String username, String password){

        this.serverURL = url;
        this.username = username;
        this.password = password;

    }
}
