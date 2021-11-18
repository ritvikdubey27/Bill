////package com.example.bill;
////
////import android.Manifest;
////import android.app.Activity;
////import android.content.ContentValues;
////import android.content.Intent;
////import android.graphics.Bitmap;
////import android.media.ThumbnailUtils;
////import android.net.Uri;
////import android.os.Bundle;
////import android.os.Environment;
////import android.provider.MediaStore;
////import android.view.View;
////import android.widget.Button;
////import android.widget.ImageView;
////
////import androidx.appcompat.app.AppCompatActivity;
////import androidx.core.app.ActivityCompat;
////import androidx.core.content.PermissionChecker;
////
////import java.io.File;
////import java.io.IOException;
////import java.text.SimpleDateFormat;
////import java.util.Date;
////
////public class MainActivity extends AppCompatActivity {
////
////    static final int PICTURE_RESULT = 1;
////    static final int REQUEST_IMAGE_CAPTURE = 1;
////    String mCurrentPhotoPath;
////    ContentValues values;
////    private Uri file;
////    ImageView imageView;
////    Button btn;
////    Bitmap help1;
////
////    ThumbnailUtils thumbnail;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////        imageView = (ImageView) findViewById(R.id.imageView);
////        btn = (Button) findViewById(R.id.btnCamera);
////        values = new ContentValues();
////
////        btn.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
//////                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//////                //getting uri of the file
//////                file = Uri.fromFile(getFile());
//////
//////                //Setting the file Uri to my photo
//////                intent.putExtra(MediaStore.EXTRA_OUTPUT,file);
//////
//////                if(intent.resolveActivity(getPackageManager())!=null)
//////                {
//////                    startActivityForResult(intent, PICTURE_RESULT);
//////                }
////
////                if (ActivityCompat.checkSelfPermission(MainActivity.this,
////                        Manifest.permission.CAMERA) !=
////                        PermissionChecker.PERMISSION_GRANTED) {
////                    ActivityCompat.requestPermissions(MainActivity.this, new
////                            String[]{Manifest.permission.CAMERA}, 11);
////                }
////                else {
////                    Intent intent =
////                            new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
////                    startActivityForResult(intent, 113);
////                    if (intent.resolveActivity(getPackageManager()) != null) {
////                        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
////                    }
////
////
////                    file = Uri.fromFile(getFile());
////
////                    //Setting the file Uri to my photo
////                    intent.putExtra(MediaStore.EXTRA_OUTPUT,file);
////
////                    if(intent.resolveActivity(getPackageManager())!=null)
////                    {
////                        startActivityForResult(intent, PICTURE_RESULT);
////                    }
////
////                }
////            }
////        });
////
////    }
////
////
////
////
//////    public void launch_camera(View v) {
//////        // the intent is my camera
//////        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//////        //getting uri of the file
//////        file = Uri.fromFile(getFile());
//////
//////        //Setting the file Uri to my photo
//////        intent.putExtra(MediaStore.EXTRA_OUTPUT,file);
//////
//////        if(intent.resolveActivity(getPackageManager())!=null)
//////        {
//////            startActivityForResult(intent, PICTURE_RESULT);
//////        }
//////    }
////
////    //this method will create and return the path to the image file
////    private File getFile() {
////        File folder = Environment.getExternalStoragePublicDirectory("/From_camera/imagens");// the file path
////
////        //if it doesn't exist the folder will be created
////        if(!folder.exists())
////        {folder.mkdir();}
////
////        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
////        String imageFileName = "JPEG_"+ timeStamp + "_";
////        File image_file = null;
////
////        try {
////            image_file = File.createTempFile(imageFileName,".jpg",folder);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////
////        mCurrentPhotoPath = image_file.getAbsolutePath();
////        return image_file;
////    }
////
////    @Override
////    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
////        super.onActivityResult(requestCode, resultCode, data);
////        if (requestCode == PICTURE_RESULT) {
////            if (resultCode == Activity.RESULT_OK) {
////                try {
////                    help1 = MediaStore.Images.Media.getBitmap(getContentResolver(), file);
////                    imageView.setImageBitmap(thumbnail.extractThumbnail(help1, help1.getWidth(), help1.getHeight()));
////                } catch (Exception e) {
////                    e.printStackTrace();
////                }
////            }
////        }
////    }
////}
//
//package com.example.bill;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
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
//import android.widget.EditText;
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
//    //old
//    Button btnGallery, btnCamera, btnNewApp;
//    TextView tv1,tv2;
//    static final int REQUEST_IMAGE_CAPTURE = 1;
//
//    //new
//    ImageView iv;
//    EditText et;
//    Db o;
//    final static private int p = 100;
//    private Uri image;
//    private Bitmap imagetostore;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        //old
//        btnCamera = findViewById(R.id.btnCamera);
//        btnGallery = findViewById(R.id.btnGal);
//        tv1 = findViewById(R.id.text);
//        et = findViewById(R.id.finalAmt);
//        //new
//        iv = findViewById(R.id.imageView);
//        o = new Db(this);
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
//
//    }
//
//    public void chooseimage(View objview) {
//        Intent objectIntent = new Intent();
//        objectIntent.setType("image/*");
//
//        objectIntent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(objectIntent, p);
//    }
//
//
//    //old
//    @Override
//    protected void onActivityResult(
//            int requestCode, int resultCode, Intent data) { //(int requestCode, int resultCode, @Nullable Intent data) if old one doesn't works
//        super.onActivityResult(requestCode, resultCode, data);
//
//        //new
//        //ye gallery ka krega
//        if (requestCode == p && resultCode == RESULT_OK && data != null && data.getData() != null) {
//            image = data.getData();
////            try {
////                imagetostore = MediaStore.Images.Media.getBitmap(getContentResolver(), image);
////                iv.setImageBitmap(imagetostore);
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////
////        }
////
////        //old
////        if (requestCode == 112 && data != null) {
////            //Uri uri = data.getData();
//            //image = data.getData();
//            try {
//                //Bitmap bmp = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
//                imagetostore = MediaStore.Images.Media.getBitmap(getContentResolver(), image);
//                FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(imagetostore);
//                iv.setImageBitmap(imagetostore);
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
//                                        //tv1.setText(firebaseVisionText.getText());
//                                        amount = amount +perfamt[0]+"."+newtotalAmt;
//                                        et.setText(amount);
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
//            //iv.setImageURI(uri);
//            iv.setImageURI(image);
//        }
//
//        //ye camera se read krega
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
//                                    //tv1.setText(firebaseVisionText.getText());
//                                    amount = amount +perfamt[0]+"."+newtotalAmt;
//                                    et.setText(amount);
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
//
//    //new
////    @Override
////    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
////        super.onActivityResult(requestCode, resultCode, data);
////        if (requestCode == p && resultCode == RESULT_OK && data != null && data.getData() != null) {
////            image = data.getData();
////            try {
////                imagetostore = MediaStore.Images.Media.getBitmap(getContentResolver(), image);
////                iv.setImageBitmap(imagetostore);
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////
////        }
////
////    }
//
//    //new
//    public void storeimage(View view) {
//        if (!et.getText().toString().isEmpty() && iv.getDrawable() != null && imagetostore != null) {
//            o.storeimage(new Modelclass(et.getText().toString(), imagetostore));
//        } else {
//            Toast.makeText(this, "ccccccccccc", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//
//    public void m(View view) {
//        Intent in=new Intent(MainActivity.this,Showimagesactivity.class);
//        startActivity(in);
//    }
//}