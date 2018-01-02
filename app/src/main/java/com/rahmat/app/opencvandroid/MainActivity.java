package com.rahmat.app.opencvandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class MainActivity extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener2 {

    ImageView imageView1;
    Context context;
    Bitmap img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.loadLibrary("opencv_java3");

        imageView1 = findViewById(R.id.imageView1);

        img = BitmapFactory.decodeResource(this.getResources(),R.drawable.bg_image);
        imageView1.setImageBitmap(img);
    }

    public void toGray(View view) {

        Mat source = new Mat();
        Utils. bitmapToMat( img, source);
        Mat dest = new Mat(source.size(), CvType.CV_8UC1);

        Imgproc. cvtColor(source, dest, Imgproc.COLOR_RGB2GRAY, 4);
        Bitmap btmp = Bitmap.createBitmap(dest.width(),dest.height(),Bitmap.Config.ARGB_8888);
        Utils. matToBitmap(dest,btmp);
        imageView1.setImageBitmap(btmp);
    }

    @Override
    public void onCameraViewStarted(int width, int height) {

    }

    @Override
    public void onCameraViewStopped() {

    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        return null;
    }
}
