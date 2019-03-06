package com.bedrock.bosszp.model;

public class ContacterBean {

    String mgrNmae;
    String mgrMsg;
    String chatDate;

    public ContacterBean(){}

    public ContacterBean(String mgrNmae, String mgrMsg, String chatDate) {
        this.mgrNmae = mgrNmae;
        this.mgrMsg = mgrMsg;
        this.chatDate = chatDate;
    }

    public String getMgrNmae() {
        return mgrNmae;
    }

    public void setMgrNmae(String mgrNmae) {
        this.mgrNmae = mgrNmae;
    }

    public String getMgrMsg() {
        return mgrMsg;
    }

    public void setMgrMsg(String mgrMsg) {
        this.mgrMsg = mgrMsg;
    }

    public String getChatDate() {
        return chatDate;
    }

    public void setChatDate(String chatDate) {
        this.chatDate = chatDate;
    }
}
