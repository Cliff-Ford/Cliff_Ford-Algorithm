package cliff.ford.algorithm.security.hash.md5;


/**
 * @author Cliff_Ford
 */
public class MD5 {
    /**
     * 四个链接变量
     */
    private static final int A = 0x67452301;
    private static final int B = 0xefcdab89;
    private static final int C = 0x98badcfe;
    private static final int D = 0x10325476;

    /**
     * A B C D的临时变量
     */
    private static int aTemp, bTemp, cTemp, dTemp;

    /**
     * 常量ti
     * 公式:floor(abs(sin(i+1))×(2pow32)
     */

    /**
     * 循环左移数,计算方法未知
     */
    private static final int[] S = {
            7,12,17,22,7,12,17,22,7,12,17,22,7,
            12,17,22,5,9,14,20,5,9,14,20,5,9,14,20,5,9,14,20,
            4,11,16,23,4,11,16,23,4,11,16,23,4,11,16,23,6,10,
            15,21,6,10,15,21,6,10,15,21,6,10,15,21};

    private static final int[] K = {
            0xd76aa478, 0xe8c7b756, 0x242070db, 0xc1bdceee,
            0xf57c0faf, 0x4787c62a, 0xa8304613, 0xfd469501, 0x698098d8,
            0x8b44f7af, 0xffff5bb1, 0x895cd7be, 0x6b901122, 0xfd987193,
            0xa679438e, 0x49b40821, 0xf61e2562, 0xc040b340, 0x265e5a51,
            0xe9b6c7aa, 0xd62f105d, 0x02441453, 0xd8a1e681, 0xe7d3fbc8,
            0x21e1cde6, 0xc33707d6, 0xf4d50d87, 0x455a14ed, 0xa9e3e905,
            0xfcefa3f8, 0x676f02d9, 0x8d2a4c8a, 0xfffa3942, 0x8771f681,
            0x6d9d6122, 0xfde5380c, 0xa4beea44, 0x4bdecfa9, 0xf6bb4b60,
            0xbebfbc70, 0x289b7ec6, 0xeaa127fa, 0xd4ef3085, 0x04881d05,
            0xd9d4d039, 0xe6db99e5, 0x1fa27cf8, 0xc4ac5665, 0xf4292244,
            0x432aff97, 0xab9423a7, 0xfc93a039, 0x655b59c3, 0x8f0ccc92,
            0xffeff47d, 0x85845dd1, 0x6fa87e4f, 0xfe2ce6e0, 0xa3014314,
            0x4e0811a1, 0xf7537e82, 0xbd3af235, 0x2ad7d2bb, 0xeb86d391};
    /**
     * 初始化函数
     */
    private static void init(){
        aTemp = A;
        bTemp = B;
        cTemp = C;
        dTemp = D;
    }

    /**
     * 1. 一个字符 c 可以用一个字节byte来表示，也就是8个bits
     * 2. md5规定在最后填充一个8个字节长的，也就是64bits的，表示源字符串长度的数据
     * 3. 512bits为一组，也就是64字节为一组
     * @param message 源字符串
     * @return 返回一个整型数组 注意一个int可以填充4个byte
     */
    private static int[] add(String message) {
        //分组数
        int numOfGroup = ((message.length()+8)/64)+1;
        //这里用了int去存储byte, 1 int = 4 bytes，所以只需要numOfGroup*16个int即可完整存储
        //int默认初始为0
        int[] strByte = new int[numOfGroup*16];
        int i = 0;
        for(int len = message.length(); i < len; i++){
            // i>>2 是 i 除以 4的意思，保证每次取出来的字符(byte)都可以存进对应的int里面，因为 1 int = 4 bytes
            // message.charAt(i)<<((i%4)*8) 注意虽然message.charAt(i)取出来的是一个字节，只有8个bits,但是前面的strByte[i>>2]是32bits
            // 所以这里jvm给我们做了精度调整，message.charAt(i)有32个bits
            // 所以message.charAt(i)<<((i%4)*8)左移运算后strByte[i>>2]进行或运算就保证了前一个byte的数据不会被覆盖
            strByte[i>>2] = strByte[i>>2] | message.charAt(i)<<((i%4)*8);
        }
        //尾部添加1
        strByte[i>>2]= strByte[i>>2] | (0x80<<((i%4)*8));
        //添加原长度，长度指bit的长度，所以要乘8，然后是小端序，所以放在倒数第二个,这里长度只用了32位
        //最后两个int 即8个byte 即64bits
        strByte[numOfGroup*16-2]=message.length()*8;
        return strByte;
    }

    /**
     * 主循环
     * @param m 每一组的计算，注意int[]长度为16，相当于64bytes,512bits
     */
    private static void mainLoop(int m[]){
        int F,g;
        //保存4个临时变量
        int a = aTemp;
        int b = bTemp;
        int c = cTemp;
        int d = dTemp;
        //组队进行64轮运算
        //每次操作对a、b、c和d中的其中三个作一次非线性函数运算,也就是下面的F,注意F的运算只用到了bcd
        //然后将所得结果加上第四个变量,也就是a
        //再加上文本的一个子分组，即m[g]
        //再加上一个常数，即K[i]
        //再将所得结果向左环移一个不定的数,即shift(var, S[i])中的S[i]
        for(int i = 0; i < 64; i++){
            //这里的F在i取不同的值时有不同的计算规则，也就是传说中的 F G H I函数，是一次非线性运算
            if(i < 16){
                //0-15号字节的计算方式
                F = (b&c)|((~b)&d);
                g = i;
            }else if(i<32){
                //16-31号字节的计算方式
                F = (d&b)|((~d)&c);
                g = (5*i+1)%16;
            }else if(i<48){
                //31-47号字节的计算方式
                F = b^c^d;
                g = (3*i+5)%16;
            }else{
                //48-63号字节的计算方式
                F = c^(b|(~d));
                g = (7*i)%16;
            }
            //b c 向后覆盖
            int tmp = d;
            d = c;
            c = b;
            //重新计算b
            b = b + shift(a+F+K[i]+m[g], S[i]);
            //注意这里将d的值赋予了a,下一组shift运算是a起到了调参的作用
            a = tmp;
        }
        //更新临时变量，用于下一组的计算，注意这里的表述是下一组，不是下一轮
        aTemp = a + aTemp;
        bTemp = b + bTemp;
        cTemp = c + cTemp;
        dTemp = d + dTemp;

    }

    /**
     * 移动一定位数
     * 右移的时候，高位一定要补零，而不是补充符号位
     */
    private static int shift(int a, int s){
        return (a<<s) | (a>>>(32-s));
    }

    /**
     *整数变成16进制字符串
     */
    private static String changeHex(int a){
        StringBuilder str= new StringBuilder();
        for(int i=0;i<4;i++){
            str.append(String.format("%2s", Integer.toHexString(((a >> i * 8) % (1 << 8)) & 0xff)).replace(' ', '0'));

        }
        return str.toString();
    }


    public static String encryption(String message){
        init();
        int[] strByte = add(message);
        //每512bits为一组，也就是64个bytes,16个int
        for(int i = 0; i < strByte.length/16; i++) {
            //取出每组对应的数据
            int[] num = new int[16];
            System.arraycopy(strByte, i*16, num, 0, 16);
            //传给主循环，进行64轮运算
            mainLoop(num);
        }
        return changeHex(aTemp)+changeHex(bTemp)+changeHex(cTemp)+changeHex(dTemp);
    }


}
