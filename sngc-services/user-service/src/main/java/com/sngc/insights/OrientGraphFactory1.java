package com.sngc.insights;


public class OrientGraphFactory1
{
    /*private String url;
    private String userName;
    private String password;
    private String dbName;
    private String adminUserName;
    private String adminPassword;

    public OrientGraphFactory( String url, String userName, String password,
                                String dbName, String adminUserName, String adminPassword )
    {
        this.url = url;
        this.userName = userName;
        this.password = password;

        this.dbName = dbName;
        this.adminUserName = adminUserName;
        this.adminPassword = adminPassword;
    }

    public String getUrl()
    {
        return url;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getPassword()
    {
        return password;
    }

    public String getDbName()
    {
        return dbName;
    }

    public String getAdminUserName()
    {
        return adminUserName;
    }

    public String getAdminPassword()
    {
        return adminPassword;
    }

    private OrientDB getOrientDb()
    {
        OrientDB orientDb = new OrientDB( this.url, this.userName, this.password, OrientDBConfig.defaultConfig() );

        orientDb.create( this.dbName, ODatabaseType.PLOCAL);

        return orientDb;
    }

    public ODatabaseDocument getSession()
    {
        OrientDB orientDb = this.getOrientDb();

        ODatabaseDocument session = orientDb.open(this.dbName, this.adminUserName, this.adminPassword );

        return session;

    }*/
}
