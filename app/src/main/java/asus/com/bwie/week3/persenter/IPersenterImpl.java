package asus.com.bwie.week3.persenter;



import java.util.Map;

import asus.com.bwie.week3.callback.MyCallBack;
import asus.com.bwie.week3.model.IModel;
import asus.com.bwie.week3.model.IModelImpl;
import asus.com.bwie.week3.view.IView;

public class IPersenterImpl implements IPersenter {
    private IView mIView;
    private IModelImpl iModel;

    public IPersenterImpl(IView iView){
        mIView=iView;
        iModel=new IModelImpl();
    }


    @Override
    public void getRequest(String dataUrl, Map<String, String> params, Class clazz) {
        iModel.getRequest(dataUrl, params, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object data) {
                mIView.onSuccess(data);
            }
        });
    }

    public void deteach(){
        iModel=null;
        mIView=null;
    }

}
