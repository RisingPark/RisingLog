package com.risingpark.risinglog

import android.util.Log

class RisingLog {
    companion object{
        var TAG = "RisingLog";
        var isDebug = true;

        fun v(msg: String) {
            if(isDebug) Log.v(TAG, getLogMsg(msg))
        }

        fun v(tag: String, msg: String) {
            if(isDebug) Log.v(tag, getLogMsg(msg))
        }

        fun d(msg: String) {
            if(isDebug) Log.d(TAG, getLogMsg(msg))
        }

        fun d(tag: String, msg: String) {
            if(isDebug) Log.d(tag, getLogMsg(msg))
        }

        fun i(msg: String) {
            if(isDebug) Log.i(TAG, getLogMsg(msg))
        }

        fun i(tag: String, msg: String) {
            if(isDebug) Log.i(tag, getLogMsg(msg))
        }

        fun e(msg: String) {
            if(isDebug) Log.e(TAG, getLogMsg(msg))
        }

        fun e(tag: String, msg: String) {
            if(isDebug) Log.e(tag, getLogMsg(msg))
        }

        fun w(msg: String) {
            if(isDebug) Log.w(TAG, getLogMsg(msg))
        }

        fun w(tag: String, msg: String) {
            if(isDebug) Log.w(tag, getLogMsg(msg))
        }

        fun getLogMsg(message: String?): String {
            return try{
                val info = Thread.currentThread().stackTrace[4]
                val sb = StringBuilder()
                sb.append("[")
                sb.append(info.fileName.replace(".java", "").replace(".kt", ""))
                sb.append("::")
                sb.append(info.methodName)
                sb.append("]")
                sb.append(message)
                sb.toString()
            } catch (e: Exception){
                message.toString()
            }
        }
    }
}