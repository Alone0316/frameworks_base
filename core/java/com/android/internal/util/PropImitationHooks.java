/*
 * Copyright (C) 2022 Paranoid Android
<<<<<<< HEAD
=======
 *           (C) 2023 ArrowOS
 *           (C) 2023 The LibreMobileOS Foundation
>>>>>>> parent of a390d22e1422 (base: Switch to PixelPropsUtils)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.internal.util;

<<<<<<< HEAD
import android.app.Application;
import android.content.res.Resources;
import android.os.Build;
=======
import android.app.ActivityTaskManager;
import android.app.Application;
import android.app.TaskStackListener;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
>>>>>>> parent of a390d22e1422 (base: Switch to PixelPropsUtils)
import android.util.Log;

import com.android.internal.R;

import java.lang.reflect.Field;
import java.util.Arrays;
<<<<<<< HEAD
=======
import java.util.Map;
import java.util.Set;
>>>>>>> parent of a390d22e1422 (base: Switch to PixelPropsUtils)

public class PropImitationHooks {

    private static final String TAG = "PropImitationHooks";
    private static final boolean DEBUG = false;

<<<<<<< HEAD
    private static final String sCertifiedFp =
            Resources.getSystem().getString(R.string.config_certifiedFingerprint);
=======
    private static final String[] sCertifiedProps =
            Resources.getSystem().getStringArray(R.array.config_certifiedBuildProperties);
>>>>>>> parent of a390d22e1422 (base: Switch to PixelPropsUtils)

    private static final String sStockFp =
            Resources.getSystem().getString(R.string.config_stockFingerprint);

<<<<<<< HEAD
    private static final String PACKAGE_ARCORE = "com.google.ar.core";
=======
    private static final String sNetflixModel =
            Resources.getSystem().getString(R.string.config_netflixSpoofModel);

    private static final boolean sSpoofGapps =
            Resources.getSystem().getBoolean(R.bool.config_spoofGoogleApps);

    private static final String PACKAGE_ARCORE = "com.google.ar.core";
    private static final String PACKAGE_ASI = "com.google.android.as";
>>>>>>> parent of a390d22e1422 (base: Switch to PixelPropsUtils)
    private static final String PACKAGE_FINSKY = "com.android.vending";
    private static final String PACKAGE_GMS = "com.google.android.gms";
    private static final String PACKAGE_GPHOTOS = "com.google.android.apps.photos";
    private static final String PACKAGE_NETFLIX = "com.netflix.mediaclient";
    private static final String PACKAGE_SNAPCHAT = "com.snapchat.android";
<<<<<<< HEAD
    private static final String PACKAGE_VELVET = "com.google.android.googlequicksearchbox";
    private static final String PACKAGE_LIVE_WALLPAPER = "com.google.pixel.livewallpaper";
    private static final String PACKAGE_WALLPAPER_EMOJI = "com.google.android.apps.emojiwallpaper";
    private static final String PACKAGE_WALLPAPER_EFFECT = "com.google.android.wallpaper.effects";
=======
    private static final String PACKAGE_SMS_ORGANIZER = "com.microsoft.android.smsorganizer";
    private static final String PACKAGE_VELVET = "com.google.android.googlequicksearchbox";
    private static final String PACKAGE_LIVE_WALLPAPER = "com.google.pixel.livewallpaper";
    private static final String PACKAGE_WALLPAPER_EMOJI = "com.google.android.apps.emojiwallpaper";
    private static final String PACKAGE_PIXEL_LAUNCHER = "com.google.android.apps.nexuslauncher";
>>>>>>> parent of a390d22e1422 (base: Switch to PixelPropsUtils)

    private static final String PROCESS_GMS_PERSISTENT = PACKAGE_GMS + ".persistent";
    private static final String PROCESS_GMS_UNSTABLE = PACKAGE_GMS + ".unstable";

    private static final Map<String, Object> sPixel7Props = Map.of(
        "BRAND", "google",
        "MANUFACTURER", "Google",
        "DEVICE", "cheetah",
        "PRODUCT", "cheetah",
        "MODEL", "Pixel 7 Pro",
<<<<<<< HEAD
        "FINGERPRINT", "google/cheetah/cheetah:13/TQ3A.230605.012/10204971:user/release-keys"
=======
        "FINGERPRINT", "google/cheetah/cheetah:13/TQ3A.230805.001/10316531:user/release-keys"
>>>>>>> parent of a390d22e1422 (base: Switch to PixelPropsUtils)
    );

    private static final Map<String, Object> sPixelProps = Map.of(
        "BRAND", "google",
        "MANUFACTURER", "Google",
        "DEVICE", "redfin",
        "PRODUCT", "redfin",
        "MODEL", "Pixel 5",
<<<<<<< HEAD
        "FINGERPRINT", "google/redfin/redfin:13/TQ1A.230105.001/9292298:user/release-keys"
    );

=======
        "FINGERPRINT", "google/redfin/redfin:13/TQ3A.230805.001/10316531:user/release-keys"
    );

    private static final ComponentName GMS_ADD_ACCOUNT_ACTIVITY = ComponentName.unflattenFromString(
            "com.google.android.gms/.auth.uiflows.minutemaid.MinuteMaidActivity");

>>>>>>> parent of a390d22e1422 (base: Switch to PixelPropsUtils)
    private static final Map<String, Object> sPixelXLProps = Map.of(
        "BRAND", "google",
        "MANUFACTURER", "Google",
        "DEVICE", "marlin",
        "PRODUCT", "marlin",
        "MODEL", "Pixel XL",
        "FINGERPRINT", "google/marlin/marlin:10/QP1A.191005.007.A3/5972272:user/release-keys"
    );

    private static final Set<String> sFeatureBlacklist = Set.of(
        "PIXEL_2017_PRELOAD",
        "PIXEL_2018_PRELOAD",
        "PIXEL_2019_MIDYEAR_PRELOAD",
        "PIXEL_2019_PRELOAD",
        "PIXEL_2020_EXPERIENCE",
        "PIXEL_2020_MIDYEAR_EXPERIENCE",
        "PIXEL_2021_EXPERIENCE",
        "PIXEL_2021_MIDYEAR_EXPERIENCE"
    );
<<<<<<< HEAD
    private static volatile boolean sIsGms = false;
    private static volatile boolean sIsFinsky = false;
=======

    private static final Set<String> sTensorFeatureBlacklist = Set.of(
        "PIXEL_2022_EXPERIENCE",
        "PIXEL_2022_MIDYEAR_EXPERIENCE",
        "PIXEL_2021_EXPERIENCE",
        "PIXEL_2021_MIDYEAR_EXPERIENCE"
    );

    private static volatile String sProcessName;
    private static volatile boolean sIsGms, sIsFinsky, sIsPhotos, sIsPixelLauncher, sIsASI;
>>>>>>> parent of a390d22e1422 (base: Switch to PixelPropsUtils)

    public static void setProps(Context context) {
        final String packageName = context.getPackageName();
        final String processName = Application.getProcessName();

        setPropValue("TYPE", "user");
        setPropValue("TAGS", "release-keys");

        if (TextUtils.isEmpty(packageName) || TextUtils.isEmpty(processName)) {
            Log.e(TAG, "Null package or process name");
            return;
        }

<<<<<<< HEAD
        sIsGms = packageName.equals(PACKAGE_GMS) && processName.equals(PROCESS_GMS_UNSTABLE);
        sIsFinsky = packageName.equals(PACKAGE_FINSKY);

        /* Set certified fingerprint for GMSCore
         * Set stock fingerprint for ARCore
         * Set Pixel 5 for Snapchat, Google, ASI and GMS device configurator
=======
        sProcessName = processName;
        sIsGms = packageName.equals(PACKAGE_GMS) && processName.equals(PROCESS_GMS_UNSTABLE);
        sIsFinsky = packageName.equals(PACKAGE_FINSKY);
        sIsPhotos = sSpoofGapps && packageName.equals(PACKAGE_GPHOTOS);
        sIsPixelLauncher = sSpoofGapps && packageName.equals(PACKAGE_PIXEL_LAUNCHER);
        sIsASI = sSpoofGapps && packageName.equals(PACKAGE_ASI);

        /* Set certified properties for GMSCore
         * Set stock fingerprint for ARCore
         * Set Pixel 5 for Snapchat, SMS Organizer, Google, ASI and GMS device configurator
>>>>>>> parent of a390d22e1422 (base: Switch to PixelPropsUtils)
         * Set Pixel 7 Pro for Live wallpaper and WallpaperEmoji
         * Set Pixel XL for Google Photos
         * Set custom model for Netflix
         */
