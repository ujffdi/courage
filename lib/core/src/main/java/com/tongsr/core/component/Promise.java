package com.tongsr.core.component;

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/2/16
 * @email ujffdtfivkg@gmail.com
 * @description Promise
 */
public class Promise {

    /*
      Promise.newInstance((promise, obj) -> runAsync1(promise::resolve))
                .then((promise, token) -> runAsync2((String) token, promise::resolve))
                .start();
     */

    private Promise lastPromise = null;

    private Promise beforePromise = null;

    private Callback callback;

    private Promise() {

    }

    private Promise(Callback callback) {
        this.callback = callback;
    }

    public static Promise newInstance(Callback callback) {
        return new Promise(callback);
    }

    // 可以增加参数 开始传递给 callback.run(this, 0); 方法的第二个参数
    public void start() {
        if (beforePromise != null) {
            beforePromise.start();
        } else {
            callback.run(this, 0);
        }
    }

    public Promise then(Callback callback) {
        if (callback == null) {
            start();
            return null;
        }
        Promise lastPromise = new Promise(callback);
        this.lastPromise = lastPromise;
        lastPromise.beforePromise = this;
        return lastPromise;
    }

    public void resolve(Object obj) { // 参数可以修改类型
        if (lastPromise == null) {
            return;
        }
        beforePromise = null;
        lastPromise.callback.run(lastPromise, obj);
    }

    interface Callback {

        void run(Promise promise, Object obj);

    }

}
