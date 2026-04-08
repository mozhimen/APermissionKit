package com.mozhimen.permissionk.test

import android.view.View
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.app.UtilKActivityStart
import com.mozhimen.kotlin.utilk.android.widget.showToast
import com.mozhimen.permissionk.PermissionK
import com.mozhimen.permissionk.annors.APermissionCheck
import com.mozhimen.permissionk.test.databinding.ActivityPermissionkBinding
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB

@APermissionCheck(CPermission.WRITE_EXTERNAL_STORAGE, CPermission.READ_EXTERNAL_STORAGE)
class PermissionKActivity : BaseActivityVDB<ActivityPermissionkBinding>() {
    fun requestPermission1(view: View) {
        //方法一,need APermissionCheck 注解
        PermissionK.requestPermissions(this) {
            if (it) {
                "权限申请成功".showToast()
            } else {
                UtilKActivityStart.startSettingsApplicationDetailsSettings(this)
            }
        }
    }

    fun requestPermission2(view: View) {
        //方法二,need APermissionCheck 注解
        PermissionK.requestPermissions(this,
            onSuccess = {
                "权限申请成功".showToast()
            }, onFail = {
                UtilKActivityStart.startSettingsApplicationDetailsSettings(this)
            })
    }

    fun requestPermission3(view: View) {
        //方法三
        PermissionK.requestPermissions(this, arrayOf(CPermission.WRITE_EXTERNAL_STORAGE, CPermission.READ_EXTERNAL_STORAGE)) {
            if (it) {
                "权限申请成功".showToast()
            } else {
                UtilKActivityStart.startSettingsApplicationDetailsSettings(this)
            }
        }
    }
}