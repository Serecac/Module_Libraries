package com.ml.version;

import android.os.AsyncTask;

import com.ml.utils.utils.Utils_Version;

import org.jsoup.Jsoup;


public class GetVersionAsyncTask extends AsyncTask<String, String, String> {

    private VersionOnlineListener listener = null;

    public GetVersionAsyncTask(VersionOnlineListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... params) {

        String newVersion = null;
        try {
            newVersion = Jsoup.connect("https://play.google.com/store/apps/details?id=" + params[0] + "&hl=it")
                    .timeout(30000)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com")
                    .get()
                    .select("div[itemprop=softwareVersion]")
                    .first()
                    .ownText();
            return newVersion;
        } catch (Exception e) {
            return newVersion;
        }
    }

    @Override
    protected void onPostExecute(String onlineVersionName) {
        super.onPostExecute(onlineVersionName);
        if (this.listener != null && onlineVersionName != null)
            listener.onOnlineVersionReady(onlineVersionName, Utils_Version.versionCodeFromVersionName(onlineVersionName));
    }
}
