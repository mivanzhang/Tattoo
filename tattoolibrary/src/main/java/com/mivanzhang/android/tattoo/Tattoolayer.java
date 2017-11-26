package com.mivanzhang.android.tattoo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wanjian.sak.layer.adapter.LayerAdapter;

/**
 * Created by zhangmeng on 2017/11/18.
 */

public class Tattoolayer extends LayerAdapter {
    Context context;
    private boolean isFirstTime = true;

    public Tattoolayer(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public String description() {
        return "浮文";
    }

    @Override
    protected void drawLayer(Canvas canvas, Paint paint, View view) {
        if (view instanceof TextView && isFirstTime) {
            isFirstTime = false;
            TextView textView = (TextView) view;
            setListener(textView);
        }
    }

    public void setListener(final TextView listener) {
        listener.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final EditText et = new EditText(listener.getContext());
                new AlertDialog.Builder(listener.getContext()).setTitle("修改")
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setView(et)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String input = et.getText().toString();
                                listener.setText(input);
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                return false;
            }
        });
    }

}
