package com.app.tasks;

public class StoreItem {

    private int uid;
    private  int storeUid;
    private  int storeCatId;
    private String storeItemName;

    private int itemMRP;

    private int selling_price;
    private int buying_price;
    private int item_weight;
    private String item_weight_unit;
    private String item_description;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getStoreUid() {
        return storeUid;
    }

    public void setStoreUid(int storeUid) {
        this.storeUid = storeUid;
    }

    public int getStoreCatId() {
        return storeCatId;
    }

    public void setStoreCatId(int storeCatId) {
        this.storeCatId = storeCatId;
    }

    public String getStoreItemName() {
        return storeItemName;
    }

    public void setStoreItemName(String storeItemName) {
        this.storeItemName = storeItemName;
    }

    public int getItemMRP() {
        return itemMRP;
    }

    public void setItemMRP(int itemMRP) {
        this.itemMRP = itemMRP;
    }

    public int getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(int selling_price) {
        this.selling_price = selling_price;
    }

    public int getBuying_price() {
        return buying_price;
    }

    public void setBuying_price(int buying_price) {
        this.buying_price = buying_price;
    }

    public int getItem_weight() {
        return item_weight;
    }

    public void setItem_weight(int item_weight) {
        this.item_weight = item_weight;
    }

    public String getItem_weight_unit() {
        return item_weight_unit;
    }

    public void setItem_weight_unit(String item_weight_unit) {
        this.item_weight_unit = item_weight_unit;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }
}
