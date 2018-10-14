package com.example.labkomserver.realapplications;

public class Categories {

    private int imgId;
    private String categoryName;

    public Categories(int imgId, String categoryName) {
        this.imgId = imgId;
        this.categoryName = categoryName;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
