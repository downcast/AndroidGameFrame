package com.speechshark.msmith.androidgameframe;

import android.util.Log;

/** Used to allow a quick and more detailed account of runtime events. Simply set DEBUG to true call WriteLog to display message on the terminal.
 * Created by Marcus on 3/13/2015.
 */
public class DebugLogger {

	public static final boolean DEBUG= false;

	/** Prints "Level | Tag: message"
	 *
	 * @param level the severity of the message
	 * @param tag the "Class - method" that called
	 * @param message the text describing what happened to warrant the message
	 */
	public static void WriteLog(TagSeverity level, String tag, String message){
		if (DebugLogger.DEBUG) { Log.d(level.name() + " | " + tag, message); }
	}

	/** Used to determine severity of incoming message. <br>
	 * REPORT = Normal usage - eg. Player has fired weapon. <br>
	 * WARNING = Possible error - event that minimally affects performance or bug that could create ERROR. <br>
	 * ERROR = Bug - an error that impacts performance noticeably but has a fairly limited damage range. <br>
	 * CRITICAL = Major Problem - a serious error that affects multiple dependent areas causing system instability. <br>
	 * FAILURE = Worst Case - a critical error rendering the system unusable. <br>
	 */
	public static enum TagSeverity {
		REPORT,
		WARNING,
		ERROR,
		CRITICAL,
		FAILURE
	}
}
