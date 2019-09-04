package com.xwj.Xstream;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/9/16 20:17
 * @Version 1.0
 **/
public class XstreamEntity {
    private int id;
    private String name;
    private Date time;
    private List list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
