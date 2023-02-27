package com.tongsr.core.extend

import android.Manifest
import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.ActivityResultLauncher
import androidx.annotation.RequiresPermission
import com.tongsr.core.extend.activityresult.*

/**
 * @author Tongsr
 * @version 1.0
 * @date 2023/1/12
 * @email ujffdtfivkg@gmail.com
 * @description ActivityResult
 */

@Deprecated(
    "registerForStartActivityResult(callback) instead.",
    ReplaceWith(
        "registerForStartActivityResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForStartActivityResult"
    )
)
fun ActivityResultCaller.startActivityLauncher(callback: ActivityResultCallback<ActivityResult>) =
    registerForStartActivityResult(callback)

@Deprecated(
    "registerForStartIntentSenderResult(callback) instead.",
    ReplaceWith(
        "registerForStartIntentSenderResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForStartIntentSenderResult"
    )
)
fun ActivityResultCaller.startIntentSenderLauncher(callback: ActivityResultCallback<ActivityResult>) =
    registerForStartIntentSenderResult(callback)

@Deprecated(
    "registerForRequestPermissionResult(onGranted, onDenied, onShowRequestRationale) instead.",
    ReplaceWith(
        "registerForRequestPermissionResult(onGranted, onDenied, onShowRequestRationale)",
        "com.tongsr.core.extend.activityresult.registerForRequestPermissionResult"
    )
)
fun ActivityResultCaller.requestPermissionLauncher(
    onGranted: () -> Unit,
    onDenied: AppSettingsScope.() -> Unit,
    onShowRequestRationale: PermissionScope.() -> Unit
): ActivityResultLauncher<String> =
    registerForRequestPermissionResult(onGranted, onDenied, onShowRequestRationale)

@Deprecated(
    "registerForRequestPermissionResult(callback) instead.",
    ReplaceWith(
        "registerForRequestPermissionResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForRequestPermissionResult"
    )
)
fun ActivityResultCaller.requestPermissionLauncher(callback: ActivityResultCallback<Boolean>) =
    registerForRequestPermissionResult(callback)

@Deprecated(
    "registerForRequestMultiplePermissionsResult(onAllGranted, onDenied, onShowRequestRationale) instead.",
    ReplaceWith(
        "registerForRequestMultiplePermissionsResult(onAllGranted, onDenied, onShowRequestRationale)",
        "com.tongsr.core.extend.activityresult.registerForRequestMultiplePermissionsResult"
    )
)
fun ActivityResultCaller.requestMultiplePermissionsLauncher(
    onAllGranted: () -> Unit,
    onDenied: AppSettingsScope.(List<String>) -> Unit,
    onShowRequestRationale: PermissionsScope.(List<String>) -> Unit
) = registerForRequestMultiplePermissionsResult(onAllGranted, onDenied, onShowRequestRationale)

@Deprecated(
    "registerForRequestMultiplePermissionsResult(callback) instead.",
    ReplaceWith(
        "registerForRequestMultiplePermissionsResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForRequestMultiplePermissionsResult"
    )
)
fun ActivityResultCaller.requestMultiplePermissionsLauncher(callback: ActivityResultCallback<Map<String, Boolean>>) =
    registerForRequestMultiplePermissionsResult(callback)

@Deprecated(
    "registerForTakePicturePreviewResult(callback) instead.",
    ReplaceWith(
        "registerForTakePicturePreviewResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForTakePicturePreviewResult"
    )
)
fun ActivityResultCaller.takePicturePreviewLauncher(callback: ActivityResultCallback<Bitmap?>) =
    registerForTakePicturePreviewResult(callback)

@Deprecated(
    "registerForTakePictureResult(callback) instead.",
    ReplaceWith(
        "registerForTakePictureResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForTakePictureResult"
    )
)
fun ActivityResultCaller.takePictureLauncher(callback: ActivityResultCallback<Boolean>) =
    registerForTakePictureResult(callback)

@Deprecated(
    "registerForTakeVideoResult(callback) instead.",
    ReplaceWith(
        "registerForTakeVideoResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForTakeVideoResult"
    )
)
fun ActivityResultCaller.takeVideoLauncher(callback: ActivityResultCallback<Boolean>) =
    registerForTakeVideoResult(callback)

@Deprecated(
    "registerForPickContactResult(callback) instead.",
    ReplaceWith(
        "registerForPickContactResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForPickContactResult"
    )
)
fun ActivityResultCaller.pickContactLauncher(callback: ActivityResultCallback<Uri?>) =
    registerForPickContactResult(callback)

@Deprecated(
    "registerForPickContentResult(callback) instead.",
    ReplaceWith(
        "registerForPickContentResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForPickContentResult"
    )
)
fun ActivityResultCaller.pickContentLauncher(callback: ActivityResultCallback<Uri>) =
    registerForPickContentResult(callback)

@Deprecated(
    "registerForGetContentResult(callback) instead.",
    ReplaceWith(
        "registerForGetContentResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForGetContentResult"
    )
)
fun ActivityResultCaller.getContentLauncher(callback: ActivityResultCallback<Uri?>) =
    registerForGetContentResult(callback)

