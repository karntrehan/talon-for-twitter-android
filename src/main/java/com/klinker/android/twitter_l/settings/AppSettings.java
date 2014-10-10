package com.klinker.android.twitter_l.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import com.klinker.android.twitter_l.R;
import com.klinker.android.twitter_l.data.ThemeColor;
import com.klinker.android.twitter_l.utils.EmojiUtils;

import java.util.Calendar;

public class AppSettings {

    public static AppSettings settings;

    public static AppSettings getInstance(Context context) {
        if (settings == null) {
            settings = new AppSettings(context);
        }
        return settings;
    }

    public static void invalidate() {
        settings = null;
    }

    public SharedPreferences sharedPrefs;

    public static String TWITTER_CONSUMER_KEY = "***REMOVED***";
    public static String TWITTER_CONSUMER_SECRET = "***REMOVED***";

    public static String YOUTUBE_API_KEY = "AIzaSyCCL7Rem3uo1zPBpy88KANXIaX2_bYWEtM";

    public static final int THEME_RED = 0;
    public static final int THEME_PINK = 1;
    public static final int THEME_PURPLE = 2;
    public static final int THEME_DEEP_PURPLE = 3;
    public static final int THEME_INDIGO = 4;
    public static final int THEME_BLUE = 5;
    public static final int THEME_LIGHT_BLUE = 6;
    public static final int THEME_CYAN = 7;
    public static final int THEME_TEAL = 8;
    public static final int THEME_GREEN = 9;
    public static final int THEME_LIGHT_GREEN = 10;
    public static final int THEME_LIME = 11;
    public static final int THEME_YELLOW = 12;
    public static final int THEME_AMBER = 13;
    public static final int THEME_ORANGE = 14;
    public static final int THEME_DEEP_ORANGE = 15;
    public static final int THEME_BROWN = 16;
    public static final int THEME_GREY = 17;
    public static final int THEME_BLUE_GREY = 18;

    public static final int DEFAULT_THEME = THEME_ORANGE;

    public static final int WIDGET_LIGHT = 0;
    public static final int WIDGET_DARK = 1;
    public static final int WIDGET_TRANS_LIGHT = 2;
    public static final int WIDGET_TRANS_BLACK = 3;

    public static final int PAGE_TWEET = 0;
    public static final int PAGE_WEB = 1;
    public static final int PAGE_CONVO = 2;

    public static final int PAGE_TYPE_NONE = 0;
    public static final int PAGE_TYPE_PICS = 1;
    public static final int PAGE_TYPE_LINKS = 2;
    public static final int PAGE_TYPE_LIST = 3;
    public static final int PAGE_TYPE_FAV_USERS = 4;

    public static final int LAYOUT_TALON = 0;
    public static final int LAYOUT_HANGOUT = 1;
    public static final int LAYOUT_FULL_SCREEN = 2;

    public String authenticationToken;
    public String authenticationTokenSecret;
    public String secondAuthToken;
    public String secondAuthTokenSecret;
    public String myScreenName;
    public String secondScreenName;
    public String myName;
    public String myBackgroundUrl;
    public String myProfilePicUrl;
    public String secondProfilePicUrl;
    public String favoriteUserNames;

    public boolean darkTheme;
    public boolean isTwitterLoggedIn;
    public boolean reverseClickActions;
    public boolean advanceWindowed;
    public boolean notifications;
    public boolean led;
    public boolean vibrate;
    public boolean sound;
    public boolean refreshOnStart;
    public boolean autoTrim;
    public boolean uiExtras;
    public boolean wakeScreen;
    public boolean nightMode;
    public boolean militaryTime;
    public boolean syncMobile;
    public boolean useEmoji;
    public boolean inlinePics;
    public boolean extraPages;
    public boolean fullScreenBrowser;
    public boolean favoriteUserNotifications;
    public boolean syncSecondMentions;
    public boolean displayScreenName;
    public boolean liveStreaming;
    public boolean pushNotifications;
    public boolean inAppBrowser;
    public boolean showBoth;
    public boolean preferRT;
    public boolean absoluteDate;
    public boolean useToast;
    public boolean autoInsertHashtags;
    public boolean alwaysCompose;
    public boolean twitlonger;
    public boolean twitpic;
    public boolean tweetmarker;
    public boolean tweetmarkerManualOnly;
    public boolean jumpingWorkaround;
    public boolean floatingCompose;
    public boolean openKeyboard;
    public boolean alwaysMobilize;
    public boolean mobilizeOnData;
    public boolean preCacheImages;
    public boolean fastTransitions;
    public boolean topDown;

