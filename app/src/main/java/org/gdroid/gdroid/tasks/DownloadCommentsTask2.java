/*
 * Copyright (C) 2019 Andreas Redmer <ar-gdroid@abga.be>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.gdroid.gdroid.tasks;

import android.os.AsyncTask;
import android.util.Log;

import org.gdroid.gdroid.beans.CommentBean;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DownloadCommentsTask2 extends AsyncTask<String, Void, List<CommentBean>> {
    private static final String TAG = "DownloadCommentsTask2";
    private Runnable runnableOnPostExecute;
//    private final String url = "https://mastodon.technology/api/v1/timelines/tag/%s?limit=40";
    private final String BASE_URL = "https://%s/api/v1/timelines/tag/%s?limit=40";

    private List<CommentBean> result;

    public DownloadCommentsTask2() {
    }

    public List<CommentBean> doInBackground(String... hashtag) {
        String urldisplay = String.format(BASE_URL, "mastodon.technology", hashtag[0]);
        try {
            Log.d(TAG, "fetching comments from Mastodon");
            InputStream in = new java.net.URL(urldisplay).openStream();
            if (isCancelled())
                return null;
            String s = getStreamContent(in,"UTF-8");
            if (isCancelled())
                return null;
            CommentsJsonParser p = new CommentsJsonParser();
            final List<CommentBean> comments = p.getCommentBeansFromJson(s);
            if (isCancelled())
                return null;
            return comments;
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void onPostExecute(List<CommentBean> result) {
        this.result = result;
        if (runnableOnPostExecute != null)
            runnableOnPostExecute.run();
    }

    public List<CommentBean> getResult() {
        return result;
    }

    public void setRunnableOnPostExecute(Runnable runnableOnPostExecute) {
        this.runnableOnPostExecute = runnableOnPostExecute;
    }

    private static String getStreamContent(
            InputStream fis,
            String          encoding )
    {
        try
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(fis, encoding ));
            StringBuilder sb = new StringBuilder();
            String line;
            while(( line = br.readLine()) != null ) {
                sb.append( line );
            }
            return sb.toString();
        }
        catch (Exception e)
        {

        }
        return "[]";
    }


}