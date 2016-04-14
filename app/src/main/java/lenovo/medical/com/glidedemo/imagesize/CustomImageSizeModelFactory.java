package lenovo.medical.com.glidedemo.imagesize;

import android.content.Context;

import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;

import java.io.InputStream;

/**
 * Created by lenovo on 2016/4/14.
 */
public class CustomImageSizeModelFactory implements ModelLoaderFactory<CustomImageSizeModel, InputStream> {
    @Override
    public ModelLoader<CustomImageSizeModel, InputStream> build(Context context, GenericLoaderFactory factories) {
        return new CustomImageSizeUrlLoader( context );
    }

    @Override
    public void teardown() {

    }
}
