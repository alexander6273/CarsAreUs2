package dat3.cars.experiment;

public class SimpleSanitizer
{
    public static String simpleSanitize(String s){
        String [] htmlTags = {"h1", "h2", "h3", "body", "b"};
        String temp = "";

        for (int i = 0; i < htmlTags.length; i++)
        {
            if (s.contains(htmlTags[i])){
                temp = htmlTags[i];
                s = s.replace("<" + temp + ">", "");
                s = s.replace("</" + temp + ">", "");
                s = s.replaceAll("^ +| +$|( )+","$1");
            }
        }
        return s;
    }
}
