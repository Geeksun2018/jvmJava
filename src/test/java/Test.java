import org.omg.CORBA.PRIVATE_MEMBER;

public class Test {

    @org.junit.Test
    public void HexTest(){
        long a = Long.MAX_VALUE;
        int num1 = (int)a;
        int num2 = (int)(a >> 32);

        long l1 = (num2 & 0x00000000ffffffffL) << 32;
        long l2 = num1 & 0x00000000ffffffffL;
        System.out.println(((long)l1|l2) == a);
    }

//    public List<Integer> changLong(long num) {
//        int intNum1 = (int) num;
//        int intNum2 = (int) (num >> 32);
//
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(intNum1);
//        list.add(intNum2);
//        return list;
//    }
//
//    public long getLongFromInt(int num1, int num2) {
//        // long l1 = (long)(((long)num2&0xffffffff)<<32);
//        // long l2 = (long)num1&0x00000000ffffffffL;
//        // 简写
//        long l1 = (num2 & 0x00000000ffffffffL) << 32;
//        long l2 = num1 & 0x00000000ffffffffL;
//
//        long num = l1 | l2;
//        return num;
//    }



}
