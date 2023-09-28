import java.util.Date;

public class Metadata {
    private String name ;
    private boolean canRead;
    private boolean canWrite;
    private boolean canExecute;
    private Long lastModified;

    public Metadata(){

    }
    public Metadata (String name, boolean canRead, boolean canWrite, boolean canExecute,Long lastModified){
        this.name = name;
        this.canRead = canRead;
        this.canWrite = canWrite;
        this.canExecute = canExecute;
        this.lastModified = lastModified;

    }
    public void SetName(String s){
        this.name = s;

    }
    private Date ConvertLastModified(){
        java.util.Date myDate = new java.util.Date(this.lastModified);
        return myDate;
    }

    @Override
    public String toString() {
        return "File Name: "+ this.name + "\tCan read: "+ this.canRead + "\tCan Write: "+this.canWrite + "\tCan Execute: "+ this.canExecute +
                "\t Last Modified: "+ConvertLastModified();
    }
}
