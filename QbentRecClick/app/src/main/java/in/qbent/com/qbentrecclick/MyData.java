package in.qbent.com.qbentrecclick;

public class MyData
{
    private String name;
    private String mobileNo;
    //private String company;

    public MyData(String name, String mobileNo) {
        this.name = name;
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    //    public MyData(String name, String address, String company)
//    {
//        this.name = name;
//        this.address = address;
//        this.company = company;
//    }
//
//
//    public String getName()
//    {
//        return name;
//    }
//
//    public void setName(String name)
//    {
//        this.name = name;
//    }
//
//    public String getAddress()
//    {
//        return address;
//    }
//
//    public void setAddress(String address)
//    {
//        this.address = address;
//    }
//
//    public String getCompany()
//    {
//        return company;
//    }
//
//    public void setCompany(String company)
//    {
//        this.company = company;
//    }
}
