import java.io.UnsupportedEncodingException;
//getBytes将字符串以字节数组的形式返回
//getBytes("charsetName")字符编码转换
class StringMethodsDemo {
    private static byte[] transform(byte[] b, String fromCharset, String toCharset)
            throws UnsupportedEncodingException {
        String s = new String(b, fromCharset);
        return s.getBytes(toCharset);
    }
//public char[] toCharArray将字符串以字符数组的形式返回
    private static boolean isNumber(String s) {
        for (char c : s.toCharArray()) {
            /*
            if (!Character.isDigit(c)) {
                return false;
            }
            */
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] s = "中国人".getBytes("GB18030");
        for (byte b : s) {
            System.out.printf("\\x%x", b);
        }
        System.out.println();


        byte[] p = transform(s, "GB18030", "UTF-8");
        for (byte b : p) {
            System.out.printf("\\x%x", b);
        }
        System.out.println();

        System.out.println(isNumber("123456"));
        System.out.println(isNumber("ab12"));

    }
}
