package com.mySampleApplication.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * 前端入口类定义
 */
public class MySampleApplication implements EntryPoint {

    /**
     *入口方法
     */
    public void onModuleLoad() {
        final Button button = new Button("点我");
        final Label label = new Label();

        //按钮点击回调事件
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (label.getText().equals("")) {
                    MySampleApplicationService.App.getInstance().getMessage("你好，GWT!", new MyAsyncCallback(label));
                } else {
                    label.setText("");
                }
            }
        });


        //假设网页中有两个元素的ID为btn-wrapper和msg-wrapper,将GWT组建按钮和标签加入网页中
        RootPanel.get("btn-wrapper").add(button);
        RootPanel.get("msg-wrapper").add(label);
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("与服务器连接出问题了");
        }
    }
}
