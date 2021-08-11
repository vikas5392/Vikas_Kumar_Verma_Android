package com.training.checknetworkdownload;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;

public class DownloadContent {
   String fileName="My downloads";

    void DownloadSettings(Context context){
    DownloadManager d_manager=(DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
    DownloadManager.Request request= new DownloadManager.Request(Uri.parse(MainActivity.url));

    request.setTitle(fileName);
    request.setDescription("Downloading...");
    request.setDestinationInExternalFilesDir(context, Environment.DIRECTORY_DOWNLOADS,fileName);
    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
    //enque teh request
        d_manager.enqueue(request);
    }
}
