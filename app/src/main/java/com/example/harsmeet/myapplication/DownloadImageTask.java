package com.example.harsmeet.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.StorageReference;

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


//    @Override
//    public void registerComponents(Context context, Glide glide, Registry registry) {
//        // Register FirebaseImageLoader to handle StorageReference
//
//        try {
//            registry.append(StorageReference.class, InputStream.class,
//
//                    new FirebaseImageLoader.Factory());
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

}