package lenovo.medical.com.glidedemo.memory;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by lenovo on 2016/4/14.
 */
public class CustomDiskCachingGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        // set size & external vs. internal
        int cacheSize100MegaBytes = 104857600;

        builder.setDiskCache(
                new InternalCacheDiskCacheFactory(context, cacheSize100MegaBytes)
        );

        //builder.setDiskCache(
        //new ExternalCacheDiskCacheFactory(context, cacheSize100MegaBytes));

        // or any other path
//        String downloadDirectoryPath = Environment.getDownloadCacheDirectory().getPath();
//
//        builder.setDiskCache(
//                new DiskLruCacheFactory( downloadDirectoryPath, cacheSize100MegaBytes )
//        );
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        // nothing to do here
    }
}
