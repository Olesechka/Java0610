package lesson9;

public class Stats<T extends Number> {
    private T[] nums;


    public Stats(T... nums) {
        this.nums = nums;
    }

    public double avg() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }

        return sum / nums.length;
    }

    //? - значит что может передаваться любой тип (явно говорим компилятору)

    //когда у нас в методе isSaveAvg <T> он потянет то Т, которое изначально к нам прилетело в класс
    //а мы со знаком ? позволяем ему ещё больше расшириться
    public boolean isSaveAvg(Stats<?> stats) {
        return Math.abs(this.avg() - stats.avg()) < 0.0001;
    }
}
