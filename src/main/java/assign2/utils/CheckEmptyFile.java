package assign2.utils;

import java.io.File;

public class CheckEmptyFile {
    public static boolean read(String path){
        File file=new File(path);
        if(file==null || file.length()==0){
            return true;
        }
        return false;
    }
}