    // notifications
    public boolean timelineNot;
    public boolean mentionsNot;
    public boolean dmsNot;
    public boolean followersNot;
    public boolean favoritesNot;
    public boolean retweetNot;
    public String ringtone;

    // theme stuff
    public boolean addonTheme;
    public String addonThemePackage;
    public boolean roundContactImages;
    public int backgroundColor;
    public boolean translateProfileHeader;
    public boolean nameAndHandleOnTweet = false;
    public boolean combineProPicAndImage = false;
    public boolean sendToComposeWindow = false;
    public boolean showTitleStrip = true;
    public String accentColor;
    public int accentInt;
    public int pagerTitleInt;
    public Drawable actionBar = null;
    public Drawable customBackground = null;

    public int theme;
    public int layout;
    public int currentAccount;
    public int textSize;
    public int maxTweetsRefresh;
    public int timelineSize;
    public int mentionsSize;
    public int dmSize;
    public int pageToOpen;

    public long timelineRefresh;
    public long mentionsRefresh;
    public long dmRefresh;
    public long myId;


    public AppSettings(Context context) {
        sharedPrefs = context.getSharedPreferences("com.klinker.android.twitter_world_preferences",
                Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE);

        setPrefs(sharedPrefs, context);
    }

    public AppSettings(SharedPreferences sharedPrefs, Context context) {
        setPrefs(sharedPrefs, context);
    }

