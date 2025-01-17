/****************************************************************************
 Copyright (c) 2020 Xiamen Yaji Software Co., Ltd.

 http://www.cocos2d-x.org

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 ****************************************************************************/
package com.cocos.lib;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public class GlobalObject {
    private static Context sContext = null;
    private static Activity sActivity = null;
    private static Handler sHandler = null;

    public static void init(Context context, Activity activity) {
        sContext = context;
        sActivity = activity;
        sHandler = new Handler(Looper.getMainLooper());
    }

    public static void destroy() {
        sContext = null;
        sActivity = null;
        sHandler.removeCallbacksAndMessages(null);
        sHandler = null;
    }

    public static Activity getActivity() {
        return sActivity;
    }

    public static Context getContext() {
        return sContext;
    }

    public static void runOnUiThread(Runnable runnable) {
        sHandler.post(runnable);
    }
}
