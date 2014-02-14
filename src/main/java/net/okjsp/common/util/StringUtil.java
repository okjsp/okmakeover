package net.okjsp.common.util;

/**
 * User: langerhans
 * Date: 2014. 2. 12.
 * Time: 오후 3:26
 * Description : StringUtil
 */
public class StringUtil {

    public static String mask( String str, int length ) {

        if(str == null || "".equals(str)) return "";

        int strLength = str.length();

        if(strLength < length) length = str.length();

        StringBuffer masked = new StringBuffer(str.substring( 0 , strLength - length ));
        for(int i =0; i < length; i++) masked.append("*");

        return masked.toString();
    }

    public static String nlToBr(String str) {

        if (str == null || "".equals(str)) return "";

        return str.replaceAll("(\r\n|\n\r|\r|\n)", "<br />");
    }
}
