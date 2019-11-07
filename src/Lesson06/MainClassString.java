package Lesson06;

class MainClassString {
    public static void main(String[] args) {

        String str1 = " First sentence    Now second sentence     Third sentence    And fifth one  Here comes the sixth";
        System.out.println(str1);

        String str2 = str1.replaceAll("\\s+", " ");
        System.out.println(str2);

        StringBuilder stringBuilder = new StringBuilder(str2);

        for(int i = str2.length() - 1; i >= 0; i--) {
            if(str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Z') {
                stringBuilder.setCharAt(i-1, '.');
                stringBuilder.insert(i, ' ');
            }
        }

        stringBuilder.delete(0, 2);
        stringBuilder.append('.');

        System.out.println(stringBuilder.toString());

    }
}