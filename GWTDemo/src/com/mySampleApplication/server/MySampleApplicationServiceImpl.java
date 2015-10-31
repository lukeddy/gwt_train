package com.mySampleApplication.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mySampleApplication.client.MySampleApplicationService;

public class MySampleApplicationServiceImpl extends RemoteServiceServlet implements MySampleApplicationService {
    //Implementation of sample interface method
    public String getMessage(String msg) {
        return "客户端说: \"" + msg + "\"<br>服务端说: \"Hi!\"";
    }
}