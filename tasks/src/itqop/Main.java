package itqop;
public class Main extends FirstBlock{

    public static void main(String[] args) {
        ///// 1 block
        // 1.1
        System.out.println(remainder(3,2));
        // 1.2
        System.out.println("#2");
        int x = triArea(3,2);
        System.out.println(x);
        // 1.3
        System.out.println("#3");
        int c = animals(1,2,3);
        System.out.println(c);
        // 1.4
        System.out.println("#4");
        System.out.println(profitableGamble(0.9 ,1,2));
        // 1.5
        System.out.println("#5");
        System.out.println(operation(24,26,2));
        // 1.6
        System.out.println("#6");
        System.out.println(ctoa('m'));
        // 1.7
        System.out.println("#7");
        int n;
        n = addUpTo(3);
        System.out.println(n);
        // 1.8
        System.out.println("#8");
        int w;
       // w = nextEdge(5,7);
       // System.out.println(w);
        // 1.9
        System.out.println("#9");
        int[] q = {3, 4, 5};
        int s = sumOfCubes(q);
        System.out.println(s);
        // 1.10
        System.out.println("#10");
        System.out.println(abcmath(42,5,10));

        ///// 2 block
        // 2.1

        System.out.println(repeat("mice",4));
        // 2.2
        int[] mms = {10, 4, 1, 4, -10, -50, 32, 21};
        System.out.println( differenceMaxMin(mms));
        // 2.3
        int[] mmss = {1,3};
        System.out.println(isAvgWhole(mmss));
        // 2.4
        int[] mmssw = {1,2,3};
        int[] ure = cumulativeSum(mmssw);
        for (int i = 0; i < ure.length; i++) {
            System.out.print(ure[i]+ " ");
        }
        System.out.println("");
        // 2.5
        System.out.println(getDecimalPlaces("43.2"));
        // 2.6
        System.out.println(Fibonacci(12));
        // 2.7
        System.out.println(isValid("11344"));
        // 2.8
        System.out.println(isStrangePair("sush","hubris"));
        // 2.9
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        // 2.10
        System.out.println(boxSeq(2));

        ///// 3 block
        // 3.1
        System.out.println("------------------------3----------------------------");
        System.out.println(solutions(6,23,1));
        // 3.2
        System.out.println(findZip("all zip files are zipped"));
        // 3.3
        System.out.println(checkPerfect(97));
        // 3.4
        System.out.println(flipEndChars("adauuuua Hello"));
        // 3.5
        System.out.println(isValidHexCode("#CDcC5F"));
        // 3.6
        int[] arr1 = {1,2,3};//{1,3,4,4,4,36,1};
        int[] arr2 = {1,2,3212,3212};//{5,123,43,123,0};
        System.out.println(same(arr1,arr2));
        // 3.7
        System.out.println(isKaprekar(297));
        // 3.8
        System.out.println(longestZero("01100000001011000000"));
        // 3.9
        System.out.println(nextPrime(12));
        // 3.10
        System.out.println(rightTriangle(3,4,5));
        System.out.println("------------------------3----------------------------");

        ///// 4 block
        // 4.1
        System.out.println(bala("10,7 hello my name is Bessie and this is my essay"));
        // 4.2
        System.out.println(split("((()))(())()()(()())"));
        // 4.3
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(toSnakeCase("getColor"));
        // 4.4
        double[] dd = {13.25, 15, 30, 1.5};
        System.out.println(overTime(dd));
        // 4.5
        System.out.println(BMI("84.9 kilos", "1.86 meters"));
        // 4.6
        System.out.println(bugger(39));
        // 4.7
        System.out.println(toStarShorthand("abbcccwwwwe"));
        // 4.8
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        // 4.9
        System.out.println(trouble(33789, 12345337));
        // 4.10
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));

        ///// 5 block
        // 5.1
        System.out.println(encrypt("Sunshine"));
        int[] in = {72, 33, -73, 84, -12, -3, 13, -13, -68 };
        System.out.println(decrypt(in));
        // 5.2
        System.out.println(canMove("Rook", "A8", "H8"));
        // 5.3
        System.out.println(canComplete("butl", "beautiful"));
        // 5.4
        System.out.println(sumDigProd(16,28));
        // 5.5
        //String[] wert = {"toe", "ocelot", "maniac"};
        //String[] wert = {"many", "carriage", "emit", "apricot", "animal"};
        String[] wert = {"hoops", "chuff", "bot", "bottom"};
        System.out.println(sameVowelGroup(wert));
        // 5.6
        System.out.println(validateCard(1234567890123452l));
        // 5.7
        System.out.println(numToEng(10));
        System.out.println(numToRus(999));
        // 5.8
        System.out.println(getSha256Hash("password123")); //patom
        // 5.9
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        // 5.10
        System.out.println(hexLattice(37));



        ///// 6 block
        // 6.1
        System.out.println();
        // 6.2
        System.out.println();
        // 6.3
        System.out.println();
        // 6.4
        System.out.println();
        // 6.5
        System.out.println();
        // 6.6
        System.out.println();
        // 6.7
        System.out.println();
        // 6.8
        System.out.println();
        // 6.9
        System.out.println();
        // 6.10
        System.out.println();
//2 ���������



    }
}
