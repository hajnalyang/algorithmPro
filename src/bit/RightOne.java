package bit;

public class RightOne {
    public static int findRightOne(int num){
        return num & (-num);
        //num:      0110 1101 0000
        //~num:     1001 0010 1111
        //~num+1:   1001 0011 0000
        //----------------------------
        //          0000 0001 0000

    }

    public static void main(String[] args) {
        System.out.println(findRightOne(6));
    }
}
