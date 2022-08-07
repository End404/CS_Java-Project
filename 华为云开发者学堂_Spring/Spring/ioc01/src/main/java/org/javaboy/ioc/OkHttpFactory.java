
//2.3 工厂方法注入

package org.javaboy.ioc;

import okhttp3.OkHttpClient;

public class OkHttpFactory {
    private OkHttpClient okHttpClient;

    public OkHttpClient getInstance() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder().build();
        }
        return okHttpClient;
    }
}