<<<<<<< HEAD
        if (!sCertifiedFp.isEmpty() && sIsGms) {
            dlog("Setting certified fingerprint for GMS");
            setPropValue("FINGERPRINT", sCertifiedFp);
=======
        if (sIsGms) {
            setCertifiedPropsForGms();
>>>>>>> parent of a390d22e1422 (base: Switch to PixelPropsUtils)
        } else if (!sStockFp.isEmpty() && packageName.equals(PACKAGE_ARCORE)) {
            dlog("Setting stock fingerprint for: " + packageName);
            setPropValue("FINGERPRINT", sStockFp);
        } else if (sSpoofGapps && (packageName.equals(PACKAGE_VELVET)
                || packageName.equals(PACKAGE_ASI)
                || packageName.equals(PACKAGE_SNAPCHAT)
<<<<<<< HEAD
=======
                || packageName.equals(PACKAGE_SMS_ORGANIZER)
>>>>>>> parent of a390d22e1422 (base: Switch to PixelPropsUtils)
                || (packageName.equals(PACKAGE_GMS)
                    && processName.equals(PROCESS_GMS_PERSISTENT)))) {
            dlog("Spoofing Pixel 5 for: " + packageName + " process: " + processName);
            sPixelProps.forEach(PropImitationHooks::setPropValue);
        } else if (sSpoofGapps && (packageName.equals(PACKAGE_WALLPAPER_EMOJI)
<<<<<<< HEAD
                || packageName.equals(PACKAGE_LIVE_WALLPAPER)
                || packageName.equals(PACKAGE_WALLPAPER_EFFECT))) {
=======
                || packageName.equals(PACKAGE_LIVE_WALLPAPER))) {
>>>>>>> parent of a390d22e1422 (base: Switch to PixelPropsUtils)
            dlog("Spoofing Pixel 7 Pro for: " + packageName + " process: " + processName);
            sPixel7Props.forEach(PropImitationHooks::setPropValue);
        } else if (sIsPhotos) {
            dlog("Spoofing Pixel XL for Google Photos");
<<<<<<< HEAD
            sPixelXLProps.forEach((PropImitationHooks::setPropValue));
=======
            sPixelXLProps.forEach(PropImitationHooks::setPropValue);
>>>>>>> parent of a390d22e1422 (base: Switch to PixelPropsUtils)
        } else if (!sNetflixModel.isEmpty() && packageName.equals(PACKAGE_NETFLIX)) {
            dlog("Setting model to " + sNetflixModel + " for Netflix");
            setPropValue("MODEL", sNetflixModel);
        }
    }

