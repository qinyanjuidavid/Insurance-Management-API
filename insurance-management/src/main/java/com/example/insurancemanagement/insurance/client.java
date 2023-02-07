package com.example.insurancemanagement.insurance;

// @Entity
public class client {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String nextOfKin;
    private String nextOfKinPhone;
    private String nextOfKinEmail;
    private String beneficiaries;
    private String beneficiariesPhone;
    private String beneficiariesEmail;

    //constructor
    public client(  Long id,
                    String name,
                    String address,
                    String phone,
                    String email,
                    String nextOfKin,
                    String nextOfKinPhone,
                    String nextOfKinEmail,
                    String beneficiaries,
                    String beneficiariesPhone,
                    String beneficiariesEmail) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.nextOfKin = nextOfKin;
        this.nextOfKinPhone = nextOfKinPhone;
        this.nextOfKinEmail = nextOfKinEmail;
        this.beneficiaries = beneficiaries;
        this.beneficiariesPhone = beneficiariesPhone;
        this.beneficiariesEmail = beneficiariesEmail;
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(String nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    public String getNextOfKinPhone() {
        return nextOfKinPhone;
    }

    public void setNextOfKinPhone(String nextOfKinPhone) {
        this.nextOfKinPhone = nextOfKinPhone;
    }

    public String getNextOfKinEmail() {
        return nextOfKinEmail;
    }

    public void setNextOfKinEmail(String nextOfKinEmail) {
        this.nextOfKinEmail = nextOfKinEmail;
    }

    public String getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(String beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public String getBeneficiariesPhone() {
        return beneficiariesPhone;
    }

    public void setBeneficiariesPhone(String beneficiariesPhone) {
        this.beneficiariesPhone = beneficiariesPhone;
    }

    public String getBeneficiariesEmail() {
        return beneficiariesEmail;
    }

    public void setBeneficiariesEmail(String beneficiariesEmail) {
        this.beneficiariesEmail = beneficiariesEmail;
    }

    //toString
    @Override
    public String toString() {
        return "client [address=" + address + ", beneficiaries=" + beneficiaries + ", beneficiariesEmail="
                + beneficiariesEmail + ", beneficiariesPhone=" + beneficiariesPhone + ", email=" + email + ", id=" + id
                + ", name=" + name + ", nextOfKin=" + nextOfKin + ", nextOfKinEmail=" + nextOfKinEmail
                + ", nextOfKinPhone=" + nextOfKinPhone + ", phone=" + phone + "]";
    }

}
