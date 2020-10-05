package com.risingpark.risinglog

import android.text.TextUtils
import android.util.Log
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class RisingLog {
    companion object{
        @JvmStatic var TAG = "RisingLog";
        @JvmStatic var isDebug = true;
        @JvmStatic var isShowClassMethod = true;


        @JvmStatic
        fun v(msg: String) {
            v(TAG, msg)
        }

        @JvmStatic
        fun v(tag: String, msg: String) {
            if(isDebug) Log.v(tag, getLogMsg(msg))
        }

        @JvmStatic
        fun d(msg: String) {
            d(TAG, msg)
        }

        @JvmStatic
        fun d(tag: String, msg: String) {
            if(isDebug) Log.d(tag, getLogMsg(msg))
        }

        @JvmStatic
        fun i(msg: String) {
            i(TAG, msg)
        }

        @JvmStatic
        fun i(tag: String, msg: String) {
            if(isDebug) Log.i(tag, getLogMsg(msg))
        }

        @JvmStatic
        fun e(msg: String) {
            e(TAG, msg)
        }

        @JvmStatic
        fun e(tag: String, msg: String) {
            if(isDebug) Log.e(tag, getLogMsg(msg))
        }

        @JvmStatic
        fun w(msg: String) {
            w(TAG, msg)
        }

        @JvmStatic
        fun w(tag: String, msg: String) {
            if(isDebug) Log.w(tag, getLogMsg(msg))
        }

        @JvmStatic
        fun j(msg: String) {
            j(TAG, msg)
        }

        @JvmStatic
        fun j(tag: String, msg: String) {
            if (isDebug) {
                showPrettyJson(tag, msg)
            }
        }

        private fun showPrettyJson(tag: String, msg: String){
            if (TextUtils.isEmpty(msg)) {
                Log.d(tag, msg)
            } else {
                val message: String
                message = try {
                    when {
                        msg.startsWith("{") -> {
                            val jsonObject = JSONObject(msg)
                            jsonObject.toString(4)
                        }
                        msg.startsWith("[") -> {
                            val jsonArray = JSONArray(msg)
                            jsonArray.toString(4)
                        }
                        else -> msg
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                    msg
                }

                Log.d(tag, "╔═══════════════════════════════════════════════════════════════════════════════════════")
                val lines = message.split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                for (line in lines) {
                    Log.d( tag, "║ $line")
                }
                Log.d(tag, "╚═══════════════════════════════════════════════════════════════════════════════════════")
            }
        }

        private fun getLogMsg(message: String?): String {
            if (isShowClassMethod){
                try {
                    val info = Thread.currentThread().stackTrace[4]
                    val sb = StringBuilder()
                    sb.append("[")
                    sb.append(info.fileName.replace(".java", "").replace(".kt", ""))
                    sb.append("::")
                    sb.append(info.methodName)
                    sb.append("]")
                    sb.append(message)
                    return sb.toString()
                } catch (e: Exception){
                    return message.toString()
                }
            } else {
                return message.toString()
            }
        }
    }
}