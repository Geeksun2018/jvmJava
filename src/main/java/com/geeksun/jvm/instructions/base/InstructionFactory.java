package com.geeksun.jvm.instructions.base;

import com.geeksun.jvm.instructions.comparisons.*;
import com.geeksun.jvm.instructions.constants.AConstNull;
import com.geeksun.jvm.instructions.constants.BiPush;
import com.geeksun.jvm.instructions.constants.DConst0;

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
        putInstruction(new fconst_0());
        putInstruction(new fconst_1());
        putInstruction(new fconst_2());
        putInstruction(new iconst_0());
        putInstruction(new iconst_1());
        putInstruction(new iconst_2());
        putInstruction(new iconst_3());
        putInstruction(new iconst_4());
        putInstruction(new iconst_5());
        putInstruction(new iconst_m1());
        putInstruction(new lconst_0());
        putInstruction(new lconst_1());
        putInstruction(new ldc());
        putInstruction(new ldc2_w());
        putInstruction(new ldc_w());
        putInstruction(new nop());
        putInstruction(new sipush());


        putInstruction(new areturn());
        putInstruction(new dreturn());
        putInstruction(new freturn());
        putInstruction(new goto_());
        putInstruction(new ireturn());
        putInstruction(new jsr());
        putInstruction(new lookupswitch());
        putInstruction(new lreturn());
        putInstruction(new ret());
        putInstruction(new return_());
        putInstruction(new tableswitch());


        putInstruction(new d2f());
        putInstruction(new d2i());
        putInstruction(new d2l());
        putInstruction(new f2d());
        putInstruction(new f2i());
        putInstruction(new f2l());
        putInstruction(new i2b());
        putInstruction(new i2c());
        putInstruction(new i2d());
        putInstruction(new i2f());
        putInstruction(new i2l());
        putInstruction(new i2s());
        putInstruction(new l2d());
        putInstruction(new l2f());
        putInstruction(new l2i());

        putInstruction(new gotow());
        putInstruction(new ifnotnull());
        putInstruction(new ifnull());
        putInstruction(new wide());


        putInstruction(new aaload());
        putInstruction(new aload());
        putInstruction(new aload_0());
        putInstruction(new aload_1());
        putInstruction(new aload_2());
        putInstruction(new aload_3());
        putInstruction(new baload());
        putInstruction(new caload());
        putInstruction(new daload());
        putInstruction(new dload());
        putInstruction(new dload_0());
        putInstruction(new dload_1());
        putInstruction(new dload_2());
        putInstruction(new dload_3());
        putInstruction(new faload());
        putInstruction(new fload());
        putInstruction(new fload_0());
        putInstruction(new fload_1());
        putInstruction(new fload_2());
        putInstruction(new fload_3());
        putInstruction(new iaload());
        putInstruction(new iload());
        putInstruction(new iload_0());
        putInstruction(new iload_1());
        putInstruction(new iload_2());
        putInstruction(new iload_3());
        putInstruction(new laload());
        putInstruction(new lload());
        putInstruction(new lload_0());
        putInstruction(new lload_1());
        putInstruction(new lload_2());
        putInstruction(new lload_3());
        putInstruction(new saload());
        putInstruction(new xaload());


        putInstruction(new dadd());
        putInstruction(new ddiv());
        putInstruction(new dmul());
        putInstruction(new dneg());
        putInstruction(new drem());
        putInstruction(new dsub());
        putInstruction(new fadd());
        putInstruction(new fdiv());
        putInstruction(new fmul());
        putInstruction(new fneg());
        putInstruction(new frem());
        putInstruction(new fsub());
        putInstruction(new iadd());
        putInstruction(new iand());
        putInstruction(new idiv());
        putInstruction(new iinc());
        putInstruction(new imul());
        putInstruction(new ineg());
        putInstruction(new ior());
        putInstruction(new irem());
        putInstruction(new ishl());
        putInstruction(new ishr());
        putInstruction(new isub());
        putInstruction(new iushr());
        putInstruction(new ixor());
        putInstruction(new ladd());
        putInstruction(new land());
        putInstruction(new ldiv());
        putInstruction(new lmul());
        putInstruction(new lneg());
        putInstruction(new lor());
        putInstruction(new lrem());
        putInstruction(new lshl());
        putInstruction(new lshr());
        putInstruction(new lsub());
        putInstruction(new lushr());
        putInstruction(new lxor());


        putInstruction(new dup());
        putInstruction(new dup2());
        putInstruction(new dup2_x1());
        putInstruction(new dup2_x2());
        putInstruction(new dup_x1());
        putInstruction(new dup_x2());
        putInstruction(new pop());
        putInstruction(new pop2());
        putInstruction(new swap());

        putInstruction(new astore());
        putInstruction(new astore_0());
        putInstruction(new astore_1());
        putInstruction(new astore_2());
        putInstruction(new astore_3());
        putInstruction(new dstore());
        putInstruction(new dstore_0());
        putInstruction(new dstore_1());
        putInstruction(new dstore_2());
        putInstruction(new dstore_3());
        putInstruction(new fstore());
        putInstruction(new fstore_0());
        putInstruction(new fstore_1());
        putInstruction(new fstore_2());
        putInstruction(new fstore_3());
        putInstruction(new istore());
        putInstruction(new istore_0());
        putInstruction(new istore_1());
        putInstruction(new istore_2());
        putInstruction(new istore_3());
        putInstruction(new lstore());
        putInstruction(new lstore_0());
        putInstruction(new lstore_1());
        putInstruction(new lstore_2());
        putInstruction(new lstore_3());

    }

    private static void putInstruction(Instruction instruction){
        codeMap.put(instruction.getOpCode(), instruction);
        nameMap.put(instruction.getReName(), instruction);
    }


}
