package com.app.shakebug.services;

import static android.content.Context.SENSOR_SERVICE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.util.Log;
import android.view.View;

import com.app.shakebug.R;
import com.app.shakebug.activities.EditImageActivity;
import com.app.shakebug.activities.RemarkActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class ShakeDetectorService {

    private static final String TAG = "ShakeDetectorService";
    private static float mAccel, mAccelCurrent, mAccelLast;

    public static void shakeDetect(Context context) {
        SensorManager mSensorManager = (SensorManager) context.getSystemService(SENSOR_SERVICE);
        Objects.requireNonNull(mSensorManager).registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float x = sensorEvent.values[0];
                float y = sensorEvent.values[1];
                float z = sensorEvent.values[2];
                mAccelLast = mAccelCurrent;
                mAccelCurrent = (float) Math.sqrt(x * x + y * y + z * z);
                float delta = mAccelCurrent - mAccelLast;
                mAccel = mAccel * 0.9f + delta;
                if (mAccel > 12) {
                    captureScreen(context);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        }, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        mAccel = 10f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;
    }

    static void captureScreen(Context context) {
        View rootView = ((Activity) context).getWindow().getDecorView().getRootView();
        rootView.setDrawingCacheEnabled(true);
        Bitmap screenshotBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
        rootView.setDrawingCacheEnabled(false);
        String screenshotPath = saveBitmapToFile(screenshotBitmap, context);

        File imageFile = new File(screenshotPath);
        if (!imageFile.exists()) {
            return;
        }
        Uri imageUri = Uri.fromFile(imageFile);

        Intent intent = new Intent(context, EditImageActivity.class);
        intent.setAction(Intent.ACTION_EDIT);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        intent.putExtra("IMAGE_PATH", imageUri);
        context.startActivity(intent);
    }

    static void addRemarkManually(Context context) {
        Log.d(TAG, "addRemarkManually: ");
        Intent intent = new Intent(context, RemarkActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    static String getCurrentDateTimeString() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        return dateFormat.format(calendar.getTime());
    }

    static String saveBitmapToFile(Bitmap bitmap, Context context) {
        try {
            File cacheDir = context.getCacheDir();
            String fileName = context.getString(R.string.app_name) + "_" + getCurrentDateTimeString() + ".jpg";
            File screenshotFile = new File(cacheDir, fileName);

            FileOutputStream outputStream = new FileOutputStream(screenshotFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.flush();
            outputStream.close();

            return screenshotFile.getAbsolutePath();
        } catch (IOException e) {
            Log.e(TAG, "Error saving screenshot", e);
            return null;
        }
    }
}
