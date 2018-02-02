package com.example.yzj.navigationviewtest.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by yzj on 2018/2/1.
 *
 * Toast工具类
 */

public class ToastUtil {

    private static boolean isShow = true;
    private static Toast mToast;

    /* 控制Toast不能被实例化 */
    private ToastUtil() {
        throw new UnsupportedOperationException("不能被实例化");
    }

    public static void showToast(Context context, CharSequence message){
        if (isShow) {
            if (mToast == null){
                mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            }else {
                //若当前有Toast正在显示则直接替换Toast显示内容
                mToast.setText(message);
            }
            mToast.show();
        }
    }
}