<<<<<<< HEAD
    private static void setPropValue(String key, Object value){
=======
    private static void setPropValue(String key, Object value) {
>>>>>>> parent of a390d22e1422 (base: Switch to PixelPropsUtils)
        try {
            dlog("Setting prop " + key + " to " + value.toString());
            Field field = Build.class.getDeclaredField(key);
            field.setAccessible(true);
            field.set(null, value);
            field.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            Log.e(TAG, "Failed to set prop " + key, e);
        }
    }

<<<<<<< HEAD
=======
    private static void setCertifiedPropsForGms() {
        if (sCertifiedProps.length != 4) {
            Log.e(TAG, "Insufficient array size for certified props: "
                    + sCertifiedProps.length + ", required 4");
            return;
        }
        final boolean was = isGmsAddAccountActivityOnTop();
        final TaskStackListener taskStackListener = new TaskStackListener() {
            @Override
            public void onTaskStackChanged() {
                final boolean is = isGmsAddAccountActivityOnTop();
                if (is ^ was) {
                    dlog("GmsAddAccountActivityOnTop is:" + is + " was:" + was +
                            ", killing myself!"); // process will restart automatically later
                    Process.killProcess(Process.myPid());
                }
            }
        };
        if (!was) {
            dlog("Spoofing build for GMS");
            setPropValue("DEVICE", sCertifiedProps[0]);
            setPropValue("PRODUCT", sCertifiedProps[1]);
            setPropValue("MODEL", sCertifiedProps[2]);
            setPropValue("FINGERPRINT", sCertifiedProps[3]);
        } else {
            dlog("Skip spoofing build for GMS, because GmsAddAccountActivityOnTop");
        }
        try {
            ActivityTaskManager.getService().registerTaskStackListener(taskStackListener);
        } catch (Exception e) {
            Log.e(TAG, "Failed to register task stack listener!", e);
        }
    }

    private static boolean isGmsAddAccountActivityOnTop() {
        try {
            final ActivityTaskManager.RootTaskInfo focusedTask =
                    ActivityTaskManager.getService().getFocusedRootTaskInfo();
            return focusedTask != null && focusedTask.topActivity != null
                    && focusedTask.topActivity.equals(GMS_ADD_ACCOUNT_ACTIVITY);
        } catch (Exception e) {
            Log.e(TAG, "Unable to get top activity!", e);
        }
        return false;
    }

    public static boolean shouldBypassTaskPermission(Context context) {
        // GMS doesn't have MANAGE_ACTIVITY_TASKS permission
        final int callingUid = Binder.getCallingUid();
        final int gmsUid;
        try {
            gmsUid = context.getPackageManager().getApplicationInfo(PACKAGE_GMS, 0).uid;
            dlog("shouldBypassTaskPermission: gmsUid:" + gmsUid + " callingUid:" + callingUid);
        } catch (Exception e) {
            Log.e(TAG, "shouldBypassTaskPermission: unable to get gms uid", e);
            return false;
        }
        return gmsUid == callingUid;
    }

>>>>>>> parent of a390d22e1422 (base: Switch to PixelPropsUtils)
    private static boolean isCallerSafetyNet() {
        return sIsGms && Arrays.stream(Thread.currentThread().getStackTrace())
                .anyMatch(elem -> elem.getClassName().contains("DroidGuard"));
    }

    public static void onEngineGetCertificateChain() {
        // Check stack for SafetyNet or Play Integrity
        if (isCallerSafetyNet() || sIsFinsky) {
            dlog("Blocked key attestation sIsGms=" + sIsGms + " sIsFinsky=" + sIsFinsky);
            throw new UnsupportedOperationException();
        }
    }

<<<<<<< HEAD
    private static void dlog(String msg) {
      if (DEBUG) Log.d(TAG, msg);
=======
    public static boolean hasSystemFeature(String name, boolean def) {
        if (sIsPhotos && def && sFeatureBlacklist.stream().anyMatch(name::contains)) {
            dlog("Blocked system feature " + name + " for Google Photos");
            return false;
        }
        if (sIsASI && def && sTensorFeatureBlacklist.stream().anyMatch(name::contains)) {
            dlog("Blocked system feature " + name + " for ASI");
            return false;
        }
        if (sIsPixelLauncher && def && sTensorFeatureBlacklist.stream().anyMatch(name::contains)) {
            dlog("Blocked system feature " + name + " for Pixel Launcher");
            return false;
        }
        return def;
    }

    private static void dlog(String msg) {
        if (DEBUG) Log.d(TAG, "[" + sProcessName + "] " + msg);
>>>>>>> parent of a390d22e1422 (base: Switch to PixelPropsUtils)
    }
}
