package Lesson06;

class MainClassString {
    public static void main(String[] args) {

        String str1 = " First sentence    Now second sentence     Third sentence    And fifth one  Here comes the sixth    ";
        System.out.println(str1);

        String str2 = str1.replaceAll("\\s+", " ");
        System.out.println(str2);

        StringBuilder stringBuilder = new StringBuilder(str2);

        int c = 0;

        for(int i = 2; i < str2.length(); i++) {
            if(str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Z') {
                stringBuilder.setCharAt(i-1+c, '.');
                stringBuilder.insert(i+c, ' ');
                c++;
            }
        }
        stringBuilder.replace(str2.length()+c-1,str2.length()+c,".");

        System.out.println(stringBuilder.toString());

    }
}