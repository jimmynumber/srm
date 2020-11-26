package com.want.srm.po;
public class User {

    private String userId;// 用户账号

    private String userName;// 用户姓名

    private String empJobGrade;// 职等

    private String title;// 称号

    private String gender;// 性别

    private byte[] image;// 头像信息

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmpJobGrade() {
        return empJobGrade;
    }

    public void setEmpJobGrade(String empJobGrade) {
        this.empJobGrade = empJobGrade;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}