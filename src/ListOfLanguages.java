import java.io.File;
import java.io.FilenameFilter;

public class ListOfLanguages {
	String[] pathnames;
	
	void getList() {
		
	final String dir = System.getProperty("user.dir");
		
    File f = new File(dir);

    FilenameFilter filter = new FilenameFilter() {
        @Override
        public boolean accept(File f, String name) {
            return name.endsWith(".properties");
        }
    };
    
    pathnames = f.list(filter);
	for(int i =0; i<pathnames.length;i++) {
		pathnames[i]=pathnames[i].substring(0, pathnames[i].length() -11);
	}
    
	}
}
