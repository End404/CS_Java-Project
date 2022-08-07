
//2.3 工厂方法注入

package org.javaboy.ioc;

import okhttp3.OkHttpClient;

// 静态工厂
public class OKHttpStaticFactory {
    private static OkHttpClient okHttpClient;
    public static OkHttpClient getInstance() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder().build();
        }
        return okHttpClient;
    }
}
