package com.mozhimen.permissionk.test

import android.view.View
import com.mozhimen.bindk.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.manifestk.permission.ManifestKPermission
import com.mozhimen.manifestk.permission.annors.APermissionCheck
import com.mozhimen.kotlin.utilk.android.app.UtilKActivityStart
import com.mozhimen.kotlin.utilk.android.widget.showToast
import com.mozhimen.permissionk.PermissionK
import com.mozhimen.permissionk.test.databinding.ActivityPermissionkBinding

@APermissionCheck(CPermission.WRITE_EXTERNAL_STORAGE, CPermission.READ_EXTERNAL_STORAGE)
class PermissionKActivity : BaseActivityVDB<ActivityPermissionkBinding>() {
    fun requestPermission1(view: View) {
        //方法一,need APermissionCheck 注解
        PermissionK.requestPermissions(this) {
            if (it) {
                "权限申请成功".showToast()
            } else {
                UtilKActivityStart.startSettingApplicationDetailsSettings(this)
            }
        }
    }

    fun requestPermission2(view: View) {
        //方法二,need APermissionCheck 注解
        ManifestKPermission.requestPermissions(this,
            onSuccess = {
                "权限申请成功".showToast()
            }, onFail = {
                UtilKActivityStart.startSettingApplicationDetailsSettings(this)
            })
    }

    fun requestPermission3(view: View) {
        //方法三
        ManifestKPermission.requestPermissions(this, arrayOf(CPermission.WRITE_EXTERNAL_STORAGE, CPermission.READ_EXTERNAL_STORAGE)) {
            if (it) {
                "权限申请成功".showToast()
            } else {
                UtilKActivityStart.startSettingApplicationDetailsSettings(this)
            }
        }
    }
}