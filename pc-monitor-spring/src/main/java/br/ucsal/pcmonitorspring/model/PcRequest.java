package br.ucsal.pcmonitorspring.model;

public class PcRequest {

    private String identifierCod;

    private String javaVersion;

    private String totalMemory;

    private String os;

    private String login;

    public PcRequest(String identifierCod, String javaVersion, String totalMemory, String os, String login) {
        this.identifierCod = identifierCod;
        this.javaVersion = javaVersion;
        this.totalMemory = totalMemory;
        this.os = os;
        this.login = login;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(String totalMemory) {
        this.totalMemory = totalMemory;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public String getIdentifierCod() {
        return identifierCod;
    }

    public void setIdentifierCod(String identifierCod) {
        this.identifierCod = identifierCod;
    }
}
