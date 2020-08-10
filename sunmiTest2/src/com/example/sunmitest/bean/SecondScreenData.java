package com.example.sunmitest.bean;

/**
 * Created by KenMa on 2016/9/8.
 */
public class SecondScreenData {
    public String firmwareVersion;//系统固件版本
    public String sysVersion;//系统版本号
    public long interTotalStorage;//系统内部可用存储
    public long interAvailableStorage;//系统内部总存储
    public long cacheStorage;//缓存数据
    public long appStorage;//app
    public long mediaStorage;//媒体
    public long othersStorage;//其他存储
    public long externalTotalStorage;//系统外部可用存储
    public long externalAvailableStorage;//系统外部可用存储
    public int brightness;//亮度
    public int musicVolume;//媒体音量
    public int maxVolume;//最大媒体音量

    public SecondScreenData() {

    }

    @Override
    public String toString() {
        return "firmwareVersion:" + firmwareVersion + "\n" +
                "sysVersion:" + sysVersion + "\n" +
                "interTotalStorage:" + interTotalStorage + "\n" +
                "interAvailableStorage:" + interAvailableStorage + "\n" +
                "cacheStorage:" + cacheStorage + "\n" +
                "appStorage:" + appStorage + "\n" +
                "mediaStorage:" + mediaStorage + "\n" +
                "othersStorage:" + othersStorage + "\n" +
                "externalTotalStorage:" + externalTotalStorage + "\n" +
                "externalAvailableStorage:" + externalAvailableStorage + "\n" +
                "brightness:" + brightness + "\n" +
                "musicVolume:" + musicVolume + "\n" +
                "maxVolume:" + maxVolume + "\n";
    }
}
