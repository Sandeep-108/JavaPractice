package commons;

public class SumObserver implements ResultListener<Integer> {

    private String taskId;

    public SumObserver(String taskId){
        this.taskId=taskId;
    }
    @Override
    public void notifyResult(Integer result) {

        System.out.println("result for "+taskId+" "+result);
    }
}
