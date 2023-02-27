package com.tongsr.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.blankj.utilcode.util.StringUtils;
import java.util.Objects;

/**
 * @author Tongsr
 * @version 1.0
 * @date 2020/6/8
 * @email ujffdtfivkg@gmail.com
 * @description EditText 的文本监听器，停止输入 1s 后，如果文本发生变化则触发监听器
 */
public class SearchEditText extends AppCompatEditText {

    /*
        文本内容是 111，111 -> 1111 -> 11111，连续输入都小于 1s，在输完后的 1s 触发监听器为 11111；
        文本内容是 111，111 -> 1111 -> 111，连续输入都小于 1s，在输完后的 1s 不触发监听器；
        类似微信的客户端搜索，不同的是微信在 111 -> 1111 -> 111 是会触发改变的
     */

    private static final long LIMIT = 1000;

    private OnTextChangedListener mListener;
    private String mStartText = "";// 记录开始输入前的文本内容
    private final Runnable mAction = new Runnable() {
        @Override
        public void run() {
            if (mListener != null) {
                // 判断最终和开始前是否一致
                if (!StringUtils.equals(mStartText, Objects.requireNonNull(getText()).toString())) {
                    mStartText = getText().toString();// 更新 mStartText
                    mListener.onTextChanged(mStartText);
                }
            }
        }
    };

    public SearchEditText(Context context) {
        super(context);
    }

    public SearchEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SearchEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 在 LIMIT 时间内连续输入不触发文本变化
     */
    public void setOnTextChangedListener(OnTextChangedListener listener) {
        mListener = listener;
    }

    @Override
    protected void onTextChanged(final CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        // 移除上一次的回调
        removeCallbacks(mAction);
        postDelayed(mAction, LIMIT);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(mAction);
    }

    public interface OnTextChangedListener {
        void onTextChanged(String text);
    }
}
