package asus.com.bwie.week3.model;



import java.util.Map;

import asus.com.bwie.week3.callback.MyCallBack;
import asus.com.bwie.week3.okhttp.ICallBack;
import asus.com.bwie.week3.okhttp.OkHttpUtils;

public class IModelImpl implements IModel {


    @Override
    public void getRequest(String dataUrl, Map<String, String> params, Class clazz, final MyCallBack callBack) {
        OkHttpUtils.getInstance().getqueue(dataUrl, params, clazz, new ICallBack() {
            @Override
            public void getResponse(Object obj) {
                callBack.onSuccess(obj);
            }

            @Override
            public void getFaile(Exception e) {
                callBack.onSuccess(e);
            }
        });
    }
}
