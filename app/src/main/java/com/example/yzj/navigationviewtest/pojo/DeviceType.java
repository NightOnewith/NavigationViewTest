package com.example.yzj.navigationviewtest.pojo;

/**
 * Created by yzj on 2018/2/2.
 */

public class DeviceType {
    public int type;
    public String name;
    public int imageId;

    public DeviceType(int type, String name, int imageId) {
        this.type = type;
        this.name = name;
        this.imageId = imageId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