    public void setPrefs(SharedPreferences sharedPrefs, Context context) {
        // Strings
        if (sharedPrefs.getInt("current_account", 1) == 1) {
            authenticationToken = sharedPrefs.getString("authentication_token_1", "none");
            authenticationTokenSecret = sharedPrefs.getString("authentication_token_secret_1", "none");
            secondAuthToken = sharedPrefs.getString("authentication_token_2", "none");
            secondAuthTokenSecret = sharedPrefs.getString("authentication_token_secret_2", "none");
            myScreenName = sharedPrefs.getString("twitter_screen_name_1", "");
            secondScreenName = sharedPrefs.getString("twitter_screen_name_2", "");
            myName = sharedPrefs.getString("twitter_users_name_1", "");
            myBackgroundUrl = sharedPrefs.getString("twitter_background_url_1", "");
            myProfilePicUrl = sharedPrefs.getString("profile_pic_url_1", "");
            favoriteUserNames = sharedPrefs.getString("favorite_user_names_1", "");
            myId = sharedPrefs.getLong("twitter_id_1", 0);
        } else {
            authenticationToken = sharedPrefs.getString("authentication_token_2", "none");
            authenticationTokenSecret = sharedPrefs.getString("authentication_token_secret_2", "none");
            secondAuthToken = sharedPrefs.getString("authentication_token_1", "none");
            secondAuthTokenSecret = sharedPrefs.getString("authentication_token_secret_1", "none");
            myScreenName = sharedPrefs.getString("twitter_screen_name_2", "");
            secondScreenName = sharedPrefs.getString("twitter_screen_name_1", "");
            myName = sharedPrefs.getString("twitter_users_name_2", "");
            myBackgroundUrl = sharedPrefs.getString("twitter_background_url_2", "");
            myProfilePicUrl = sharedPrefs.getString("profile_pic_url_2", "");
            favoriteUserNames = sharedPrefs.getString("favorite_user_names_2", "");
            myId = sharedPrefs.getLong("twitter_id_2", 0);
        }

        Log.v("talon_pro_pic", myProfilePicUrl);

        // Booleans
        darkTheme = sharedPrefs.getBoolean("dark_theme", false);
        isTwitterLoggedIn = sharedPrefs.getBoolean("is_logged_in_1", false) || sharedPrefs.getBoolean("is_logged_in_2", false);
        reverseClickActions = sharedPrefs.getBoolean("reverse_click_option", true);
        advanceWindowed = sharedPrefs.getBoolean("advance_windowed", true);
        notifications = sharedPrefs.getBoolean("notifications", true);
        led = sharedPrefs.getBoolean("led", true);
        sound = sharedPrefs.getBoolean("sound", true);
        vibrate = sharedPrefs.getBoolean("vibrate", true);
        refreshOnStart = sharedPrefs.getBoolean("refresh_on_start", false);
        autoTrim = sharedPrefs.getBoolean("auto_trim", true);
        uiExtras = sharedPrefs.getBoolean("ui_extras", true);
        wakeScreen = sharedPrefs.getBoolean("wake", true);
        militaryTime = sharedPrefs.getBoolean("military_time", false);
        syncMobile = sharedPrefs.getBoolean("sync_mobile_data", true);
        inlinePics = sharedPrefs.getBoolean("inline_pics", true);
        extraPages = sharedPrefs.getBoolean("extra_pages", true);
        fullScreenBrowser = sharedPrefs.getBoolean("full_screen_browser", true);
        favoriteUserNotifications = sharedPrefs.getBoolean("favorite_users_notifications", true);
        syncSecondMentions = sharedPrefs.getBoolean("sync_second_mentions", true);
        displayScreenName = sharedPrefs.getBoolean("display_screen_name", false);
        inAppBrowser = sharedPrefs.getBoolean("inapp_browser", true);
        showBoth = sharedPrefs.getBoolean("both_handle_name", false);
        timelineNot = sharedPrefs.getBoolean("timeline_notifications", true);
        mentionsNot = sharedPrefs.getBoolean("mentions_notifications", true);
        dmsNot = sharedPrefs.getBoolean("direct_message_notifications", true);
        favoritesNot = sharedPrefs.getBoolean("favorite_notifications", true);
        retweetNot = sharedPrefs.getBoolean("retweet_notifications", true);
        followersNot = sharedPrefs.getBoolean("follower_notifications", true);
        preferRT = sharedPrefs.getString("quote_style", "0").equals("1");
        absoluteDate = sharedPrefs.getBoolean("absolute_date", false);
        useToast = sharedPrefs.getBoolean("use_toast", true);
        autoInsertHashtags = sharedPrefs.getBoolean("auto_insert_hashtags", false);
        alwaysCompose = sharedPrefs.getBoolean("always_compose", false);
        twitlonger = true;
        twitpic = sharedPrefs.getBoolean("twitpic", false);
        jumpingWorkaround = sharedPrefs.getBoolean("jumping_workaround", false);
        floatingCompose = sharedPrefs.getBoolean("floating_compose", true);
        openKeyboard = sharedPrefs.getBoolean("open_keyboard", false);
        preCacheImages = !sharedPrefs.getString("pre_cache", "1").equals("0");
        topDown = sharedPrefs.getBoolean("top_down_mode", false);

        if (sharedPrefs.getString("pre_cache", "1").equals("2")) {
            sharedPrefs.edit().putBoolean("pre_cache_wifi_only", true).commit();
        } else {
            sharedPrefs.edit().putBoolean("pre_cache_wifi_only", false).commit();
        }

        // set up tweetmarker
        String val = sharedPrefs.getString("tweetmarker_options", "0");
        if (val.equals("0")) {
            tweetmarker = false;
            tweetmarkerManualOnly = false;
        } else if (val.equals("1")) {
            tweetmarker = true;
            tweetmarkerManualOnly = false;
        } else {
            tweetmarkerManualOnly = true;
            tweetmarker = true;
        }

        // set up the mobilized (plain text) browser
        String mobilize = sharedPrefs.getString("plain_text_browser", "0");
        if (mobilize.equals("0")) {
            alwaysMobilize = false;
            mobilizeOnData = false;
        } else if (mobilize.equals("1")) {
            alwaysMobilize = true;
            mobilizeOnData = true;
        } else {
            alwaysMobilize = false;
            mobilizeOnData = true;
        }

        ringtone = sharedPrefs.getString("ringtone", RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION).toString());

        // if they have the keyboard trial installed, then go from their preference
        if (EmojiUtils.checkEmojisEnabled(context)) {
            useEmoji = sharedPrefs.getBoolean("use_emojis", false);
        } else { // otherwise it is false
            useEmoji = false;
        }

        String pull = sharedPrefs.getString("talon_pull", "2");
        if (pull.equals("0")) {
            liveStreaming = false;
            pushNotifications = false;
        } else if (pull.equals("1")) {
            pushNotifications = true;
            liveStreaming = false;
        } else {
            pushNotifications = true;
            liveStreaming = true;
        }

        // Integers
        theme = sharedPrefs.getInt("material_theme", DEFAULT_THEME); // default is orange
        layout = LAYOUT_FULL_SCREEN;
        currentAccount = sharedPrefs.getInt("current_account", 1);
        textSize = Integer.parseInt(sharedPrefs.getString("text_size", "14"));
        maxTweetsRefresh = Integer.parseInt(sharedPrefs.getString("max_tweets", "1"));
        timelineSize = Integer.parseInt(sharedPrefs.getString("timeline_size", "500"));
        mentionsSize = Integer.parseInt(sharedPrefs.getString("mentions_size", "100"));
        dmSize = Integer.parseInt(sharedPrefs.getString("dm_size", "100"));
        pageToOpen = Integer.parseInt(sharedPrefs.getString("viewer_page", "0"));

