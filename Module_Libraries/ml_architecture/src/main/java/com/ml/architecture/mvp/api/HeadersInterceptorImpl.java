package com.ml.architecture.mvp.api;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * <p> Class HeadersInterceptorImpl </p>
 * Set log time info on http comunication
 *
 * @version 1.0.0
 */
public class HeadersInterceptorImpl implements Interceptor {

    private final String userAgent;

    /**
     * Instantiates a new Headers interceptor.
     *
     * @param userAgent the user agent
     */
    public HeadersInterceptorImpl(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        long t1 = System.nanoTime();
        Log.i("Okhttp:", String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));

        Response response = chain.proceed(request);

        long t2 = System.nanoTime();
        Log.i("Okhttp:", String.format("Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers()));

        return response;

    }
}
