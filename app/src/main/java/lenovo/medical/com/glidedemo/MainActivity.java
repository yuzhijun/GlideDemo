package lenovo.medical.com.glidedemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

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
                String internetUrl = "http://i.imgur.com/DvpvklR.png";
                Glide.with(this)
                        .load(internetUrl)
                        .placeholder(R.drawable.a) //加载前占位
                        .error(R.mipmap.ic_launcher) //will be displayed if the image cannot be load
                        .crossFade() // 淡入淡出动画(禁止动画dontAnimate)
                        .into(ivShow);
                break;
            case R.id.btn2:
                //从资源中加载图片
                Glide.with(this)
                        .load(R.mipmap.ic_launcher)
                        .override(50,50)//在图片显示到 ImageView之前重新改变图片大小
                        .fitCenter()//fitCenter() 是裁剪技术，即缩放图像让图像都测量出来等于或小于 ImageView 的边界范围。该图像将会完全显示，但可能不会填满整个 ImageView
                        .into(ivShow);

                //缓存策略
//                String internetUrl1 = "http://i.imgur.com/DvpvklR.png";
//                Glide.with(this)
//                        .load(internetUrl1)
//                        .placeholder(R.drawable.a) //加载前占位
//                        .error(R.mipmap.ic_launcher) //will be displayed if the image cannot be load
//                        .crossFade() // 淡入淡出动画(禁止动画dontAnimate)
//                        .diskCacheStrategy(DiskCacheStrategy.NONE)
//                        .skipMemoryCache(true)
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
                break;
            case R.id.btn3:
                //从uri中加载图片
//                Uri uri = resourceIdToUri(this, R.mipmap.ic_launcher);
//                Glide.with(this)
//                        .load(uri)
//                        .centerCrop()//CenterCrop()是一个裁剪技术，即缩放图像让它填充到 ImageView 界限内并且侧键额外的部分()
//                        .into(ivShow);
                //显示gif动画
                String url = "http://i.kinja-img.com/gawker-media/image/upload/s--B7tUiM5l--/gf2r69yorbdesguga10i.gif";
                Glide.with(this)
                        .load(url)
                        .into(ivShow);
                //显示本地视频
//                String filePath = "/storage/emulated/0/Pictures/example_video.mp4";
//                Glide.with(this)
//                        .load( Uri.fromFile( new File( filePath ) ) )
//                        .into(ivShow);
                break;
            default:
                //从文件中加载图片
                //这个文件可能不存在于你的设备中。然而你可以用任何文件路径，去指定一个图片路径。
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Running.jpg");
                Glide.with(this)
                        .load(file)
                        .into(ivShow);
        }
    }

    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    private static Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }
}
