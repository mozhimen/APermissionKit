package com.mozhimen.permissionk.commons

import com.mozhimen.kotlin.elemk.commons.IAB_Listener


/**
 * @ClassName IManifestKPermissionListener
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/8/15 13:49
 * @Version 1.0
 */
typealias IPermissionKListener = IAB_Listener<Boolean, List<String>> /*(Boolean, List<String>) -> Unit*/
