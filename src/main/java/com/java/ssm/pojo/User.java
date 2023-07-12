package com.java.ssm.pojo;

//消费者和商家
public class User {
    private Integer id ;
    private String username ;
    private String password ;
    private String phone ;
    private String gender ;
    private String email ;
    private Integer isSeller ;
    private String address ;

    public User() {
    }

    public User(Integer id, String username, String password, String phone, String gender, String email, Integer isSeller , String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
        this.email = email;
        this.isSeller = isSeller;
        this.address = address ;
    }
    
    
    public String getAddress() {
    	return address ;
    }
    public void setAddress(String address) {
    	this.address = address ;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIsSeller() {
        return isSeller;
    }

    public void setIsSeller(Integer isSeller) {
        this.isSeller = isSeller;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", isSeller=" + isSeller +
                ", address=" + "address" +
                '}';
    }
}
