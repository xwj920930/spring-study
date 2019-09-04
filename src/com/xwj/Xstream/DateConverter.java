package com.xwj.Xstream;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/9/17 15:14
 * @Version 1.0
 **/
public class DateConverter implements Converter{
    private Locale locale;
    public DateConverter(Locale locale) {
        this.locale = locale;
    }
    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext context) {
        DateFormat format=DateFormat.getDateInstance(DateFormat.DATE_FIELD,this.locale);
        writer.setValue(format.format(o));
    }
    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        GregorianCalendar calendar=new GregorianCalendar();
        DateFormat format=DateFormat.getDateInstance(DateFormat.DATE_FIELD,this.locale);
        try {
            calendar.setTime(format.parse(reader.getValue()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.getGregorianChange();
    }
    @Override
    public boolean canConvert(Class aClass) {
        return Date.class.isAssignableFrom(aClass);
    }
}