@Deprecated(
    "registerForGetMultipleContentsResult(callback) instead.",
    ReplaceWith(
        "registerForGetMultipleContentsResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForGetMultipleContentsResult"
    )
)
fun ActivityResultCaller.getMultipleContentsLauncher(callback: ActivityResultCallback<List<Uri>>) =
    registerForGetMultipleContentsResult(callback)

@Deprecated(
    "registerForOpenDocumentResult(callback) instead.",
    ReplaceWith(
        "registerForOpenDocumentResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForOpenDocumentResult"
    )
)
fun ActivityResultCaller.openDocumentLauncher(callback: ActivityResultCallback<Uri?>) =
    registerForOpenDocumentResult(callback)

@Deprecated(
    "registerForOpenMultipleDocumentsResult(callback) instead.",
    ReplaceWith(
        "registerForOpenMultipleDocumentsResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForOpenMultipleDocumentsResult"
    )
)
fun ActivityResultCaller.openMultipleDocumentsLauncher(callback: ActivityResultCallback<List<Uri>>) =
    registerForOpenMultipleDocumentsResult(callback)

@Deprecated(
    "registerForOpenDocumentTreeResult(callback) instead.",
    ReplaceWith(
        "registerForOpenDocumentTreeResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForOpenDocumentTreeResult"
    )
)
fun ActivityResultCaller.openDocumentTreeLauncher(callback: ActivityResultCallback<Uri?>) =
    registerForOpenDocumentTreeResult(callback)

@Deprecated(
    "registerForCreateDocumentResult(callback) instead.",
    ReplaceWith(
        "registerForCreateDocumentResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForCreateDocumentResult"
    )
)
fun ActivityResultCaller.createDocumentLauncher(callback: ActivityResultCallback<Uri?>) =
    registerForCreateDocumentResult(callback)

@Deprecated(
    "registerForLaunchAppSettingsResult(callback) instead.",
    ReplaceWith(
        "registerForLaunchAppSettingsResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForLaunchAppSettingsResult"
    )
)
fun ActivityResultCaller.appSettingsLauncher(callback: ActivityResultCallback<Unit>) =
    registerForLaunchAppSettingsResult(callback)

@Deprecated(
    "registerForLaunchNotificationSettingsResult(callback) instead.",
    ReplaceWith(
        "registerForLaunchNotificationSettingsResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForLaunchNotificationSettingsResult"
    )
)
fun ActivityResultCaller.notificationSettingsLauncher(callback: ActivityResultCallback<Unit>) =
    registerForLaunchNotificationSettingsResult(callback)

@Deprecated(
    "registerForCropPictureResult(callback) instead.",
    ReplaceWith(
        "registerForCropPictureResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForCropPictureResult"
    )
)
fun ActivityResultCaller.cropPictureLauncher(callback: ActivityResultCallback<Uri>) =
    registerForCropPictureResult(callback)

@Deprecated(
    "registerForEnableLocationResult(onLocationEnabled) instead.",
    ReplaceWith(
        "registerForEnableLocationResult(onLocationEnabled)",
        "com.tongsr.core.extend.activityresult.registerForEnableLocationResult"
    )
)
fun ActivityResultCaller.enableLocationLauncher(onLocationEnabled: LocationScope.(Boolean) -> Unit) =
    registerForEnableLocationResult(onLocationEnabled)

@RequiresPermission(Manifest.permission.BLUETOOTH)
@Deprecated(
    "registerForEnableBluetoothResult(onLocationDisabled, onBluetoothEnabled) instead.",
    ReplaceWith(
        "registerForEnableBluetoothResult(onLocationDisabled, onBluetoothEnabled)",
        "com.tongsr.core.extend.activityresult.registerForEnableBluetoothResult"
    )
)
fun ActivityResultCaller.enableBluetoothLauncher(
    onLocationDisabled: LocationScope.() -> Unit,
    onBluetoothEnabled: BluetoothScope.(Boolean) -> Unit
) =
    registerForEnableBluetoothResult(onLocationDisabled, onBluetoothEnabled)

@RequiresPermission(Manifest.permission.BLUETOOTH)
@Deprecated(
    "registerForEnableBluetoothResult(onBluetoothEnabled) instead.",
    ReplaceWith(
        "registerForEnableBluetoothResult(onBluetoothEnabled)",
        "com.tongsr.core.extend.activityresult.registerForEnableBluetoothResult"
    )
)
fun ActivityResultCaller.enableBluetoothLauncher(onBluetoothEnabled: BluetoothScope.(Boolean) -> Unit) =
    registerForEnableBluetoothResult(onBluetoothEnabled)

@Deprecated(
    "registerForLaunchWifiSettingsResult(callback) instead.",
    ReplaceWith(
        "registerForLaunchWifiSettingsResult(callback)",
        "com.tongsr.core.extend.activityresult.registerForLaunchWifiSettingsResult"
    )
)
fun ActivityResultCaller.launchWifiSettingsLauncher(callback: ActivityResultCallback<Unit>) =
    registerForLaunchWifiSettingsResult(callback)