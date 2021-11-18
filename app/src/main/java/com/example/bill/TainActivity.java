//package com.example.bill;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.PermissionChecker;
//
//import android.Manifest;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.net.Uri;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.util.SparseArray;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.ml.vision.FirebaseVision;
//import com.google.firebase.ml.vision.common.FirebaseVisionImage;
//import com.google.firebase.ml.vision.text.FirebaseVisionText;
//import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;
//
//import java.io.IOException;
//
//
//public class MainActivity extends AppCompatActivity {
//    ImageView iv;
//    Button btnGallery, btnCamera, btnNewApp;
//    TextView tv1,tv2;
//    static final int REQUEST_IMAGE_CAPTURE = 1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        iv = findViewById(R.id.imageView);
//        btnCamera = findViewById(R.id.btnCamera);
//        btnGallery = findViewById(R.id.btnGal);
//        tv1 = findViewById(R.id.text);
//        tv2 = findViewById(R.id.finalAmt);
//
//
//
//        btnCamera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                if (ActivityCompat.checkSelfPermission(MainActivity.this,
////                        Manifest.permission.CAMERA) !=
////                        PermissionChecker.PERMISSION_GRANTED) {
////                    ActivityCompat.requestPermissions(MainActivity.this, new
////                            String[]{Manifest.permission.CAMERA}, 11);
////                }
////                else {
//                Intent in =
//                        new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(in, 113);
//                if (in.resolveActivity(getPackageManager()) != null) {
//                    startActivityForResult(in, REQUEST_IMAGE_CAPTURE);
//                }
//            }
//            //}
//        });
//
//    }
//
//    @Override
//    protected void onActivityResult(
//            int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 112 && data != null) {
//            Uri uri = data.getData();
//            try {
//                Bitmap bmp = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
//                FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bmp);
//                FirebaseVisionTextRecognizer textRecognizer = FirebaseVision.getInstance()
//                        .getOnDeviceTextRecognizer();
//
//                Task<FirebaseVisionText> result =
//                        textRecognizer.processImage(image)
//                                .addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
//                                    @Override
//                                    public void onSuccess(FirebaseVisionText firebaseVisionText) {
//
//
//                                        String lowerCa = firebaseVisionText.getText();
//                                        String str="";
//                                        String newtotalAmt="";
//                                        String totalAmt = "";
//                                        String amount ="";
//                                        String perfamt[]={};
//                                        str = lowerCa.toLowerCase();
//                                        if(str.contains("total")||str.contains("toral")) {
//                                            //starting me 2 x hona must
//                                            String amt[] = str.split("total", 2);
//                                            for (int i = 0; i < amt[1].length(); i++) {
//                                                if (amt[1].charAt(i) >= 48 && amt[1].charAt(i) <= 57 || amt[1].charAt(i) == '.' || amt[1].charAt(i) == ',') {
//                                                    totalAmt = totalAmt + amt[1].charAt(i);
//                                                    if(amt[1].charAt(i) ==' ') {
//                                                        break;
//                                                    }
//                                                }
//                                            }
//                                            if(totalAmt.contains(".")) {
//                                                perfamt = totalAmt.split("\\.+");;
//                                                for (int i = 0; i <=1; i++) {
//                                                    if (perfamt[1].charAt(i) >= 48 && perfamt[1].charAt(i) <= 57) {
//                                                        newtotalAmt = newtotalAmt +perfamt[1].charAt(i);
//                                                    }
//                                                }
//                                                //System.out.println(perfamt[0]);
//                                                System.out.println(perfamt[0]+"."+newtotalAmt);
//                                            }
//                                        }
//                                        tv1.setText(firebaseVisionText.getText());
//                                        amount = amount +perfamt[0]+"."+newtotalAmt;
//                                        tv2.setText(amount);
//                                        double finalAmt = Double.parseDouble(amount);
//                                        //ye print krne ka wala
//                                        //tv2.setText(finalAmt);
//                                        Toast.makeText(MainActivity.this, ""+firebaseVisionText.getText(), Toast.LENGTH_SHORT).show();
//                                    }
//                                })
//                                .addOnFailureListener(
//                                        new OnFailureListener() {
//                                            @Override
//                                            public void onFailure(@NonNull Exception e) {
//                                                //process failure
//                                            }
//                                        });
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            iv.setImageURI(uri);
//        }
//        if (requestCode == 113 && data != null) {
//            Bitmap bmp = (Bitmap) data.getExtras().get("data");
//            iv.setImageBitmap(bmp);
//            FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bmp);
//            FirebaseVisionTextRecognizer textRecognizer = FirebaseVision.getInstance()
//                    .getOnDeviceTextRecognizer();
//
//            Task<FirebaseVisionText> result =
//                    textRecognizer.processImage(image)
//                            .addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
//                                @Override
//                                public void onSuccess(FirebaseVisionText firebaseVisionText) {
//
//                                    String lowerCa = firebaseVisionText.getText();
//                                    String str="";
//                                    String newtotalAmt="";
//                                    String totalAmt = "";
//                                    String amount ="";
//                                    String perfamt[]={};
//                                    str = lowerCa.toLowerCase();
//                                    if(str.contains("total")||str.contains("toral")) {
//                                        //starting me 2 x hona must
//                                        String amt[] = str.split("total", 2);
//                                        for (int i = 0; i < amt[1].length(); i++) {
//                                            if (amt[1].charAt(i) >= 48 && amt[1].charAt(i) <= 57 || amt[1].charAt(i) == '.' || amt[1].charAt(i) == ',') {
//                                                totalAmt = totalAmt + amt[1].charAt(i);
//                                                if(amt[1].charAt(i) ==' ') {
//                                                    break;
//                                                }
//                                            }
//                                        }
//                                        if(totalAmt.contains(".")) {
//                                            perfamt = totalAmt.split("\\.+");;
//                                            for (int i = 0; i <=1; i++) {
//                                                if (perfamt[1].charAt(i) >= 48 && perfamt[1].charAt(i) <= 57) {
//                                                    newtotalAmt = newtotalAmt +perfamt[1].charAt(i);
//                                                }
//                                            }
//                                            //System.out.println(perfamt[0]);
//                                            System.out.println(perfamt[0]+"."+newtotalAmt);
//                                        }
//                                    }
//                                    tv1.setText(firebaseVisionText.getText());
//                                    amount = amount +perfamt[0]+"."+newtotalAmt;
//                                    tv2.setText(amount);
//                                    double finalAmt = Double.parseDouble(amount);
//                                    //ye print krne ka wala
//                                    //tv2.setText(finalAmt);
//                                    Toast.makeText(MainActivity.this, ""+firebaseVisionText.getText(), Toast.LENGTH_SHORT).show();
//                                }
//                            })
//                            .addOnFailureListener(
//                                    new OnFailureListener() {
//                                        @Override
//                                        public void onFailure(@NonNull Exception e) {
//                                            //process failure
//                                        }
//                                    });
//        }
//    }
//}