package com.xwj.Xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/9/16 20:17
 * @Version 1.0
 **/
@XStreamAlias("XAnnoEntity")
public class XAnnoEntity {
    @XStreamAlias("id")
    @XStreamAsAttribute
    private int id;

    @XStreamAlias("name")
    private String name;

    @XStreamAlias("time")
//    @XStreamConverter(DateConverter.class)
    private Date time;

    @XStreamAlias("list")
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
