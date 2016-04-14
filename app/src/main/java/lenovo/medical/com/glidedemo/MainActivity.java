package lenovo.medical.com.glidedemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

import jp.wasabeef.glide.transformations.BlurTransformation;
import lenovo.medical.com.glidedemo.animator.AlphaAnimator;
import lenovo.medical.com.glidedemo.imagesize.CustomImageSizeModel;
import lenovo.medical.com.glidedemo.imagesize.CustomImageSizeModelFutureStudio;
import lenovo.medical.com.glidedemo.imagesize.CustomImageSizeUrlLoader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView ivShow;
    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        ivShow = (ImageView) findViewById(R.id.ivShow);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                //从网络中加载文件
//                String internetUrl = "http://i.imgur.com/DvpvklR.png";
//                Glide.with(this)
//                        .load(internetUrl)
//                        .placeholder(R.drawable.a) //加载前占位
//                        .error(R.mipmap.ic_launcher) //will be displayed if the image cannot be load
//                        .crossFade() // 淡入淡出动画(禁止动画dontAnimate)
//                        .into(ivShow);
                //使用转换库
                userTransformLibrary();
                break;
            case R.id.btn2:
                //从资源中加载图片
//                Glide.with(this)
//                        .load(R.mipmap.ic_launcher)
//                        .override(50,50)//在图片显示到 ImageView之前重新改变图片大小
//                        .fitCenter()//fitCenter() 是裁剪技术，即缩放图像让图像都测量出来等于或小于 ImageView 的边界范围。该图像将会完全显示，但可能不会填满整个 ImageView
//                        .into(ivShow);
                //缓存策略
//                String internetUrl1 = "http://i.imgur.com/DvpvklR.png";
//                Glide.with(this)
//                        .load(internetUrl1)
//                        .placeholder(R.drawable.a) //加载前占位
//                        .error(R.mipmap.ic_launcher) //will be displayed if the image cannot be load
//                        .crossFade() // 淡入淡出动画(禁止动画dontAnimate)
//                        .diskCacheStrategy(DiskCacheStrategy.NONE)
//                        .skipMemoryCache(true)
//                        .listener(requestListener)
//                        .into(ivShow);
                //优先级
//                String internetUrl2 = "http://i.imgur.com/DvpvklR.png";
//                Glide.with(this)
//                        .load(internetUrl2)
//                        .placeholder(R.drawable.a) //加载前占位
//                        .error(R.mipmap.ic_launcher) //will be displayed if the image cannot be load
//                        .crossFade() // 淡入淡出动画(禁止动画dontAnimate)
//                        .priority(Priority.LOW) //优先级
//                        .into(ivShow);
                //缩略图
//                String url1 = "http://i.imgur.com/DvpvklR.png";
//                Glide.with(this)
//                        .load(url1)
//                        .thumbnail(0.1f)
//                        .into(ivShow);
                //用不同的请求进阶缩略图
//                DrawableRequestBuilder<String> thumbnailRequest = Glide
//                        .with(this)
//                        .load("http://i.imgur.com/rFLNqWI.jpg");
//
//                Glide.with(this)
//                        .load(url1)
//                        .thumbnail( thumbnailRequest )
//                        .into(ivShow);

                //simpletarget的使用
                loadImageViewTarget();
                break;
            case R.id.btn3:
                //从uri中加载图片
//                Uri uri = resourceIdToUri(this, R.mipmap.ic_launcher);
//                Glide.with(this)
//                        .load(uri)
//                        .centerCrop()//CenterCrop()是一个裁剪技术，即缩放图像让它填充到 ImageView 界限内并且侧键额外的部分()
//                        .into(ivShow);
                //显示gif动画
//                String url = "http://i.kinja-img.com/gawker-media/image/upload/s--B7tUiM5l--/gf2r69yorbdesguga10i.gif";
//                Glide.with(this)
//                        .load(url)
//                        .asGif()
//                        .into(ivShow);
                //显示本地视频