        // Longs
        timelineRefresh = Long.parseLong(sharedPrefs.getString("timeline_sync_interval", "0"));
        mentionsRefresh = Long.parseLong(sharedPrefs.getString("mentions_sync_interval", "0"));
        dmRefresh = Long.parseLong(sharedPrefs.getString("dm_sync_interval", "0"));

        if (sharedPrefs.getBoolean("night_mode", false)) {
            int nightStartHour = sharedPrefs.getInt("night_start_hour", 22);
            int nightStartMin = sharedPrefs.getInt("night_start_min", 0);
            int dayStartHour = sharedPrefs.getInt("day_start_hour", 6);
            int dayStartMin = sharedPrefs.getInt("day_start_min", 0);

            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minutes = c.get(Calendar.MINUTE);

            int dayStartMinutes = dayStartHour * 60 + dayStartMin;
            int nightStartMinutes = nightStartHour * 60 + nightStartMin;
            int currentMinutes = hour * 60 + minutes;

            if ((nightStartHour > dayStartHour && !(currentMinutes > dayStartMinutes && nightStartMinutes > currentMinutes)) ||
                    (nightStartHour < dayStartHour && (currentMinutes < dayStartMinutes && nightStartMinutes < currentMinutes))) {
                //nightMode = true;
                darkTheme = true;
                //theme = sharedPrefs.getInt("night_theme", 0);
            }
        }

        if (sharedPrefs.getBoolean("quiet_hours", false)) {
            int quietStartHour = sharedPrefs.getInt("quiet_start_hour", 22);
            int quietStartMin = sharedPrefs.getInt("quiet_start_min", 0);
            int quietEndHour = sharedPrefs.getInt("quiet_end_hour", 6);
            int quietEndMin = sharedPrefs.getInt("quiet_end_min", 0);

            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minutes = c.get(Calendar.MINUTE);

            int quietEndMinutes = quietEndHour * 60 + quietEndMin;
            int quietStartMinutes = quietStartHour * 60 + quietStartMin;
            int currentMinutes = hour * 60 + minutes;

            if (!(currentMinutes > quietEndMinutes && quietStartMinutes > currentMinutes)) {
                notifications = false;
                //Log.v("quiet_hours", "quiet hours set now");
            }
        }

        int count = 0;
        if (sharedPrefs.getBoolean("is_logged_in_1", false)) {
            count++;
        }
        if (sharedPrefs.getBoolean("is_logged_in_2", false)) {
            count++;
        }

        if(count != 2) {
            syncSecondMentions = false;
        }

        setColors(context);
    }

    public static boolean getCurrentTheme(SharedPreferences sharedPrefs) {
        boolean dark = sharedPrefs.getBoolean("dark_theme", false);
        if (sharedPrefs.getBoolean("night_mode", false)) {
            int nightStartHour = sharedPrefs.getInt("night_start_hour", 22);
            int nightStartMin = sharedPrefs.getInt("night_start_min", 0);
            int dayStartHour = sharedPrefs.getInt("day_start_hour", 6);
            int dayStartMin = sharedPrefs.getInt("day_start_min", 0);

            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minutes = c.get(Calendar.MINUTE);

            int dayStartMinutes = dayStartHour * 60 + dayStartMin;
            int nightStartMinutes = nightStartHour * 60 + nightStartMin;
            int currentMinutes = hour * 60 + minutes;

            if ((nightStartHour > dayStartHour && !(currentMinutes > dayStartMinutes && nightStartMinutes > currentMinutes)) ||
                    (nightStartHour < dayStartHour && (currentMinutes < dayStartMinutes && nightStartMinutes < currentMinutes))) {
                dark = true;
            }
        }

        return dark;
    }

    protected void setValue(String key, boolean value, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.klinker.android.twitter_world_preferences",
                Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE);

        sharedPreferences.edit()
                .putBoolean(key, value)
                .commit();
    }

    protected void setValue(String key, int value, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.klinker.android.twitter_world_preferences",
                Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE);

        sharedPreferences.edit()
                .putInt(key, value)
                .commit();

    }

    protected void setValue(String key, String value, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.klinker.android.twitter_world_preferences",
                Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE);

        sharedPreferences.edit()
                .putString(key, value)
                .commit();

    }

    public ThemeColor themeColors;
    private void setColors(Context context) {

        String[] themePrefixes = context.getResources().getStringArray(R.array.theme_colors);
        String prefix = themePrefixes[theme];

        themeColors = new ThemeColor(prefix, context);
    }
}
