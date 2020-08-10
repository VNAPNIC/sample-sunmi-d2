package com.example.sunmitest.bean;

import java.util.List;

/**
 * 纯清单列表
 * Created by 徐荣 on 2016/9/13.
 */
public class ListingBean {
    /**
     * 表title
     */
    private String title;
    /**
     * 表头
     */
    private HeadBean head;
    /**
     * 表内容
     */
    private List<ItemBean> list;
    /**
     * 表清单
     */
    private List<KVP> KVPList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public HeadBean getHead() {
        return head;
    }

    public void setHead(HeadBean head) {
        this.head = head;
    }

    public List<ItemBean> getList() {
        return list;
    }

    public void setList(List<ItemBean> list) {
        this.list = list;
    }

    public List<KVP> getKVPList() {
        return KVPList;
    }

    public void setKVPList(List<KVP> KVPList) {
        this.KVPList = KVPList;
    }

    @Override
    public String toString() {
        return "ListingBean{" +
                "title='" + title + '\'' +
                ", head=" + head +
                ", list=" + list +
                ", KVPList=" + KVPList +
                '}';
    }
}
