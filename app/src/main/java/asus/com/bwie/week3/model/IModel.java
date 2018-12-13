package asus.com.bwie.week3.model;



import java.util.Map;

import asus.com.bwie.week3.callback.MyCallBack;

public interface IModel {
    void getRequest(String dataUrl, Map<String, String> params, Class clazz, MyCallBack callBack);
}
