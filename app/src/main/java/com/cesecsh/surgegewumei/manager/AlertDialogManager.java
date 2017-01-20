package com.cesecsh.surgegewumei.manager;

import android.app.Activity;
import android.content.Context;

import com.cesecsh.surgegewumei.view.alertView.AlertView;
import com.cesecsh.surgegewumei.view.alertView.OnItemClickListener;


/**
 * Created by 上海中电
 * on 2016/10/28
 */

public class AlertDialogManager {


    /**
     * 展示登录过期的对话框
     *
     * @param context
     */

    public static void showLoginOverdue(final Context context) {
        try {
            new AlertView("已下线", "您的账号已在其他终端登录,请重新登录",
                    "退出程序",
                    new String[]{"重新登录"},
                    null,
                    context,
                    AlertView.Style.Alert,
                    new OnItemClickListener() {
                        @Override
                        public void onItemClick(Object o, int position) {
                            switch (position) {
                                case 0:// 点击重新登录
                                    Activity taskTop = ActivityManager.getInstance().getTaskTop();
                                    ActivityManager.getInstance().closeAllActivity();
                                    break;
                                case -1:// 点击退出
                                    ActivityManager.getInstance().closeAllActivity();
                                    break;
                            }
                        }
                    })
                    .setCancelable(false)
                    .setBackEnable(false)
                    .show();
        } catch (Exception ignored) {
        }
    }


}
