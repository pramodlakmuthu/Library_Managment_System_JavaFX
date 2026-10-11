package Model;

public class Members {
    private  String memberId;
    private String name;
    private String enail;
    private String address;
    private String mobileNb;

    public Members(String memberId, String name, String enail, String address, String mobileNb) {
        this.memberId = memberId;
        this.name = name;
        this.enail = enail;
        this.address = address;
        this.mobileNb = mobileNb;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnail() {
        return enail;
    }

    public void setEnail(String enail) {
        this.enail = enail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNb() {
        return mobileNb;
    }

    public void setMobileNb(String mobileNb) {
        this.mobileNb = mobileNb;
    }
}
