public class OutOfRangeException extends Exception{
    private int min;
    private int max;
    public OutOfRangeException(){
        super();
    }
    public OutOfRangeException(int min,int max) {
        this.min = min;
        this.max = max;
    }
    // this method override and return that number must be between the min and the max
    @Override
    public String getMessage(){
        return "Number must be between " + this.min + " and "+ this.max;
    }

}
