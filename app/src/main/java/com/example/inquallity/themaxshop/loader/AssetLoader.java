package com.example.inquallity.themaxshop.loader;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Olga Aleksandrova on 28-Apr-18.
 */

public class AssetLoader {

    private AssetManager mAssetManager;

    public AssetLoader(Context context) {
        mAssetManager = context.getAssets();
    }

    @NonNull
    public String readJson(String path) {
        path = path.trim();
        InputStream is = null;
        try {
            is = mAssetManager.open(path);
            final InputStreamReader isr = new InputStreamReader(is);
            final BufferedReader br = new BufferedReader(isr);
            final StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            Log.e("ERROR_LOG", e.getMessage(), e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    Log.e("ERROR_LOG", e.getMessage(), e);
                }
            }
        }
        return "";
    }

    @Nullable
    public Bitmap loadImage(String path) {
        path = path.trim();
        InputStream is = null;
        try {
            is = mAssetManager.open(path);
            return BitmapFactory.decodeStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
