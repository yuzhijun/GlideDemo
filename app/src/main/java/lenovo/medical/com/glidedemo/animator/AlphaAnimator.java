package lenovo.medical.com.glidedemo.animator;

import android.animation.ObjectAnimator;
import android.view.View;

import com.bumptech.glide.request.animation.ViewPropertyAnimation;

/**
 * Created by yuzhijun on 2016/4/13.
 */
public class AlphaAnimator implements ViewPropertyAnimation.Animator {
    @Override
    public void animate(View view) {
        // if it's a custom view class, cast it here
        // then find subviews and do the animations
        // here, we just use the entire view for the fade animation
        view.setAlpha( 0f );

        ObjectAnimator fadeAnim = ObjectAnimator.ofFloat( view, "alpha", 0f, 1f );
        fadeAnim.setDuration( 2500 );
        fadeAnim.start();
    }
}
