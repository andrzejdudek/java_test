import java.io.File;
import java.io.FilenameFilter;

public class ListOfLanguages {
	String[] pathnames;
	
	void getList() {
	
    File f = new File("/home/dawid/eclipse-workspace/Farmer");

    // Populates the array with names of files and directories
    

    // For each pathname in the pathnames array
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
