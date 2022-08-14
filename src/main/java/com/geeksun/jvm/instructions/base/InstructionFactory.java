package com.geeksun.jvm.instructions.base;

import com.geeksun.jvm.instructions.comparisons.*;
import com.geeksun.jvm.instructions.constants.*;
import com.geeksun.jvm.instructions.control.*;
import com.geeksun.jvm.instructions.conversions.*;
import com.geeksun.jvm.instructions.extended.GotoW;
import com.geeksun.jvm.instructions.extended.IfNotNull;
import com.geeksun.jvm.instructions.extended.IfNull;
import com.geeksun.jvm.instructions.extended.Wide;
import com.geeksun.jvm.instructions.loads.*;
import com.geeksun.jvm.instructions.math.*;
import com.geeksun.jvm.instructions.stack.*;
import com.geeksun.jvm.instructions.stores.*;
import com.sun.org.apache.bcel.internal.generic.FADD;

import java.util.HashMap;
import java.util.Map;

public class InstructionFactory {

    private static Map<Integer, Instruction> codeMap = new HashMap<>();

    private static Map<String, Instruction> nameMap = new HashMap<>();

    static {
        putInstruction(new DCmpg());
        putInstruction(new DCmpl());
        putInstruction(new FCmpg());
        putInstruction(new FCmpl());
        putInstruction(new If_acmpeq());
        putInstruction(new If_acmpne());
        putInstruction(new If_icmpeq());
        putInstruction(new If_icmpne());
        putInstruction(new If_icmpge());
        putInstruction(new If_icmpgt());
        putInstruction(new If_icmple());
        putInstruction(new If_icmplt());
        putInstruction(new If_icmpne());
        putInstruction(new Ifeq());
        putInstruction(new Ifge());
        putInstruction(new Ifgt());
        putInstruction(new Ifle());
        putInstruction(new Iflt());
        putInstruction(new Ifne());
        putInstruction(new Lcmp());

        putInstruction(new AConstNull());
        putInstruction(new BiPush());
        putInstruction(new DConst0());
        putInstruction(new DConst0());
        putInstruction(new FConst0());
        putInstruction(new FConst1());
        putInstruction(new FConst2());
        putInstruction(new IConst0());
        putInstruction(new IConst1());
        putInstruction(new IConst2());
        putInstruction(new IConst3());
        putInstruction(new IConst4());
        putInstruction(new IConst5());
        putInstruction(new IConstM1());
        putInstruction(new LConst0());
        putInstruction(new LConst1());
        putInstruction(new Ldc());
        putInstruction(new Ldc2W());
        putInstruction(new LdcW());
        putInstruction(new Nop());
        putInstruction(new SiPush());


        putInstruction(new AReturn());
        putInstruction(new DReturn());
        putInstruction(new FReturn());
        putInstruction(new Goto());
        putInstruction(new IReturn());
        putInstruction(new Jsr());
        putInstruction(new LookUpSwitch());
        putInstruction(new LReturn());
        putInstruction(new Ret());
        putInstruction(new Return());
        putInstruction(new TableSwitch());


        putInstruction(new D2F());
        putInstruction(new D2I());
        putInstruction(new D2L());
        putInstruction(new F2D());
        putInstruction(new F2I());
        putInstruction(new F2L());
        putInstruction(new I2B());
        putInstruction(new I2C());
        putInstruction(new I2D());
        putInstruction(new I2F());
        putInstruction(new I2L());
        putInstruction(new I2S());
        putInstruction(new I2D());
        putInstruction(new L2F());
        putInstruction(new L2I());

        putInstruction(new GotoW());
        putInstruction(new IfNotNull());
        putInstruction(new IfNull());
        putInstruction(new Wide());


        putInstruction(new AaLoad());
        putInstruction(new ALoad());
        putInstruction(new ALoad0());
        putInstruction(new ALoad1());
        putInstruction(new ALoad2());
        putInstruction(new ALoad3());
        putInstruction(new BaLoad());
        putInstruction(new CaLoad());
        putInstruction(new DaLoad());
        putInstruction(new DLoad());
        putInstruction(new DLoad0());
        putInstruction(new DLoad1());
        putInstruction(new DLoad2());
        putInstruction(new DLoad3());
        putInstruction(new FaLoad());
        putInstruction(new FLoad());
        putInstruction(new FLoad0());
        putInstruction(new FLoad1());
        putInstruction(new FLoad2());
        putInstruction(new FLoad3());
        putInstruction(new IaLoad());
        putInstruction(new ILoad());
        putInstruction(new ILoad0());
        putInstruction(new ILoad1());
        putInstruction(new ILoad2());
        putInstruction(new ILoad3());
        putInstruction(new LaLoad());
        putInstruction(new LLoad());
        putInstruction(new LLoad0());
        putInstruction(new LLoad1());
        putInstruction(new LLoad2());
        putInstruction(new LLoad3());
        putInstruction(new SaLoad());
        putInstruction(new XaLoad());


        putInstruction(new DAdd());
        putInstruction(new DDiv());
        putInstruction(new DMul());
        putInstruction(new DNeg());
        putInstruction(new DRem());
        putInstruction(new DSub());
        putInstruction(new FAdd());
        putInstruction(new FDiv());
        putInstruction(new FMul());
        putInstruction(new FNeg());
        putInstruction(new FRem());
        putInstruction(new FSub());
        putInstruction(new IAdd());
        putInstruction(new IAnd());
        putInstruction(new IDiv());
        putInstruction(new IInc());
        putInstruction(new IMul());
        putInstruction(new INeg());
        putInstruction(new IOr());
        putInstruction(new IRem());
        putInstruction(new IShl());
        putInstruction(new IShr());
        putInstruction(new ISub());
        putInstruction(new IUShr());
        putInstruction(new IXor());
        putInstruction(new LAdd());
        putInstruction(new LAnd());
        putInstruction(new LDiv());
        putInstruction(new LMul());
        putInstruction(new LNeg());
        putInstruction(new LOr());
        putInstruction(new LRem());
        putInstruction(new LShl());
        putInstruction(new LShr());
        putInstruction(new LSub());
        putInstruction(new LUShr());
        putInstruction(new LXor());


        putInstruction(new Dup());
        putInstruction(new Dup2());
        putInstruction(new Dup2_x1());
        putInstruction(new Dup2_x2());
        putInstruction(new Dup_x1());
        putInstruction(new Dup_x2());
        putInstruction(new Pop());
        putInstruction(new Pop2());
        putInstruction(new Swap());

        putInstruction(new AStore());
        putInstruction(new AStore0());
        putInstruction(new AStore1());
        putInstruction(new AStore2());
        putInstruction(new AStore3());
        putInstruction(new DStore());
        putInstruction(new DStore0());
        putInstruction(new DStore1());
        putInstruction(new DStore2());
        putInstruction(new DStore3());
        putInstruction(new FStore());
        putInstruction(new FStore0());
        putInstruction(new FStore1());
        putInstruction(new FStore2());
        putInstruction(new FStore3());
        putInstruction(new IStore());
        putInstruction(new IStore0());
        putInstruction(new IStore1());
        putInstruction(new IStore2());
        putInstruction(new IStore3());
        putInstruction(new LStore());
        putInstruction(new LStore0());
        putInstruction(new LStore1());
        putInstruction(new LStore2());
        putInstruction(new LStore3());

    }

    private static void putInstruction(Instruction instruction){
        codeMap.put(instruction.getOpCode(), instruction);
        nameMap.put(instruction.getReName(), instruction);
    }


}
