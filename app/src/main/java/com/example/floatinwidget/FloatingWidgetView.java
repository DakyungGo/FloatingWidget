package com.example.floatinwidget;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

public class FloatingWidgetView extends FrameLayout implements View.OnTouchListener {

    private WindowManager.LayoutParams layoutParams;

    private int x = 0;
    private int y = 0;
    private float touchX = 0f;
    private float touchY = 0f;
    private long clickStartTimer = 0;
    private View mFloatingView;
    private WindowManager windowManager;
    private static final int CLICK_DELTA = 200;

    public void initlayoutParam(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.O){
            layoutParams = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
//                    |WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                    PixelFormat.TRANSLUCENT);
        }
        else{
            layoutParams = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    PixelFormat.TRANSLUCENT);
        }
    }

    public FloatingWidgetView(@NonNull Context context) {
        super(context);

        initlayoutParam();

        mFloatingView = View.inflate(context, R.layout.activity_floating_widget,this);
        mFloatingView.findViewById(R.id.root_container).setOnTouchListener(this);

        this.layoutParams.gravity = Gravity.RIGHT;
        this.layoutParams.x = this.x;
        this.layoutParams.y = this.y;

        Object var10001 = this.getContext().getSystemService(Context.WINDOW_SERVICE);
        if (var10001 == null) {
            throw new IllegalStateException("null cannot be cast to non-null type android.view.WindowManager");
        } else {
            this.windowManager = (WindowManager)var10001;
            this.windowManager.addView(mFloatingView, (android.view.ViewGroup.LayoutParams)this.layoutParams);
        }
    }

    public FloatingWidgetView(@NonNull Context context, @NonNull AttributeSet attrs) {
        super(context);

        initlayoutParam();

        mFloatingView = View.inflate(context, R.layout.activity_floating_widget,this);
        mFloatingView.findViewById(R.id.root_container).setOnTouchListener(this);

        this.layoutParams.gravity = Gravity.RIGHT;
        this.layoutParams.x = this.x;
        this.layoutParams.y = this.y;

        Object var10001 = this.getContext().getSystemService(Context.WINDOW_SERVICE);
        if (var10001 == null) {
            throw new IllegalStateException("null cannot be cast to non-null type android.view.WindowManager");
        } else {
            this.windowManager = (WindowManager)var10001;
            this.windowManager.addView(mFloatingView, (android.view.ViewGroup.LayoutParams)this.layoutParams);
        }
    }

    public FloatingWidgetView(@NonNull Context context, @NonNull AttributeSet attrs, int defStyleAttr) {
        super(context);

        initlayoutParam();

        mFloatingView = View.inflate(context, R.layout.activity_floating_widget,this);
        mFloatingView.findViewById(R.id.root_container).setOnTouchListener(this);

        this.layoutParams.gravity = Gravity.RIGHT;
        this.layoutParams.x = this.x;
        this.layoutParams.y = this.y;

        Object var10001 = this.getContext().getSystemService(Context.WINDOW_SERVICE);
        if (var10001 == null) {
            throw new IllegalStateException("null cannot be cast to non-null type android.view.WindowManager");
        } else {
            this.windowManager = (WindowManager)var10001;
            this.windowManager.addView(mFloatingView, (android.view.ViewGroup.LayoutParams)this.layoutParams);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (motionEvent.getAction()){

            case 0:
                clickStartTimer = System.currentTimeMillis();
                this.x = this.layoutParams.x;
                this.y = this.layoutParams.y;
                this.touchX = motionEvent.getRawX();
                this.touchY = motionEvent.getRawY();
                break;
            case 1:
                if(System.currentTimeMillis() - clickStartTimer < (long)200){

                    //onClick event

                    //Animation
                    mFloatingView.findViewById(R.id.expanded_container).setAlpha(1f);

                    mFloatingView.findViewById(R.id.expanded_container).setVisibility(View.VISIBLE);

                    ///
                    mFloatingView.findViewById(R.id.floatingIcon).setVisibility(INVISIBLE);
                    mFloatingView.findViewById(R.id.close_button).setVisibility(VISIBLE);


                }
                break;
            case 2:
//
//                this.layoutParams.x = (int)((float)this.x + motionEvent.getRawX() - this.touchX);
//                this.layoutParams.y = (int)((float)this.y + motionEvent.getRawY() - this.touchY);

                //위가 원래 코드, Gravity 설정 후 좌우반대로 움직여서 아래와 같이 변경
                this.layoutParams.x = (int)((float)this.x - motionEvent.getRawX() + this.touchX);
                this.layoutParams.y = (int)((float)this.y + motionEvent.getRawY() - this.touchY);

                this.windowManager.updateViewLayout(mFloatingView, (android.view.ViewGroup.LayoutParams)this.layoutParams);
        }

        return true;
    }
}
