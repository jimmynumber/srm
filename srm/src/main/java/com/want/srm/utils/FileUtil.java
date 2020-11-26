package com.want.srm.utils;


import java.util.Calendar;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static String getSaveFileName(String filename) {
		String srtn = "" + UUID.randomUUID();
		int index = filename.lastIndexOf(".");
		if (index >= 0) {
			filename = filename.substring(index + 1);
			srtn += "." + filename;
		}
		return srtn;
	}

	public static String getFileSavePath() {
		String year = new Integer(Calendar.getInstance().get(Calendar.YEAR)).toString();
		String month = parseToString(Calendar.getInstance().get(Calendar.MONTH) + 1);
		String day = parseToString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		String hour = parseToString(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
		//String path = "/" + year + month + "/" + day + "/" + hour + "/";
		String path = "/" + year + month + "/";
		return path;
	}

	public static String parseToString(int i) {
		return i < 10 ? ("0" + i) : new Integer(i).toString();
	}
}
