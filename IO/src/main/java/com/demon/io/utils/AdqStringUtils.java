package com.demon.io.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;

public class AdqStringUtils extends StringUtils {
    private static final char SEPARATOR = '_';
    private static final String CHARSET_NAME = "UTF-8";

    public AdqStringUtils() {
    }

    public static byte[] getBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException var2) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static Boolean toBoolean(final Object val) {
        return val == null ? false : BooleanUtils.toBoolean(val.toString()) || "1".equals(val.toString());
    }

    public static String toString(byte[] bytes) {
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException var2) {
            return "";
        }
    }

    public static String toString(final Object obj, final String defaultVal) {
        return obj == null ? defaultVal : obj.toString();
    }

    public static boolean inString(String str, String... strs) {
        if (str != null) {
            String[] var2 = strs;
            int var3 = strs.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                String s = var2[var4];
                if (str.equals(trim(s))) {
                    return true;
                }
            }
        }

        return false;
    }

    public static String replaceHtml(String html) {
        if (isBlank(html)) {
            return "";
        } else {
            String regEx = "<.+?>";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(html);
            String s = m.replaceAll("");
            return s;
        }
    }

    public static String replaceMobileHtml(String html) {
        return html == null ? "" : html.replaceAll("<([a-z]+?)\\s+?.*?>", "<$1>");
    }

    public static String abbr(String str, int length) {
        if (str == null) {
            return "";
        } else {
            try {
                StringBuilder sb = new StringBuilder();
                int currentLength = 0;
                char[] var4 = replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray();
                int var5 = var4.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    char c = var4[var6];
                    currentLength += String.valueOf(c).getBytes("GBK").length;
                    if (currentLength > length - 3) {
                        sb.append("...");
                        break;
                    }

                    sb.append(c);
                }

                return sb.toString();
            } catch (UnsupportedEncodingException var8) {
                var8.printStackTrace();
                return "";
            }
        }
    }

    public static String abbr2(String param, int length) {
        if (param == null) {
            return "";
        } else {
            StringBuffer result = new StringBuffer();
            int n = 0;
            boolean isCode = false;
            boolean isHTML = false;

            for(int i = 0; i < param.length(); ++i) {
                char temp = param.charAt(i);
                if (temp == '<') {
                    isCode = true;
                } else if (temp == '&') {
                    isHTML = true;
                } else if (temp == '>' && isCode) {
                    --n;
                    isCode = false;
                } else if (temp == ';' && isHTML) {
                    isHTML = false;
                }

                try {
                    if (!isCode && !isHTML) {
                        n += String.valueOf(temp).getBytes("GBK").length;
                    }
                } catch (UnsupportedEncodingException var12) {
                    var12.printStackTrace();
                }

                if (n > length - 3) {
                    result.append("...");
                    break;
                }

                result.append(temp);
            }

            String temp_result = result.toString().replaceAll("(>)[^<>]*(<?)", "$1$2");
            temp_result = temp_result.replaceAll("</?(AREA|BASE|BASEFONT|BODY|BR|COL|COLGROUP|DD|DT|FRAME|HEAD|HR|HTML|IMG|INPUT|ISINDEX|LI|LINK|META|OPTION|P|PARAM|TBODY|TD|TFOOT|TH|THEAD|TR|area|base|basefont|body|br|col|colgroup|dd|dt|frame|head|hr|html|img|input|isindex|li|link|meta|option|p|param|tbody|td|tfoot|th|thead|tr)[^<>]*/?>", "");
            temp_result = temp_result.replaceAll("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>", "$2");
            Pattern p = Pattern.compile("<([a-zA-Z]+)[^<>]*>");
            Matcher m = p.matcher(temp_result);
            ArrayList endHTML = new ArrayList();

            while(m.find()) {
                endHTML.add(m.group(1));
            }

            for(int i = endHTML.size() - 1; i >= 0; --i) {
                result.append("</");
                result.append((String)endHTML.get(i));
                result.append(">");
            }

            return result.toString();
        }
    }

    public static Double toDouble(Object val) {
        if (val == null) {
            return 0.0D;
        } else {
            try {
                return Double.valueOf(trim(val.toString()));
            } catch (Exception var2) {
                return 0.0D;
            }
        }
    }

    public static Float toFloat(Object val) {
        return toDouble(val).floatValue();
    }

    public static Long toLong(Object val) {
        return toDouble(val).longValue();
    }

    public static Integer toInteger(Object val) {
        return toLong(val).intValue();
    }

    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        } else {
            s = s.toLowerCase();
            StringBuilder sb = new StringBuilder(s.length());
            boolean upperCase = false;

            for(int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c == '_') {
                    upperCase = true;
                } else if (upperCase) {
                    sb.append(Character.toUpperCase(c));
                    upperCase = false;
                } else {
                    sb.append(c);
                }
            }

            return sb.toString();
        }
    }

    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        } else {
            s = toCamelCase(s);
            String var10000 = s.substring(0, 1).toUpperCase();
            return var10000 + s.substring(1);
        }
    }

    public static String toUnderScoreCase(String s) {
        if (s == null) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            boolean upperCase = false;

            for(int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                boolean nextUpperCase = true;
                if (i < s.length() - 1) {
                    nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
                }

                if (i > 0 && Character.isUpperCase(c)) {
                    if (!upperCase || !nextUpperCase) {
                        sb.append('_');
                    }

                    upperCase = true;
                } else {
                    upperCase = false;
                }

                sb.append(Character.toLowerCase(c));
            }

            return sb.toString();
        }
    }

    public static String jsGetVal(String objectString) {
        StringBuilder result = new StringBuilder();
        StringBuilder val = new StringBuilder();
        String[] vals = split(objectString, ".");

        for(int i = 0; i < vals.length; ++i) {
            val.append("." + vals[i]);
            result.append("!" + val.substring(1) + "?'':");
        }

        result.append(val.substring(1));
        return result.toString();
    }

    public static boolean hasText(String str) {
        return str != null && !str.isEmpty() && containsText(str);
    }

    private static boolean containsText(CharSequence str) {
        int strLen = str.length();

        for(int i = 0; i < strLen; ++i) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    public static String toString(Object obj) {
        if (obj == null) {
            return "null";
        } else if (obj.getClass().isPrimitive()) {
            return String.valueOf(obj);
        } else if (obj instanceof String) {
            return (String)obj;
        } else if (!(obj instanceof Number) && !(obj instanceof Character) && !(obj instanceof Boolean)) {
            if (obj instanceof Date) {
                return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S")).format(obj);
            } else {
                StringBuilder sb;
                Iterator var9;
                Object k;
                if (obj instanceof Collection) {
                    sb = new StringBuilder();
                    sb.append("[");
                    if (!((Collection)obj).isEmpty()) {
                        var9 = ((Collection)obj).iterator();

                        while(var9.hasNext()) {
                            k = var9.next();
                            sb.append(toString(k)).append(",");
                        }

                        sb.deleteCharAt(sb.length() - 1);
                    }

                    sb.append("]");
                    return sb.toString();
                } else if (obj instanceof Map) {
                    sb = new StringBuilder();
                    sb.append("{");
                    if (!((Map)obj).isEmpty()) {
                        var9 = ((Map)obj).keySet().iterator();

                        while(var9.hasNext()) {
                            k = var9.next();
                            Object v = ((Map)obj).get(k);
                            sb.append(toString(k)).append("->").append(toString(v)).append(",");
                        }

                        sb.deleteCharAt(sb.length() - 1);
                    }

                    sb.append("}");
                    return sb.toString();
                } else {
                    sb = new StringBuilder();
                    Field[] fields = obj.getClass().getDeclaredFields();
                    Field[] var3 = fields;
                    int var4 = fields.length;

                    for(int var5 = 0; var5 < var4; ++var5) {
                        final Field field = var3[var5];
                        AccessController.doPrivileged(new PrivilegedAction() {
                            public Object run() {
                                field.setAccessible(true);
                                return null;
                            }
                        });
                        sb.append(field.getName());
                        sb.append("=");

                        try {
                            Object f = field.get(obj);
                            sb.append(toString(f));
                        } catch (Exception var8) {
                        }

                        sb.append(";");
                    }

                    return sb.toString();
                }
            }
        } else {
            return String.valueOf(obj);
        }
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
