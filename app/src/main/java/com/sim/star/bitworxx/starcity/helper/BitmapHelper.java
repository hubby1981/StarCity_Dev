package com.sim.star.bitworxx.starcity.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/**
 * Created by WEIS on 28.04.2015.
 */
public class BitmapHelper {



    public String BitMapToString(Bitmap bitmap){
        ByteBuffer buffer = ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(buffer);


        String temp=Base64.encodeToString(buffer.array(), Base64.URL_SAFE);
        return temp;
    }

    public Bitmap StringToBitMap(String encodedString,int w,int h){
        try {
            byte [] encodeByte= Base64.decode(encodedString, Base64.URL_SAFE);
               Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length-1);
            return bitmap;
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }
}