//                String filePath = "/storage/emulated/0/Pictures/example_video.mp4";
//                Glide.with(this)
//                        .load( Uri.fromFile( new File( filePath ) ) )
//                        .into(ivShow);
                useMyAnimator();
                break;
            default:
                //从文件中加载图片
//                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Running.jpg");
//                Glide.with(this)
//                        .load(file)
//                        .into(ivShow);
        }
    }

    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    private static Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }

    //simpletarget的使用
    private void loadImageViewTarget(){
        Glide.with(this) // could be an issue!
                .load("http://i.imgur.com/DvpvklR.png")
                .asBitmap()
                .into(target);
    }

    private SimpleTarget target = new SimpleTarget<Bitmap>() {
        @Override
        public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {

            ivShow.setImageBitmap(bitmap);
        }
    };

    //用于捕获异常
    private RequestListener<String,GlideDrawable> requestListener = new RequestListener<String,GlideDrawable>() {
        @Override
        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
            // todo log exception

            // important to return false so the error placeholder can be placed
            return false;
        }

        @Override
        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
            return false;
        }
    };

    //使用自定义转换库(https://github.com/wasabeef/glide-transformations)
    /*
    * Crop
    CropTransformation, CropCircleTransformation, CropSquareTransformation, RoundedCornersTransformation
    Color
    ColorFilterTransformation, GrayscaleTransformation
    Blur
    BlurTransformation
    Mask
    MaskTransformation
    GPU Filter (use GPUImage)
    Will require add dependencies for GPUImage.
    ToonFilterTransformation, SepiaFilterTransformation, ContrastFilterTransformation
    InvertFilterTransformation, PixelationFilterTransformation, SketchFilterTransformation
    SwirlFilterTransformation, BrightnessFilterTransformation, KuwaharaFilterTransformation VignetteFilterTransformation
    * */
    private void userTransformLibrary(){

        //从网络中加载文件
        String internetUrl = "http://i.imgur.com/DvpvklR.png";
        CustomImageSizeModel customImageSizeModel = new CustomImageSizeModelFutureStudio(internetUrl);
        Glide.with(this)
                .using(new CustomImageSizeUrlLoader(this))
                .load(customImageSizeModel)
                .placeholder(R.drawable.a) //加载前占位
                .error(R.mipmap.ic_launcher) //will be displayed if the image cannot be load
                .crossFade() // 淡入淡出动画(禁止动画dontAnimate)
                .bitmapTransform(new BlurTransformation(this))
                .into(ivShow);
    }

    //使用自定义动画
    /*
    * <?xml version="1.0" encoding="utf-8"?>
    <set xmlns:android="http://schemas.android.com/apk/res/android"
        android:fillAfter="true">

    <scale
        android:duration="@android:integer/config_longAnimTime"
        android:fromXScale="0.1"
        android:fromYScale="0.1"
        android:pivotX="50%"
        android:pivotY="50%"
        android:toXScale="1"
        android:toYScale="1"/>
       </set>
    * */
    private void useMyAnimator(){

        String internetUrl = "http://i.imgur.com/DvpvklR.png";
        Glide.with(this)
                .load(internetUrl)
                .placeholder(R.drawable.a) //加载前占位
                .error(R.mipmap.ic_launcher) //will be displayed if the image cannot be load
                .crossFade() // 淡入淡出动画(禁止动画dontAnimate)
                .animate(new AlphaAnimator())
                .into(ivShow);

    }

    //ViewTarget使用(这个只是做一个记录，其中有些类并没有)
//    private void loadImageViewTarget() {
//        FutureStudioView customView = (FutureStudioView) findViewById( R.id.custom_view );
//
//        viewTarget = new ViewTarget<FutureStudioView, GlideDrawable>( customView ) {
//            @Override
//            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
//                this.view.setImage( resource.getCurrent() );
//            }
//        };
//
//        Glide.with( context.getApplicationContext() ) // safer!
//                .load( eatFoodyImages[2] )
//                .into( viewTarget );
//    }
}
