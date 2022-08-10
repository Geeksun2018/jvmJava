import com.geeksun.jvm.rtda.Frame;
import com.geeksun.jvm.rtda.LocalVars;
import com.geeksun.jvm.rtda.OperandStack;
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

    @org.junit.Test
    public void startJVM(){
        Frame frame = new Frame(100, 100);
        testLocalVars(frame.getLocalVars());
        testOperandStack(frame.getOperandStack());
    }

    public void testLocalVars(LocalVars localVars){
        localVars.setInt(0, 100);
        localVars.setInt(1, -100);
        localVars.setLong(2, 2997924580L);
        localVars.setLong(4, -2997924580L);
        localVars.setFloat(6, 3.1415926F);
        localVars.setDouble(7, 2.71828182845);
        localVars.setRef(9, null);
        System.out.println(localVars.getInt(0));
        System.out.println(localVars.getInt(1));
        System.out.println(localVars.getLong(2));
        System.out.println(localVars.getLong(4));
        System.out.println(localVars.getFloat(6));
        System.out.println(localVars.getDouble(7));//
        System.out.println(localVars.getRef(9));
        System.out.println();
    }

    public void testOperandStack(OperandStack operandStack){
        operandStack.pushInt(100);
        operandStack.pushInt(-100);
        operandStack.pushLong(2997924580L);
        operandStack.pushLong(-2997924580L);
        operandStack.pushFloat(3.1415926F);
        operandStack.pushDouble(2.71828182845);
        operandStack.pushRef(null);
        System.out.println(operandStack.popRef());
        System.out.println(operandStack.popDouble());//
        System.out.println(operandStack.popFloat());
        System.out.println(operandStack.popLong());//
        System.out.println(operandStack.popLong());
        System.out.println(operandStack.popInt());
        System.out.println(operandStack.popInt());
        System.out.println();
    }



}
