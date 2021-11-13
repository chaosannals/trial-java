package trial.java.asmdemo;

import java.lang.reflect.*;
import org.objectweb.asm.*;

public class AsmNewClass {
    public static final String CLASS_NAME = "trial/java/asm/AsmNewClassDemo";

    /**
     * 加载字节数组的类加载器。
     * 
     */
    public static class AsmNewClassLoader extends ClassLoader {
        public Class<?> load(byte[] asms) {
            return super.defineClass(CLASS_NAME.replace('/', '.'), asms, 0, asms.length);
        }
    }

    /**
     * 生成并加载新类并执行。
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static void execNewClass() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        byte[] asms = newClass();
        AsmNewClassLoader loader = new AsmNewClassLoader();
        Class<?> nc = loader.load(asms);
        Method m = nc.getMethod("main", String[].class);
        m.invoke(null, new Object[] {new String[] {}});
    }

    /**
     * 生成个新类。
     * @return
     */
    public static byte[] newClass() {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(Opcodes.V16, Opcodes.ACC_PUBLIC, CLASS_NAME, null, "java/lang/Object", null);

        // 方法
        MethodVisitor mv = cw.visitMethod(
            Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, 
            "main", 
            "([Ljava/lang/String;)V",
            null,
            null
        );
        // System.out.print("Asm New Class Demo");
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("Asm New Class Demo");
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(2, 1);
        mv.visitEnd();
        cw.visitEnd();
        return cw.toByteArray();
    }
}
