package com.example.harsmeet.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    ImageView bmImage;

//     Image Donlonload tak i the t mu

    public DownloadImageTask(ImageView bmImage) {

        this.bmImage = bmImage;

    }

    protected Bitmap doInBackground(String... urls) {

        String urldisplay = urls[0];

        Bitmap bmp = null;


        try {


            InputStream in = new java.net.URL(urldisplay).openStream();


            bmp = BitmapFactory.decodeStream(in);


        } catch (Exception e) {


            Log.e("Error", e.getMessage());
//            Log.e("Error", e.getMessage());
            e.printStackTrace();

        }
// upload image from firebase realtime databas
//        a that
//        returm tely handle and thatt o that program can eai mument i


        return bmp;
    }

    protected void onPostExecute(Bitmap result) {

        try {

            bmImage.setImageBitmap(result);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}