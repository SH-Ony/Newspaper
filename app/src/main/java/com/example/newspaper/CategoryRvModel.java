package com.example.newspaper;

public class CategoryRvModel {

    private String category;
    private String categoryImageUrl;

    public CategoryRvModel(String category, String categoruImageUrl) {
        this.category = category;
        this.categoryImageUrl = categoruImageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl) {
        this.categoryImageUrl = categoryImageUrl;
    }
}
