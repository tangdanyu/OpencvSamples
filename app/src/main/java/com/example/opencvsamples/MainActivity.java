package com.example.opencvsamples;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.opencvsamples.cameracalibration.OpencvCameraCalibrationActivity;
import com.example.opencvsamples.colorblobdetect.OpencvColorBlobDetectionActivity;
import com.example.opencvsamples.facedetect.OpencvFaceDetectionActivity;
import com.example.opencvsamples.imagemanipulations.OpencvImageManipulationsActivity;
import com.example.opencvsamples.puzzle15.OpencvPuzzle15Activity;
import com.example.opencvsamples.tutorial1.OpencvTutorial1CamerapreviewActivity;
import com.example.opencvsamples.tutorial2.OpencvTutorial2MixedprocessingActivity;
import com.example.opencvsamples.tutorial3.OpencvTutorial3CameracontrolActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = "MainActivity";
    //动态申请相机权限
    private String[] PERMISSIONS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO};
    private Button puzzle15Btn;
    private Button cameraCalibrationBtn;
    private Button colorBlobDetectionBtn;
    private Button faceDetectionBtn;
    private Button imageManipulationsBtn;
    private Button tutorial1CameraPreviewBtn;
    private Button tutorial2MixedProcessingBtn;
    private Button tutorial3CameraControlBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (checkAndRequestPermissions(PERMISSIONS, 100)) {
            initView();
            initListener();
            initData();
        }
    }

    private void initView() {
        puzzle15Btn = findViewById(R.id.btn_puzzle15);
        cameraCalibrationBtn = findViewById(R.id.btn_camera_calibration);
        colorBlobDetectionBtn = findViewById(R.id.btn_color_blob_detection);
        faceDetectionBtn = findViewById(R.id.btn_face_detection);
        imageManipulationsBtn = findViewById(R.id.btn_image_manipulations);
        tutorial1CameraPreviewBtn = findViewById(R.id.btn_tutorial1_camerapreview);
        tutorial2MixedProcessingBtn = findViewById(R.id.btn_tutorial2_mixedprocessing);
        tutorial3CameraControlBtn = findViewById(R.id.btn_tutorial3_cameracontrol);
    }

    private void initListener() {
        puzzle15Btn.setOnClickListener(this);
        cameraCalibrationBtn.setOnClickListener(this);
        colorBlobDetectionBtn.setOnClickListener(this);
        faceDetectionBtn.setOnClickListener(this);
        imageManipulationsBtn.setOnClickListener(this);
        tutorial1CameraPreviewBtn.setOnClickListener(this);
        tutorial2MixedProcessingBtn.setOnClickListener(this);
        tutorial3CameraControlBtn.setOnClickListener(this);
    }

    private void initData() {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_puzzle15:
                startActivity(new Intent(this, OpencvPuzzle15Activity.class));
                break;
            case R.id.btn_camera_calibration:
                startActivity(new Intent(this, OpencvCameraCalibrationActivity.class));
                break;
            case R.id.btn_color_blob_detection:
                startActivity(new Intent(this, OpencvColorBlobDetectionActivity.class));
                break;
            case R.id.btn_face_detection:
                startActivity(new Intent(this, OpencvFaceDetectionActivity.class));
                break;
            case R.id.btn_image_manipulations:
                startActivity(new Intent(this, OpencvImageManipulationsActivity.class));
                break;
            case R.id.btn_tutorial1_camerapreview:
                startActivity(new Intent(this, OpencvTutorial1CamerapreviewActivity.class));
                break;
            case R.id.btn_tutorial2_mixedprocessing:
                startActivity(new Intent(this, OpencvTutorial2MixedprocessingActivity.class));
                break;
            case R.id.btn_tutorial3_cameracontrol:
                startActivity(new Intent(this, OpencvTutorial3CameracontrolActivity.class));
                break;
        }
    }

    //动态申请权限
    public boolean checkAndRequestPermissions(String[] permissions, int requestCode) {
        List<String> requestPermission = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {//检查是否有了权限
                //没有权限即动态申请
                requestPermission.add(permission);
            }
        }
        if (requestPermission.size() == 0) {
            return true;
        }

        ActivityCompat.requestPermissions((Activity) this, requestPermission.toArray(new String[requestPermission.size()]), requestCode);
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean isAllGrant = true;

        for (int i = 0; i < grantResults.length; i++) {
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                AlertDialog dialog = new AlertDialog.Builder(this).setTitle("提示").setMessage("权限被禁止。\n请在【设置-应用信息-权限】中重新授权").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        onPermissionReject(requestCode);
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        onPermissionReject(requestCode);
                    }
                }).create();
                dialog.setCancelable(false);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

                isAllGrant = false;
                break;
            }
        }

        if (isAllGrant) {
            onPermissionGranted(requestCode);
        }
    }

    //获得全部权限
    public void onPermissionGranted(int requestCode) {
        MyLogUtil.e(TAG, "已经获得权限");
    }

    //权限被拒绝
    public void onPermissionReject(int requestCode) {
        finish();
    }

}